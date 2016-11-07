package com.example.ibm.PageMe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.*;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
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

        /*our.setText(ourID); //SENDER's ID
        them.setText(theirID.toString()); //RECIEVER'S ID*/

        send.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String sendingMSG = "http://64.137.191.97/sendMsg.php?userNumber="+ theirID + "&from=" + ourID + "&msgToSend=" + msg.getText().toString();
                send(sendingMSG);
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

    public void send(String credentials) {
        final RequestQueue requestQueue = Volley.newRequestQueue(compose.this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, credentials,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        our.setText(response);
                        if(response.compareTo("SENT") == 0)
                        {
                            Intent intent = new Intent(compose.this, done.class);
                            startActivity(intent);
                        }
                        else
                        {
                            our.setText("MSG not sent for some reason!");
                        }
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                our.setText("Error sending msg!");
                error.printStackTrace();
                requestQueue.stop();
            }
        });
        requestQueue.add(stringRequest);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(compose.this, page.class);
        startActivity(intent);
    }
}