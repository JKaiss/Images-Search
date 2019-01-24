
package com.jaafoura.searchimage.data.model;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Model urls different url sizes
 */
public class Urls {

    @SerializedName("regular")
    @Expose
    private String regular;
    @SerializedName("thumb")
    @Expose
    private String thumb;

    public String getRegular() {
        return regular;
    }

    public void setRegular(String regular) {
        this.regular = regular;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

}