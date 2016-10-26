package com.example.ibm.PageMe;

import android.content.Intent;
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
    Button codeBook;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compose);

        recip = (EditText)findViewById(R.id.recipient);
        sd = (Button)findViewById(R.id.sending);
        codeBook = (Button)findViewById(R.id.codeBook);

        sd.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                if(recip.getText() != null)
                {
                    recip.setText("Message sent");

                }
            }
        });

        codeBook.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                //should redirect user to the his codebook activity. To be done later.
                /*Intent intent = new Intent(homepage.this, log_on.class);
                startActivity(intent);*/
            }
        });

    }
}
