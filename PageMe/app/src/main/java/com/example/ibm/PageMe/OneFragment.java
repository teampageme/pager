package com.example.ibm.PageMe;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.ibm.pager__9_10.R;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class OneFragment extends Fragment {
    TextView msg, txt;
    private String msgResponse, ourID;


    public OneFragment() {
        // Required empty public constructor

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) throws NoSuchElementException {
        // Inflate the layout for this fragment
        View myinflated = inflater.inflate(R.layout.activity_one_fragment, container, false);

        Intent move = getActivity().getIntent();
        ourID = move.getStringExtra("ourID");
        //String server_url = "http://64.137.191.97/retrieve.php?userNumber=" + ourID;

        txt = (TextView) myinflated.findViewById(R.id.trying);
        //txt.setText(getMSG(server_url));
        String server_url = "http://64.137.191.97/retrieve.php?pwd=Chloe1234&userNumber=" + ourID;

        //String parsing = getMSG(server_url);
        //String trimedParsing = parsing.replaceAll("<br */>", "");
        getMSG(server_url);

        //txt.setText(parsing);


        return myinflated;
    }

    public void getMSG(String credentials) {
        final RequestQueue requestQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
        StringRequest stringRequest = new StringRequest(Request.Method.POST, credentials,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        msgResponse = response;
                        //txt.setText(msgResponse);

                        if (msgResponse.compareTo("NOMSG") == 0) {
                            txt.setText("no msgs to show");
                        } else {
                            msgResponse = msgResponse.replaceAll("<br */>", ""); //removes the <br/> token occurences from the string msgResponse

                            ArrayList<String> singleLine = new ArrayList(); // intializing arraylist
                            InputStream is = new ByteArrayInputStream(msgResponse.getBytes());
                            BufferedReader br = new BufferedReader(new InputStreamReader(is));
                            String line = null;
                            try
                            {
                                while ((line = br.readLine()) != null)
                                {
                                    singleLine.add(line);
                                }
                                Log.d("MYTAG", Arrays.toString(singleLine.toArray()));
                                Log.d("number", String.valueOf(singleLine.size()));
                                singleLine.remove(singleLine.size() -1);
                                Log.d("MYTAG", Arrays.toString(singleLine.toArray()));
                                Log.d("number", String.valueOf(singleLine.size()));
                                Log.d("last", singleLine.get(1));
                            }
                            catch (IOException e)
                            {
                                e.printStackTrace();
                            }

                            if (singleLine.isEmpty())
                            {
                                txt.setText("No msgs to show!");
                            }
                            else if(!singleLine.isEmpty())
                            {
                                String toBeParsed;
                                while(!singleLine.isEmpty())//for (int i = 0; i < singleLine.size(); i++)
                                {
                                    toBeParsed =  singleLine.get((singleLine.size() -1));
/*
                                    StringTokenizer stk = new StringTokenizer(toBeParsed, ",");
                                    stk.nextToken();
                                    String senderID = stk.nextToken();
                                    String firstTime = stk.nextToken();
                                    String secondTime = stk.nextToken();
                                    String timeStamp = firstTime + secondTime;
                                    timeStamp = timeStamp.replaceAll("\"", "");
                                    String message = stk.nextToken();
                                    txt.setText(senderID + "\n" + timeStamp + "\n" + message + "\n");
*/
                                    //txt.setText(toBeParsed);
                                    Log.d("MYTAG", toBeParsed);
                                    singleLine.remove(singleLine.size() -1);

                                }
                            }
                            else
                            {
                                txt.setText("a7a ya 7amdy");
                            }
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                msgResponse = "Error getting msgs";
                txt.setText(msgResponse);
                requestQueue.stop();
            }
        });
        requestQueue.add(stringRequest);
    }
}