package com.example.ibm.PageMe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.*;

import com.example.ibm.pager__9_10.R;

public class compose extends AppCompatActivity
{
    EditText recip;
    Button sd;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compose);

        recip = (EditText)findViewById(R.id.recipient);
        sd = (Button)findViewById(R.id.sending);

        sd.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                /*Intent intent = new Intent(log_on.this, sign_up.class);
                startActivity(intent);*/
                if(recip.getText() != null)
                {
                    recip.setText("Message sent");

                }
            }
        });
    }
}
