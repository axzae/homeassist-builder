package com.axzae.homeassistant.fragment.control;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;

import com.axzae.homeassistant.model.Entity;
import com.axzae.homeassistant.model.rest.CallServiceRequest;
import com.axzae.homeassistant.shared.EntityProcessInterface;
import com.axzae.homeassistant.util.CommonUtil;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class BaseControlFragment extends DialogFragment {
    protected Entity mEntity;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        mEntity = CommonUtil.inflate(args.getString("entity"), Entity.class);
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);

        //https://stackoverflow.com/questions/23786033/dialogfragment-and-ondismiss
        final Activity activity = getActivity();
        if (activity instanceof DialogInterface.OnDismissListener) {
            ((DialogInterface.OnDismissListener) activity).onDismiss(dialog);
        }
    }

    @Override
    public void onDestroyView() {
        if (getDialog() != null) {
            getDialog().setDismissMessage(null);
        }
        super.onDestroyView();
    }

    protected void callService(String domain, String service, CallServiceRequest callServiceRequest) {
        Activity activity = getActivity();
        if (activity instanceof EntityProcessInterface) {
            ((EntityProcessInterface) activity).callService(domain, service, callServiceRequest);
        } else {
            throw new RuntimeException(activity.getClass().getName() + " IS NOT EntityProcessInterface");
        }
    }
}
