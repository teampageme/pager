package com.example.ibm.PageMe;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.StrictMode;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ibm.pager__9_10.R;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

import static android.R.attr.data;

public class retrieval extends AppCompatActivity
{
    private ArrayList<String> msgResponse;
    private ArrayList<String> getting;
    private String ourID, getOurID;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieval);


        if (Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        if (savedInstanceState != null) {
            String message = savedInstanceState.getString("ourID");
            Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        }

        Intent move = getIntent();
        ourID = move.getStringExtra("ourID");

        String eve = ourID;
        String server_url = "http://64.137.191.97/retrieve.php?pwd=Chloe1234&userNumber=" + eve;
        //Log.d("script", server_url);
        //should implement a way to keep refreshing msgs every minute probably.
        getMSG(server_url); //getMSG function executes the php script [server_url] and retrieves an arraylist that have been parsed from the csv file and stores the correctly parsed arraylist into the variable getting.

        try {
            String message;
            FileInputStream fileInputStream = openFileInput("data.txt");
            InputStreamReader inputStreamReader = new InputStreamReader((fileInputStream));
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer stringbuffer = new StringBuffer();
            while((message = bufferedReader.readLine()) != null)
            {
                stringbuffer.append(message + "\n");
            }
            //Log.d("file", stringbuffer.toString());
            String ali = stringbuffer.toString();
            List<String> list = Arrays.asList(ali.split("\n"));
            //Log.d("list", Arrays.toString(list.toArray()));

            String li[] = list.toArray(new String[list.size()]);
            final ListView listView = (ListView)findViewById(R.id.list1);
            ArrayAdapter<String> listViewAdaptor = new ArrayAdapter<String>(retrieval.this, android.R.layout.simple_expandable_list_item_1, li);
            listView.setAdapter(listViewAdaptor); //setting listview to show the content of the array li
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) { //these are clicklisteners for each clickable textView
                    String item = listView.getItemAtPosition(position).toString();//for getting item with specfic position.
                    //Log.d("OnClick", "position = " + (position + 1));
                    //Log.d("OnClick", "item at position = " + item);
                    //Toast.makeText(getActivity(), "message #: " + (position + 1), Toast.LENGTH_SHORT).show();
                }
            });
            Toast.makeText(retrieval.this, "Inbox updated!", Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void getMSG(String credentials) {
        String line = "";
        URL url = null;
        try {
            url = new URL(credentials); //url = phpscript: retrieve.php
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        HttpURLConnection urlConnection = null;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ArrayList<String> singleLine = new ArrayList(); // arraylist to recieve lines without <br /> tags
            ArrayList<String> al = new ArrayList(); // arraylist to receive correctly parsed lines from singleLine arraylist after using Tokenizers
            ArrayList<String> el = new ArrayList();
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            StringBuilder response = new StringBuilder();
            //Log.d("a7a:", response.toString());
            line = (response.toString()).replaceAll("<br */>", "");
            //Log.d("a7a2:", line = reader.readLine());
            while ((line = reader.readLine()) != null) {
                singleLine.add(line);
            }
            if (singleLine.get(0) == "NOMSGS") {
                //Log.d("mafysh:", "7amdy");
                el.add("You have no msgs in your inbox");
                msgResponse = el;
            } else {
                //Log.d("a7a2:", line);
                //singleLine.remove(singleLine.size() - 1); //removes new line not visually seen (could be a bug)
                if (singleLine.isEmpty()) {
                    Toast.makeText(retrieval.this, "You have no Unread msgs", Toast.LENGTH_SHORT).show();
                } else if (!singleLine.isEmpty()) {
                    Collections.reverse(singleLine); //can be use if user want to sort msgs
                    String toBeParsed;
                    //Log.d("linked", Arrays.toString(singleLine.toArray()));

                    while (!singleLine.isEmpty()) {
                        toBeParsed = singleLine.get((singleLine.size() - 1));
                        StringTokenizer stk = new StringTokenizer(toBeParsed, ",");

                        if(stk.countTokens() == 6) {
                            //Log.d("count:", String.valueOf(stk.countTokens()));
                            stk.nextToken();
                            String senderID = stk.nextToken();
                            String firstTime = stk.nextToken();
                            String secondTime = stk.nextToken();
                            String timeStamp = firstTime + secondTime;
                            timeStamp = timeStamp.replaceAll("\"", "");
                            String message = stk.nextToken();
                            al.add("From: " + senderID + "    Msg: " + message + "      date: " + timeStamp);
                        }
                        else
                        {
                            al.add("No msgs to see");
                        }
                            singleLine.remove(singleLine.size() - 1);
                    }
                    //Log.d("al", Arrays.toString(al.toArray()));

                    try {
                        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(openFileOutput("data.txt", Context.MODE_PRIVATE));
                        while(!al.isEmpty())
                        {
                            outputStreamWriter.write(al.get(al.size()-1) + "\n");
                            al.remove(al.size() - 1);
                        }
                        outputStreamWriter.close();
                    }
                    catch (IOException e) {
                        Log.e("Exception", "File write failed: " + e.toString());
                    }

                    msgResponse = al;
                    //Log.d("msgResponse array", Arrays.toString(msgResponse.toArray()));
                } else {
                    Toast.makeText(retrieval.this, "There has been issues retriving you msgs", Toast.LENGTH_SHORT).show();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            urlConnection.disconnect();
        }
        //Log.d("msgResponse array", Arrays.toString(msgResponse.toArray()));
       // return msgResponse; //return arraylist al
    }

    @Override
    public void onBackPressed () {
        /*
                have a put extra intent to not have a null.csv
         */
        Intent move2 = new Intent(retrieval.this, page.class);
        move2.putExtra("ourID", ourID);
        startActivity(move2);
    }


}