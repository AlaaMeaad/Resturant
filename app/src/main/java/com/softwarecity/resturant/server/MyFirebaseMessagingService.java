package com.softwarecity.resturant.server;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.util.Log;


import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.softwarecity.resturant.constant.AppConstant;
import com.softwarecity.resturant.helper.NotificationUtils;
import com.softwarecity.resturant.ui.MainActivity;

import org.json.JSONException;
import org.json.JSONObject;

import androidx.annotation.RequiresApi;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

public class MyFirebaseMessagingService extends FirebaseMessagingService {


    private static final String TAG = "MessagingService";
    private static final String TYPE = "type";
    private static final String ID = "id";


    private NotificationUtils notificationUtils;


    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        Log.e(TAG, "From: " + remoteMessage.getFrom());

        if (remoteMessage == null)
            return;

        // Check if message contains a notification payload.
        if (remoteMessage.getNotification() != null) {
            Log.e(TAG, "Notification Title: " + remoteMessage.getNotification().getTitle());
            Log.e(TAG, "Notification Body: " + remoteMessage.getNotification().getBody());
            Log.e(TAG, "Notification icon: " + remoteMessage.getNotification().getIcon());
            Log.e(TAG, "Notification color: " + remoteMessage.getNotification().getColor());
            if (remoteMessage.getData().size() > 0) {
                Log.e(TAG, "Data Payload: " + remoteMessage.getData().toString());
                try {
                    JSONObject json = new JSONObject(remoteMessage.getData());
                    handleNotification(remoteMessage.getNotification().getBody(), remoteMessage.getNotification().getTitle(), json);
                } catch (Exception e) {
                    Log.e(TAG, "Exception: " + e.getMessage());
                }
            }else {
                handleNotification(remoteMessage.getNotification().getBody(), remoteMessage.getNotification().getTitle(), null);

            }
        }


    }

    private void handleNotification(String message, String title, JSONObject json) {

        if (!NotificationUtils.isAppIsInBackground(getApplicationContext())) {
            // app is in foreground, broadcast the push message
            handleDataMessage(json, message, title, true, true);

        }else{
            // app is in background, broadcast the push message
            handleDataMessage(json, message, title, true, true);
            //playSound();
        }
    }

    private void playSound() {
        try {
            Uri alarmSound = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE
                    + "://" + getApplicationContext().getPackageName() + "/raw/notification");
            Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), alarmSound);
            r.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void handleDataMessage(JSONObject json, String message, String title,
                                   boolean notificationLocation,
                                   boolean showNotification) {

        if (json != null){
            Log.i("notification", json.toString());
            String type , id;
            try {
                id = json.getString(ID);
                if (showNotification){
                    Intent resultIntent = new Intent(this, MainActivity.class);
                    resultIntent.putExtra(ID, id);
                    showNotificationMessage(getApplicationContext(),title, message, resultIntent);
                }
                Intent pushNotification = new Intent(AppConstant.PUSH_NOTIFICATION);
                pushNotification.putExtra(ID, id);
                LocalBroadcastManager.getInstance(this).sendBroadcast(pushNotification);
            } catch (JSONException e) {
                Log.e(TAG, "Exception: " + e.getMessage());
            }
        }else {
            if (showNotification){
                Intent resultIntent = new Intent(this, MainActivity.class);
                showNotificationMessage(getApplicationContext(),title, message, resultIntent);
            }
            Intent pushNotification = new Intent(AppConstant.PUSH_NOTIFICATION);
            LocalBroadcastManager.getInstance(this).sendBroadcast(pushNotification);
        }

    }


    @RequiresApi(api = Build.VERSION_CODES.Q)
    private void sendNotification(String message) {
        Log.e(TAG, "Message: " + message);
        if (!NotificationUtils.isAppIsInBackground(getApplicationContext())) {
            // app is in foreground, broadcast the push message
            Intent pushNotification = new Intent(AppConstant.PUSH_NOTIFICATION);
            LocalBroadcastManager.getInstance(this).sendBroadcast(pushNotification);
        }else{
            // app is in background, broadcast the push message
            // TODO uncomment those two lines of code
            //Intent resultIntent = new Intent(this, SplashScreen.class);
            //showNotificationMessage(getApplicationContext(), "fsd", message, resultIntent);
        }
    }


    /**
     * Showing notification with text only
     */

    private void showNotificationMessage(Context context, String title, String message, Intent intent) {
        notificationUtils = new NotificationUtils(context);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        notificationUtils.showNotificationMessage(title, message, intent);
    }

}