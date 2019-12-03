
package com.softwarecity.resturant.dataSource.model.category;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Sub {

    @SerializedName("CategoryID")
    @Expose
    private String categoryID;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("CategoryImage")
    @Expose
    private String categoryImage;
    @SerializedName("Position")
    @Expose
    private Object position;
    @SerializedName("CategoryIsActive")
    @Expose
    private String categoryIsActive;
    @SerializedName("offerstartdate")
    @Expose
    private String offerstartdate;
    @SerializedName("offerendate")
    @Expose
    private String offerendate;
    @SerializedName("isoffer")
    @Expose
    private String isoffer;
    @SerializedName("parentid")
    @Expose
    private String parentid;
    @SerializedName("UserIDInserted")
    @Expose
    private String userIDInserted;
    @SerializedName("UserIDUpdated")
    @Expose
    private String userIDUpdated;
    @SerializedName("UserIDLocked")
    @Expose
    private String userIDLocked;
    @SerializedName("DateInserted")
    @Expose
    private String dateInserted;
    @SerializedName("DateUpdated")
    @Expose
    private String dateUpdated;
    @SerializedName("DateLocked")
    @Expose
    private String dateLocked;
    @SerializedName("sub")
    @Expose
    private List<Object> sub = null;

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategoryImage() {
        return categoryImage;
    }

    public void setCategoryImage(String categoryImage) {
        this.categoryImage = categoryImage;
    }

    public Object getPosition() {
        return position;
    }

    public void setPosition(Object position) {
        this.position = position;
    }

    public String getCategoryIsActive() {
        return categoryIsActive;
    }

    public void setCategoryIsActive(String categoryIsActive) {
        this.categoryIsActive = categoryIsActive;
    }

    public String getOfferstartdate() {
        return offerstartdate;
    }

    public void setOfferstartdate(String offerstartdate) {
        this.offerstartdate = offerstartdate;
    }

    public String getOfferendate() {
        return offerendate;
    }

    public void setOfferendate(String offerendate) {
        this.offerendate = offerendate;
    }

    public String getIsoffer() {
        return isoffer;
    }

    public void setIsoffer(String isoffer) {
        this.isoffer = isoffer;
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid;
    }

    public String getUserIDInserted() {
        return userIDInserted;
    }

    public void setUserIDInserted(String userIDInserted) {
        this.userIDInserted = userIDInserted;
    }

    public String getUserIDUpdated() {
        return userIDUpdated;
    }

    public void setUserIDUpdated(String userIDUpdated) {
        this.userIDUpdated = userIDUpdated;
    }

    public String getUserIDLocked() {
        return userIDLocked;
    }

    public void setUserIDLocked(String userIDLocked) {
        this.userIDLocked = userIDLocked;
    }

    public String getDateInserted() {
        return dateInserted;
    }

    public void setDateInserted(String dateInserted) {
        this.dateInserted = dateInserted;
    }

    public String getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(String dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public String getDateLocked() {
        return dateLocked;
    }

    public void setDateLocked(String dateLocked) {
        this.dateLocked = dateLocked;
    }

    public List<Object> getSub() {
        return sub;
    }

    public void setSub(List<Object> sub) {
        this.sub = sub;
    }

}
