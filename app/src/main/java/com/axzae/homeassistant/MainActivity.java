package com.axzae.homeassistant;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.axzae.homeassistant.fragment.control.InputSliderFragment;
import com.axzae.homeassistant.fragment.control.LightFragment;
import com.axzae.homeassistant.model.Entity;
import com.axzae.homeassistant.model.rest.CallServiceRequest;
import com.axzae.homeassistant.shared.EntityProcessInterface;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements EntityProcessInterface {

    private TextView mDataTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("HomeAssist Control Builder");

        mDataTextView = findViewById(R.id.text_data);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showEntityAction();
            }
        });
    }

    private void showEntityAction() {

        try {
            //TODO: LOAD YOUR ENTITY HERE:
            //Entity entity = Entity.getInstance(this, "light.hue_sphere.json");
            Entity entity = Entity.getInstance(this, "input_slider.bedroom_brightness.json");

            if (entity != null) {
                switch (entity.getDomain()) {
                    case "input_slider": {
                        InputSliderFragment fragment = InputSliderFragment.newInstance(entity);
                        fragment.show(getFragmentManager(), null);
                        break;
                    }
                    case "light": {
                        LightFragment fragment = LightFragment.newInstance(entity);
                        fragment.show(getFragmentManager(), null);
                        break;
                    }

                    default:
                        Toast.makeText(this, "Unknown entity: " + entity.getDomain(), Toast.LENGTH_SHORT).show();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void callService(String domain, String service, CallServiceRequest serviceRequest) {
        String requestPayload = String.format(Locale.ENGLISH, "POST /api/services/%s/%s HTTP/1.1\n%s", domain, service, serviceRequest.toString());
        mDataTextView.setText(requestPayload);
        //Snackbar.make(findViewById(android.R.id.content), , Snackbar.LENGTH_LONG).setAction("Action", null).show();
    }
}
