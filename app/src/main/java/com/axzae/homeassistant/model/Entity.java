package com.axzae.homeassistant.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.axzae.homeassistant.util.CommonUtil;
import com.google.gson.annotations.SerializedName;

public class Entity {
    public static Entity getInstance(Context context, String filename) {
        try {
            return CommonUtil.inflate(CommonUtil.readFromAssets(context, filename), Entity.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @SerializedName("entity_id")
    public String entityId;

    //on
    @SerializedName("state")
    public String state;

    //2017-08-14T15:50:46.810842+00:00
    @SerializedName("last_updated")
    public String lastUpdated;

    //2017-08-14T15:50:46.810842+00:00
    @SerializedName("last_changed")
    public String lastChanged;

    @SerializedName("attributes")
    public Attribute attributes;

    @SerializedName("checksum")
    public String checksum;

    @SerializedName("displayOrder")
    public Integer displayOrder;

    public int getDisplayOrder() {
        return (displayOrder == null) ? 1000 : displayOrder;
    }

    public static Entity getInstance(Cursor cursor) {
        Entity entity = null;
        try {
            entity = CommonUtil.inflate(cursor.getString(cursor.getColumnIndex("RAW_JSON")), Entity.class);
            entity.checksum = cursor.getString(cursor.getColumnIndex("CHECKSUM"));
            if (cursor.getColumnIndex("DISPLAY_ORDER") != -1) {
                entity.displayOrder = cursor.getInt(cursor.getColumnIndex("DISPLAY_ORDER"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entity;
    }

    public String getDomain() {
        return entityId.split("\\.")[0];
    }

    public String getFriendlyName() {
        return (attributes == null || attributes.friendlyName == null) ? "" : attributes.friendlyName;
    }

    public boolean isHidden() {
        return attributes != null && attributes.hidden != null && attributes.hidden;
    }

    public boolean isSupported() {
        return getFriendlyState() != null && entityId != null && !getFriendlyName().equals("");
    }

    public boolean isDisplayTile() {
        return attributes.unitOfMeasurement != null;
    }

    public boolean isSwitch() {
        return entityId.startsWith("switch.");
    }

    public boolean isLight() {
        return entityId.startsWith("light.");
    }

    public boolean isMediaPlayer() {
        return entityId.startsWith("media_player.");
    }

    public boolean isSensor() {
        return entityId.startsWith("sensor.");
    }

    public boolean isAnySensors() {
        return entityId.contains("sensor.");
    }

    public boolean isGroup() {
        return entityId.startsWith("group.");
    }

    public boolean isAutomation() {
        return entityId.startsWith("automation.");
    }

    public boolean isScript() {
        return entityId.startsWith("script.");
    }

    public boolean isInputSelect() {
        return entityId.startsWith("input_select.");
    }

    public boolean isInputSlider() {
        return entityId.startsWith("input_slider.");
    }

    public boolean isInputBoolean() {
        return entityId.startsWith("input_boolean.");
    }

    public boolean isPersistentNotification() {
        return entityId.startsWith("persistent_notification.");
    }

    public boolean isBinarySensor() {
        return entityId.startsWith("binary_sensor.");
    }

    public boolean hasIndicator() {
        return !(entityId.startsWith("updater.") || entityId.startsWith("sun.") || isAnySensors());
    }

    public String getGroupName() {
        return (isSensor() && attributes.unitOfMeasurement != null) ? attributes.unitOfMeasurement : getFriendlyDomainName();
    }

    public boolean hasMdiIcon() {
        return attributes.icon != null && attributes.icon.startsWith("mdi:");
    }

    public String getFriendlyDomainName() {
        String domain = getDomain();
        if (isInputSelect()) {
            return "Input Select";
        }

        if (isInputSlider()) {
            return "Input Slider";
        }

        if (isInputBoolean()) {
            return "Input Boolean";
        }

        if (isBinarySensor()) {
            return "Binary Sensor";
        }

        if (isMediaPlayer()) {
            return "Media Player";
        }

        if (isPersistentNotification()) {
            return "Notification";
        }

        return domain.substring(0, 1).toUpperCase() + domain.substring(1);
    }

    public boolean hasStateIcon() {
        if (isLight() || isSwitch() || isScript() || isAutomation()) {
            return true;
        } else if (isBinarySensor() && hasMdiIcon()) {
            if (hasMdiIcon()) return true;
        } else if (isInputBoolean() && hasMdiIcon()) {
            if (hasMdiIcon()) return true;
        }

        return false;
    }

    public String getFriendlyState() {
        if (isSwitch() || isLight() || isAutomation() || isBinarySensor() || isScript() || isInputBoolean() || isMediaPlayer() || isGroup()) {
            return state.toUpperCase();
        } else {
            return state;
        }
    }

    public boolean isActivated() {
        return state.toUpperCase().equals("ON");
    }

    public ContentValues getContentValues(boolean withId) {
        String rawJson = CommonUtil.deflate(this);
        ContentValues initialValues = new ContentValues();
        if (withId) initialValues.put("ENTITY_ID", entityId);
        initialValues.put("FRIENDLY_NAME", getFriendlyName());
        initialValues.put("DOMAIN", getDomain());
        initialValues.put("RAW_JSON", rawJson);
        //initialValues.put("CHECKSUM", CommonUtil.md5(rawJson));
        return initialValues;
    }

    public ContentValues getContentValues() {
        return getContentValues(true);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null)
            return false;
        if (this == o)
            return true;
        if (!(o instanceof Entity))
            return false;

        final Entity other = (Entity) o;
//        if (this.checksum == null || other.checksum == null) {
//            throw new RuntimeException("checksum is null");
//        }
        return this.entityId.equals(other.entityId);
    }

    public boolean isToggleable() {
        return isSwitch() || isLight() || isAutomation() || isScript() || isInputBoolean() || isMediaPlayer() || isGroup();
    }
}