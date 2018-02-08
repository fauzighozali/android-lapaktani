package com.mediasoftindonesia.uploadfoto;

import com.google.gson.annotations.SerializedName;

/**
 * Created by macair on 9/24/17.
 */

public class ImageClass {
    @SerializedName("title")
    private String Title;

    @SerializedName("image")
    private String Image;

    @SerializedName("response")
    private String Response;

    public String getResponse() {
        return Response;
    }



}
