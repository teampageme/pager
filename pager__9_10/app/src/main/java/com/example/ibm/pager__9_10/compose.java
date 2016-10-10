package com.example.ibm.pager__9_10;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class compose extends AppCompatActivity {

    EditText recipient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compose);

    }


    public void ok(View v){
        if(recipient.getText() != null){
            recipient.setText("Message sent");

        }

        setContentView(R.layout.activity_done);
    }
}
