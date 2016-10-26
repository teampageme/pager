package com.example.ibm.send_request;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity
{

    Button button;
    TextView textView;
    String server_url = "http://45.62.252.22/hash.php?word=Chloe";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button)findViewById(R.id.bn);
        textView = (TextView) findViewById(R.id.txt);

        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                final RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);

                StringRequest stringRequest = new StringRequest(Request.Method.POST, server_url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                textView.setText(response);
                                requestQueue.stop();
                            }
                        }, new Response.ErrorListener() {

                        @Override
                        public void onErrorResponse(VolleyError error)
                        {
                            textView.setText("Something went wrong....");
                            error.printStackTrace();
                            requestQueue.stop();
                        }
                });
                requestQueue.add(stringRequest);
            }
        });
    }
}
