package com.axzae.homeassistant.fragment.control;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.Dialog;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;

import com.axzae.homeassistant.R;
import com.axzae.homeassistant.model.Entity;
import com.axzae.homeassistant.model.rest.CallServiceRequest;
import com.axzae.homeassistant.util.CommonUtil;
import com.flask.colorpicker.ColorPickerView;
import com.flask.colorpicker.OnColorChangedListener;

/**
 * Simple fragment with blur effect behind.
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class LightFragment extends BaseControlFragment implements View.OnClickListener {

    private ColorPickerView mColorPickerView;

    public static LightFragment newInstance(Entity entity) {
        LightFragment fragment = new LightFragment();
        Bundle args = new Bundle();
        args.putString("entity", CommonUtil.deflate(entity));
        fragment.setArguments(args);
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View view = getActivity().getLayoutInflater().inflate(R.layout.control_light, null);
        //TextView label = view.findViewById(R.id.textView);
        //label.setMovementMethod(LinkMovementMethod.getInstance());
        //Linkify.addLinks(label, Linkify.WEB_URLS);
        builder.setView(view);
        builder.setTitle(mEntity.getFriendlyName());

        view.findViewById(R.id.button_cancel).setOnClickListener(this);
        view.findViewById(R.id.button_set).setOnClickListener(this);

        mColorPickerView = view.findViewById(R.id.color_picker_view);
        if (mEntity.attributes.rgbColors != null) {
            mColorPickerView.setColor(Color.rgb(
                    mEntity.attributes.rgbColors.get(0).intValue(),
                    mEntity.attributes.rgbColors.get(1).intValue(),
                    mEntity.attributes.rgbColors.get(2).intValue()), true);
        }
        mColorPickerView.addOnColorChangedListener(new OnColorChangedListener() {
            @Override
            public void onColorChanged(int selectedColor) {
                Log.d("HomeAssist", "addOnColorChangedListener:" + Integer.toHexString(selectedColor));
            }
        });


        return builder.create();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_cancel:
                dismiss();
                break;
            case R.id.button_set:
                int selectedColor = mColorPickerView.getSelectedColor();
                callService(mEntity.getDomain(), "turn_on", new CallServiceRequest(mEntity.entityId).setRGBColor(selectedColor));
                dismiss();
        }
    }

}
