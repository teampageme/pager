package com.example.ibm.PageMe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.*;

import com.example.ibm.pager__9_10.R;

//connect the Codebook activity to this activity.

public class compose extends AppCompatActivity {
    private EditText msg;
    private TextView our, them;
    private Button send;
    private Button codeBook;
    private String ourID, theirID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compose);

        msg = (EditText) findViewById(R.id.MSG);
        send = (Button) findViewById(R.id.sending);
        codeBook = (Button) findViewById(R.id.codeBook);
        our = (TextView)findViewById(R.id.us);
        them = (TextView)findViewById(R.id.them);

        Intent move = getIntent();
        ourID = move.getStringExtra("ourID");
        theirID = move.getStringExtra("theirID");

        our.setText(ourID); //SENDER's ID
        them.setText(theirID.toString()); //RECIEVER'S ID

        send.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (msg.getText() != null) {
                    msg.setText("Message sent");
                } else {
                    msg.setText("Type your MSG!");
                }
            }
        });

        codeBook.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //should redirect user to the his codebook activityu, using intents. To be implemented later.
                /*
                Intent intent = new Intent(compose.this, codebook.class);
                startActivity(intent);
                */

            }
        });

    }
}
