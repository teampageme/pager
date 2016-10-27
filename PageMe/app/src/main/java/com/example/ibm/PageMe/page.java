package com.example.ibm.PageMe;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.*;
import android.widget.*;
import android.content.*;
import java.lang.Math;
import com.example.ibm.pager__9_10.R;


//The UI for this activity will be polished later.


public class page extends AppCompatActivity
{
    private int          num1,       num2,       num3,       num4,       num5,       num6,       num7,       num8,       num9;
    private NumberPicker numPicker1, numPicker2, numPicker3, numPicker4, numPicker5, numPicker6, numPicker7, numPicker8, numPicker9;
    private TextView     tv;
    private ImageButton  record, settings;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page);

        tv = (TextView) findViewById(R.id.tv);

        numPicker1 = (NumberPicker) findViewById(R.id.numberPicker1);
        numPicker1.setMaxValue(9);
        numPicker1.setMinValue(1);
        numPicker1.setValue(0);


        numPicker2 = (NumberPicker) findViewById(R.id.numberPicker2);
        numPicker2.setMaxValue(9);
        numPicker2.setMinValue(0);
        numPicker2.setValue(0);

        numPicker3 = (NumberPicker) findViewById(R.id.numberPicker3);
        numPicker3.setMaxValue(9);
        numPicker3.setMinValue(0);
        numPicker3.setValue(0);

        numPicker4 = (NumberPicker) findViewById(R.id.numberPicker4);
        numPicker4.setMaxValue(9);
        numPicker4.setMinValue(0);
        numPicker4.setValue(0);

        numPicker5 = (NumberPicker) findViewById(R.id.numberPicker5);
        numPicker5.setMaxValue(9);
        numPicker5.setMinValue(0);
        numPicker5.setValue(0);

        numPicker6 = (NumberPicker) findViewById(R.id.numberPicker6);
        numPicker6.setMaxValue(9);
        numPicker6.setMinValue(0);
        numPicker6.setValue(0);

        numPicker7 = (NumberPicker) findViewById(R.id.numberPicker7);
        numPicker7.setMaxValue(9);
        numPicker7.setMinValue(0);
        numPicker7.setValue(0);

        numPicker8 = (NumberPicker) findViewById(R.id.numberPicker8);
        numPicker8.setMaxValue(9);
        numPicker8.setMinValue(0);
        numPicker8.setValue(0);

        numPicker9 = (NumberPicker) findViewById(R.id.numberPicker9);
        numPicker9.setMaxValue(9);
        numPicker9.setMinValue(0);
        numPicker9.setValue(0);


        numPicker1.setOnValueChangedListener(new NumberPicker.OnValueChangeListener()
        {
            public void onValueChange(NumberPicker view, int oldValue, int newValue)
            {
                num1 = (int) (newValue * Math.pow(10, 8));
                tv.setText(String.valueOf(num1 + num2 + num3 + num4 + num5 + num6 + num7 + num8 + num9));
            }
        });

        numPicker2.setOnValueChangedListener(new NumberPicker.OnValueChangeListener()
        {
            public void onValueChange(NumberPicker view, int oldValue, int newValue)
            {
                num2 = (int) (newValue * Math.pow(10, 7));
                tv.setText(String.valueOf(num1 + num2 + num3 + num4 + num5 + num6 + num7 + num8 + num9));
            }
        });

        numPicker3.setOnValueChangedListener(new NumberPicker.OnValueChangeListener()
        {
            public void onValueChange(NumberPicker view, int oldValue, int newValue)
            {
                num3 = (int) (newValue * Math.pow(10, 6));
                tv.setText(String.valueOf(num1 + num2 + num3 + num4 + num5 + num6 + num7 + num8 + num9));
            }
        });

        numPicker4.setOnValueChangedListener(new NumberPicker.OnValueChangeListener()
        {
            public void onValueChange(NumberPicker view, int oldValue, int newValue)
            {
                num4 = (int) (newValue * Math.pow(10, 5));
                tv.setText(String.valueOf(num1 + num2 + num3 + num4 + num5 + num6 + num7 + num8 + num9));
            }
        });

        numPicker5.setOnValueChangedListener(new NumberPicker.OnValueChangeListener()
        {
            public void onValueChange(NumberPicker view, int oldValue, int newValue)
            {
                num5 = (int) (newValue * Math.pow(10, 4));
                tv.setText(String.valueOf(num1 + num2 + num3 + num4 + num5 + num6 + num7 + num8 + num9));
            }
        });

        numPicker6.setOnValueChangedListener(new NumberPicker.OnValueChangeListener()
        {
            public void onValueChange(NumberPicker view, int oldValue, int newValue)
            {
                num6 = (int) (newValue * Math.pow(10, 3));
                tv.setText(String.valueOf(num1 + num2 + num3 + num4 + num5 + num6 + num7 + num8 + num9));
            }
        });

        numPicker7.setOnValueChangedListener(new NumberPicker.OnValueChangeListener()
        {
            public void onValueChange(NumberPicker view, int oldValue, int newValue)
            {
                num7 = (int) (newValue * Math.pow(10, 2));
                tv.setText(String.valueOf(num1 + num2 + num3 + num4 + num5 + num6 + num7 + num8 + num9));
            }
        });

        numPicker8.setOnValueChangedListener(new NumberPicker.OnValueChangeListener()
        {
            public void onValueChange(NumberPicker view, int oldValue, int newValue)
            {
                num8 = (int) (newValue * Math.pow(10, 1));
                tv.setText(String.valueOf(num1 + num2 + num3 + num4 + num5 + num6 + num7 + num8 + num9));
            }
        });

        numPicker9.setOnValueChangedListener(new NumberPicker.OnValueChangeListener()
        {
            public void onValueChange(NumberPicker view, int oldValue, int newValue)
            {
                num9 = (int) (newValue * Math.pow(10, 0));
                tv.setText(String.valueOf(num1 + num2 + num3 + num4 + num5 + num6 + num7 + num8 + num9));
            }
        });

        record = (ImageButton) findViewById(R.id.tasgyl);
        settings = (ImageButton) findViewById(R.id.setting);

        record.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent intent = new Intent(page.this, done.class);
                intent.putExtra("num", tv.getText());
                startActivity(intent);
            }
        });

        settings.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent intent = new Intent(page.this, settings.class);
                startActivity(intent);
            }
        });

    }
}