package com.example.ibm.PageMe;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.ibm.pager__9_10.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static android.R.attr.value;


public class OneFragment extends Fragment
{
    TextView msg, txt;
    private String msgResponse, ourID;


    public OneFragment()
    {
        // Required empty public constructor

    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View myinflated =  inflater.inflate(R.layout.activity_one_fragment, container, false);

        Intent move = getActivity().getIntent();
        ourID = move.getStringExtra("ourID");
        String server_url = "http://64.137.191.97/getMsg.php?userNumber=" + ourID;

        txt = (TextView)myinflated.findViewById(R.id.trying);
        //txt.setText(getMSG(server_url));
        txt.setText(getMSG(server_url));

        return myinflated;

    }

    public String getMSG(String credentials) {
        final RequestQueue requestQueue =  Volley.newRequestQueue(getActivity().getApplicationContext());
        StringRequest stringRequest = new StringRequest(Request.Method.POST, credentials,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        msgResponse = response;
                        if(msgResponse.compareTo("NOMSG") == 0)
                        {
                            txt.setText("no msgs to show");
                        }
                        else
                        {
                            /*InputStream is;
                            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                            try {
                                String line;
                                while ((line = reader.readLine()) != null) {
                                    String[] RowData = line.split(",");
                                *//*
                                    date = RowData[0];
                                    value = RowData[1];
                                    // do something with "data" and "value"
                                *//*

                                }
                            }
                            catch (IOException ex) {
                                // handle exception
                            }
                            finally {
                                try {
                                    is.close();
                                }
                                catch (IOException e) {
                                    // handle exception
                                }
                            }*/
                        }

                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                msgResponse = "Error getting msgs";
                error.printStackTrace();
                requestQueue.stop();
            }
        });
        requestQueue.add(stringRequest);
        return msgResponse;
    }

}