package com.softwarecity.resturant.server;

import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;


import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.softwarecity.resturant.constant.AppConstant;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;

public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {

    private static final String TAG = "FirebaseIDService";

    @Override
    public void onTokenRefresh() {
        // Get updated InstanceID token.
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.i(TAG, "Refreshed token: " + refreshedToken);

        // TODO: Implement this method to send any registration to your app's servers.
        sendRegistrationToServer(refreshedToken);

        // TODO: Notify UI that registration has completed
        Intent registrationComplete = new Intent(AppConstant.REGISTRATION_COMPLETE);
        registrationComplete.putExtra("token", refreshedToken);
        LocalBroadcastManager.getInstance(this).sendBroadcast(registrationComplete);
    }

    /**
     * Persist token to third-party servers.
     *
     * Modify this method to associate the user's FCM InstanceID token with any server-side account
     * maintained by your application.
     *
     * @param token The new token.
     */
    private void sendRegistrationToServer(String token) {
        // Add custom implementation, as needed.
        // TODO: sending gcm token to server
        Log.e(TAG, "sendRegistrationToServer: " + token);
        SharedPreferences pref = getApplicationContext().getSharedPreferences("PREF", 0);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(AppConstant.FIREBASE_ID, token);
        editor.commit();
    }
}