package com.example.adithya0797.phonebook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.content.Intent;

public class codebooks extends AppCompatActivity {

    EditText et_pin;
    Button bt_find;
    Button bt_addcode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_codebooks);

        et_pin = (EditText)findViewById(R.id.et_pin);
        bt_find = (Button)findViewById(R.id.bt_find);
        bt_addcode = (Button)findViewById(R.id.bt_addcode);

        final String temp = et_pin.getText().toString();

        bt_find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent it_displaycodebook = new Intent(codebooks.this, displaycodebooks.class);
                it_displaycodebook.putExtra("key",temp);
                startActivity(it_displaycodebook);
            }
        });

        bt_addcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it_addcode = new Intent(codebooks.this, addcode.class);
                it_addcode.putExtra("values", temp );
                startActivity(it_addcode);
            }
        });



    }
}
