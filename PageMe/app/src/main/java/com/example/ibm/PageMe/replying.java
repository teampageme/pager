package com.example.ibm.PageMe;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.ibm.pager__9_10.R;

public class replying extends AppCompatActivity {
    private EditText msg;
    private TextView our, them, ID;
    private ImageButton send;
    private Button codeBook;
    private String ourID, theirID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_replying);
        msg      = (EditText) findViewById(R.id.MSG);
        send     = (ImageButton) findViewById(R.id.sending);
        codeBook = (Button) findViewById(R.id.codeBook);
        our      = (TextView)findViewById(R.id.us);
        them     = (TextView)findViewById(R.id.them);
        ID       = (TextView)findViewById(R.id.UID);

        Intent move = getIntent();
        ourID = move.getStringExtra("ourID");
        theirID = move.getStringExtra("theirID");
        //Log.d("sending", ourID);

        final InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

        ID.setText("Paging: " + theirID);
        /*our.setText(ourID); //SENDER's IDT
        them.setText(theirID.toString()); //RECIEVER'S ID*/

        send.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String sendingMSG = "https://henrietta.ml/sendMsg.php?userNumber="+ theirID + "&from=" + ourID + "&msgToSend=" + msg.getText().toString();
                send(sendingMSG);
                imm.hideSoftInputFromWindow(replying.this.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

            }
        });

    }

    public void send(String credentials) {
        final RequestQueue requestQueue = Volley.newRequestQueue(replying.this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, credentials,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        our.setText(response);
                        if(response.trim().equalsIgnoreCase("SENT"))
                        {
                            Toast.makeText(replying.this, "MSG sent!", Toast.LENGTH_LONG).show();
                        }
                        else
                        {
                            Toast.makeText(replying.this, "Msg not sent for some reason!", Toast.LENGTH_LONG).show();
                        }
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(replying.this, "Error sending msg!", Toast.LENGTH_LONG).show();
                error.printStackTrace();
                requestQueue.stop();
            }
        });
        requestQueue.add(stringRequest);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(replying.this, retrieval.class);
        intent.putExtra("ourID", ourID);
        startActivity(intent);
    }
}
