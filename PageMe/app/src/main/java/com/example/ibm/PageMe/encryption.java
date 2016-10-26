package com.example.ibm.PageMe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.example.ibm.pager__9_10.R;

public class encryption extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encryption);

        Button enc = (Button)findViewById(R.id.bn1);
        Button dec = (Button)findViewById(R.id.bn2);
        final TextView encrypt = (TextView)findViewById(R.id.vw1);
        final TextView decrpyt = (TextView)findViewById(R.id.vw2);
        final EditText password = (EditText)findViewById(R.id.pass);

        enc.setOnClickListener( new View.OnClickListener()
        {
            public void onClick(View v)
            {
                String passwordEnc = null;
                try
                {
                    passwordEnc = AES.encrypt(password.getText().toString());
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                encrypt.setText(passwordEnc);
            }
        });

        dec.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                String passwordDec = null;
                try
                {
                    passwordDec = AES.decrypt(encrypt.getText().toString());
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                decrpyt.setText(passwordDec);
            }
        });
    }
}