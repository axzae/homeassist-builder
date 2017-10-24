package com.axzae.homeassistant.util;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommonUtil {

    public static Gson getGson() {
        return new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSSZZZZZ")
                .create();
    }

    public static String deflate(Object object) {
        return new Gson().toJson(object);
    }

    public static <T> T inflate(String json, Class<T> classOfT) {
        return new Gson().fromJson(json, classOfT);
    }

    public static String readFromAssets(Context context, String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(context.getAssets().open(filename)));

        // do reading, usually loop until end of file reading
        StringBuilder sb = new StringBuilder();
        String mLine = reader.readLine();
        while (mLine != null) {
            sb.append(mLine).append("\n"); // process line
            mLine = reader.readLine();
        }
        reader.close();
        return sb.toString();
    }
}
