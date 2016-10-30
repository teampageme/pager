package com.example.adithya0797.phonebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class direct extends AppCompatActivity {

    Button bt_contacts, bt_codebooks, bt_addcontact;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_direct);

        bt_contacts = (Button)findViewById(R.id.bt_contacts);
        bt_codebooks = (Button)findViewById(R.id.bt_codebooks);
        bt_addcontact= (Button)findViewById(R.id.bt_addcontact);


        bt_contacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it_contacts = new Intent(direct.this, contacts.class);
                startActivity(it_contacts);
            }
        });

        bt_codebooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it_codebooks = new Intent(direct.this, codebooks.class);
                startActivity(it_codebooks);
            }
        });

        bt_addcontact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it_addcontact = new Intent(direct.this, addcontact.class);
                startActivity(it_addcontact);
            }
        });


    }
}
