package com.example.ibm.PageMe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.*;
import android.content.*;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.ibm.pager__9_10.R;

public class log_on extends AppCompatActivity
{
        private TextView errorText;
        private EditText num, pass;
        private String   errormsg = "Incorrect Username/Password, try again";
        private Button   logIn, create;
        private String id, password;
        private String loginValidation, logInResponse;

        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_log_on);

            errorText = (TextView)findViewById(R.id.errorNum); //make sure you use that to report errors.
            num       = (EditText)findViewById(R.id.nineBit);
            pass      = (EditText)findViewById(R.id.pass);
            logIn     = (Button)findViewById(R.id.SingingIN);
            create    = (Button)findViewById(R.id.SingingUP);


            id       = num.getText().toString();
            password = pass.getText().toString();

            loginValidation = "http://45.62.252.22/testValidateLogin.php?id=" + id + "&password=" + password;


            logIn.setOnClickListener(new View.OnClickListener()
            {
                public void onClick(View v)
                {
                    if(LogIn(loginValidation) == "Error Logging In")
                    {
                        errorText.setText("Error checking ID!");
                    }
                    else
                    {
                        if(LogIn(loginValidation) == "VALID")
                        {
                            Intent intent = new Intent(log_on.this, page.class);
                            startActivity(intent);
                        }
                        else if(LogIn(loginValidation) == "INVALID")
                        {
                            errorText.setText("Wrong password or ID!");
                        }
                        else
                        {
                            errorText.setText("Error checking ID!");
                        }
                    }
                }
            });

            create.setOnClickListener(new View.OnClickListener()
            {
                public void onClick(View v)
                {
                    Intent intent = new Intent(log_on.this, sign_up.class);
                    startActivity(intent);
                }
            });
        }

    public String LogIn(String credentials)
    {
        final RequestQueue requestQueue = Volley.newRequestQueue(log_on.this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, credentials,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        logInResponse = response;
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                logInResponse = "Error Logging In";
                error.printStackTrace();
                requestQueue.stop();
            }
        });
        requestQueue.add(stringRequest);
        return logInResponse;
    }

}