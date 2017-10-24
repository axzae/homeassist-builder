package com.axzae.homeassistant.model.rest;

import android.graphics.Color;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class CallServiceRequest {

    public CallServiceRequest(String entityId) {
        this.entityId = entityId;
    }

    @SerializedName("entity_id")
    public String entityId;

    @SerializedName("option")
    public String option;

    @SerializedName("value")
    public String value;

    @SerializedName("rgb_color")
    public Integer[] rgbColor;

    public CallServiceRequest setOption(String option) {
        this.option = option;
        return this;
    }

    public CallServiceRequest setValue(String value) {
        this.value = value;
        return this;
    }

    public CallServiceRequest setRGBColor(int rgbColor) {
        this.rgbColor = new Integer[]{Color.red(rgbColor), Color.green(rgbColor), Color.blue(rgbColor)};
        return this;
    }

    public String toString() {
        return (new Gson()).toJson(this);
    }
}
