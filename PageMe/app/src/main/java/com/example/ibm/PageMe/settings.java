package com.example.ibm.PageMe;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.ibm.pager__9_10.R;

public class settings extends AppCompatActivity {

    private String ourID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_settings);

        Button vib               = (Button) findViewById(R.id.prv);
        Button out               = (Button) findViewById(R.id.out);
        TextView ID              = (TextView)findViewById(R.id.UID);
        final RadioButton osyr   = (RadioButton) findViewById(R.id.shrt);
        final RadioButton taktka = (RadioButton) findViewById(R.id.taptap);
        final RadioButton tawyl  = (RadioButton) findViewById(R.id.lng);
        final RadioButton saket  = (RadioButton) findViewById(R.id.slnt);

        final long[] ONE_CYLCE    = {100, 0, 100, 100, 0, 100, 100, 0, 100};
        final long[] TAPS         = {200, 200, 200, 200, 200, 200, 200, 200};
        final long[] THREE_CYCLES = {500, 500, 500, 500, 500, 500};
        final long[] SILENT       = {0};

        Intent move = getIntent();
        ourID = move.getStringExtra("ourID");

        ID.setText("ID: " + ourID);

        vib.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Vibrator vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                if (osyr.isChecked()) {
                    vib.cancel();
                    vib.vibrate(ONE_CYLCE, -1);
                } else if (taktka.isChecked()) {
                    vib.cancel();
                    vib.vibrate(TAPS, -1);
                } else if (tawyl.isChecked()) {
                    vib.cancel();
                    vib.vibrate(THREE_CYCLES, -1);
                } else if (saket.isChecked()) {
                    vib.cancel();
                    vib.vibrate(SILENT, -1);
                }
            }
        });

        /*
        TODOS:

        Push notification on/off: https://developer.android.com/guide/topics/ui/notifiers/notifications.html
        Refreshing period setup
        Signing out : Exiting the app

        */
        out.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(settings.this, homepage.class);
                startActivity(intent);
            }

        });
    }

    @Override
    public void onBackPressed () {
        Intent intent = new Intent(settings.this, page.class);
        intent.putExtra("ourID", ourID);
        startActivity(intent);
    }
}

