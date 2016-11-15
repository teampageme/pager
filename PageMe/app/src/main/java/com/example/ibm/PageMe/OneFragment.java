package com.example.ibm.PageMe;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.example.ibm.pager__9_10.R;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class OneFragment extends Fragment
{
    private ArrayList<String> msgResponse;
    private ArrayList<String> getting;
    private String ourID;

    public OneFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) throws NoSuchElementException
    {
        View myinflated = inflater.inflate(R.layout.activity_one_fragment, container, false);

        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        Intent move = getActivity().getIntent();
        ourID = move.getStringExtra("ourID");

        String server_url = "http://64.137.191.97/retrieve.php?pwd=Chloe1234&userNumber=" + ourID;
        //Log.d("script", server_url);
        //should implement a way to keep refreshing msgs every minute probably.
        getting = getMSG(server_url); //getMSG function executes the php script [server_url] and retrieves an arraylist that have been parsed from the csv file and stores the correctly parsed arraylist into the variable getting.

        String li[] = getting.toArray(new String[getting.size()]); //converts arraylist getting into an array.

        final ListView listView = (ListView) myinflated.findViewById(R.id.list1); //mapping the java code with the xml code id for intializing listview

        ArrayAdapter<String> listViewAdaptor = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_expandable_list_item_1, li);
        listView.setAdapter(listViewAdaptor); //setting listview to show the content of the array li


        /*
             TODO:   figure a way to set clicklisteners dynamically
             TODO:   Find a way to move msgs from unread to read upon clicking
             TODO:   Redirect the user to the reply with taking the senderID to page him
        */

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) { //these are clicklisteners for each clickable textView
                String item = listView.getItemAtPosition(position).toString();//for getting item with specfic position.
                Log.d("OnClick", "position = " + (position + 1));
                Log.d("OnClick", "item at position = " + item);
                Toast.makeText(getActivity(),"message #: " + (position+1), Toast.LENGTH_SHORT).show();
            }
        });
        Toast.makeText(getActivity(), "Inbox updated!", Toast.LENGTH_LONG).show();

        return myinflated; //returns the updated fragment to the screen
    }


    public ArrayList<String> getMSG(String credentials)
    {
        URL url = null;
        try
        {
            url = new URL(credentials); //url = phpscript: retrieve.php
        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
        HttpURLConnection urlConnection = null;
        try
        {
            urlConnection = (HttpURLConnection) url.openConnection();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        try
        {
            ArrayList<String> singleLine = new ArrayList(); // arraylist to recieve lines without <br /> tags
            ArrayList<String> al         = new ArrayList(); // arraylist to receive correctly parsed lines from singleLine arraylist after using Tokenizers

            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            StringBuilder response = new StringBuilder();
            //Log.d("a7a:", response.toString());
            String line = (response.toString()).replaceAll("<br */>", "");
            //Log.d("a7a2:", line.toString());
            while ((line = reader.readLine()) != null)
            {
                singleLine.add(line);
            }
            singleLine.remove(singleLine.size() - 1); //removes new line not visually seen (could be a bug)
            if (singleLine.isEmpty())
            {
                Toast.makeText(getActivity(),"You have no Unread msgs", Toast.LENGTH_SHORT).show();
            }
            else if (!singleLine.isEmpty())
            {
                //Collections.reverse(singleLine); //can be use if user want to sort msgs
                String toBeParsed;
                while (!singleLine.isEmpty())
                {
                    toBeParsed = singleLine.get((singleLine.size() - 1));
                    StringTokenizer stk = new StringTokenizer(toBeParsed, ",");
                    stk.nextToken();
                    String senderID   = stk.nextToken();
                    String firstTime  = stk.nextToken();
                    String secondTime = stk.nextToken();
                    String timeStamp  = firstTime + secondTime;
                    timeStamp = timeStamp.replaceAll("\"", "");
                    String message = stk.nextToken();
                    al.add("From: " + senderID + "    Msg: " + message + "      date: " + timeStamp);

                    singleLine.remove(singleLine.size() - 1);
                }
                msgResponse = al;
                //Log.d("msgResponse array", Arrays.toString(msgResponse.toArray()));
            }
            else
            {
                Toast.makeText(getActivity(),"There has been issues retriving you msgs", Toast.LENGTH_SHORT).show();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            urlConnection.disconnect();
        }
        //Log.d("msgResponse array", Arrays.toString(msgResponse.toArray()));
        return msgResponse; //return arraylist al
    }
}