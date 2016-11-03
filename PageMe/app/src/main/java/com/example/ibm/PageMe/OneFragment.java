package com.example.ibm.PageMe;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ibm.pager__9_10.R;


public class OneFragment extends Fragment
{
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
        TextView txt = (TextView)myinflated.findViewById(R.id.trying);
        txt.setText("looool");
        return myinflated;

    }
}