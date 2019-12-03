
package com.softwarecity.resturant.dataSource.model.category;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Category {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("categorylist")
    @Expose
    private List<Categorylist> categorylist = null;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<Categorylist> getCategorylist() {
        return categorylist;
    }

    public void setCategorylist(List<Categorylist> categorylist) {
        this.categorylist = categorylist;
    }

}
