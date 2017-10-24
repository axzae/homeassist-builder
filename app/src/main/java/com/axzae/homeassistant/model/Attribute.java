package com.axzae.homeassistant.model;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Attribute {
    @SerializedName("entity_id")
    public ArrayList<String> entityIds;
//    public String entityId;

    @SerializedName("assumed_state")
    public String assumedState;

    @SerializedName("friendly_name")
    public String friendlyName;

    @SerializedName("entity_picture")
    public String entityPicture;

    @SerializedName("icon")
    public String icon;

    @SerializedName("title")
    public String title;

    @SerializedName("brightness")
    public BigDecimal brightness;

    @SerializedName("color_temp")
    public BigDecimal colorTemp;

    @SerializedName("rgb_color")
    public ArrayList<BigDecimal> rgbColors;

    @SerializedName("options")
    public ArrayList<String> options;

    @SerializedName("order")
    public Integer order;

    @SerializedName("auto")
    public Boolean auto;

    @SerializedName("hidden")
    public Boolean hidden;

    @SerializedName("view")
    public Boolean view;

    @SerializedName("name")
    public String name;

    @SerializedName("initial")
    public Integer initial;

    @SerializedName("max")
    public BigDecimal max;

    @SerializedName("min")
    public BigDecimal min;

    @SerializedName("step")
    public BigDecimal step;

    //https://home-assistant.io/blog/2017/08/12/release-51/#release-0512---august-14
    @SerializedName("release_notes")
    public Boolean releaseNotes;

    @SerializedName("unit_of_measurement")
    public String unitOfMeasurement;

    public int getNumberOfDecimalPlaces() {
        String string = step.stripTrailingZeros().toPlainString();
        int index = string.indexOf(".");
        return index < 0 ? 0 : string.length() - index - 1;
    }

    public boolean isView() {
        return view != null && view;
    }

}