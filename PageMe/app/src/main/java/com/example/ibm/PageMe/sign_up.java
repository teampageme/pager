package com.example.ibm.PageMe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import android.view.*;
import android.content.*;
import com.example.ibm.pager__9_10.R;

import static com.example.ibm.pager__9_10.R.id.textView;

public class sign_up extends AppCompatActivity
{
    private TextView nineBit, nworked, pworked, eworked;
    private EditText pass, email;
    private int      pin;
    private Button   generate, finish, checkP, checkE;
    //private String   input      = "123456789";
    String id, password, key;
    String   server_url = "http://45.62.252.22/testCreateUser.php?id=" + id + "&password="+ password +"&key=" + key;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        pass     = (EditText)findViewById(R.id.ps);
        email    = (EditText)findViewById(R.id.EL);
        nineBit  = (TextView)findViewById(R.id.st);
        nworked  = (TextView)findViewById(R.id.validNum);
        pworked  = (TextView)findViewById(R.id.validPass);
        eworked  = (TextView)findViewById(R.id.validEmail);
        generate = (Button)findViewById(R.id.gen);
        finish   = (Button)findViewById(R.id.fn);
        checkP   = (Button)findViewById(R.id.chkP);
        checkE   = (Button)findViewById(R.id.chkE);

        //Generating 9-bit #
        generate.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                //needs to check if the generated number is not already been used in the database.
                //after generating a valid number then you can display the 9-bit # to the screen and later send it as an e-mail
                //if valid then use TEXTVIEW "nworked" to say it worked, else then make it say try a different one.
                Random rnd = new Random();
                pin = rnd.nextInt(999999999) + 100000000;
                String test = pass.getText().toString();
                nineBit.setText(test + "" + pin + "");

            }
        });

        //Password Validation
        checkP.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                //checks if the password conditions are met.
                //if valid then use TEXTVIEW "pworked" to say it worked, else then make it say try a different one.
                if(isValidPassword(pass.getText().toString()))
                {
                    pworked.setText("worked");
                }
                else
                {
                    pworked.setText("didn't worked");
                }
            }
        });

        //Email Validation
        checkE.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                //checks if the e-mail entered conditions are met.
                //if valid then use TEXTVIEW "eworked" to say it worked, else then make it say try a different one.
                if(isValidEmail(email.getText().toString()))
                {
                    eworked.setText("worked");
                }
                else
                {
                    eworked.setText("didn't work");
                }
            }
        });

        finish.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                final RequestQueue requestQueue = Volley.newRequestQueue(sign_up.this);

                StringRequest stringRequest = new StringRequest(Request.Method.POST, server_url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                nworked.setText(response);
                                requestQueue.stop();
                                Intent intent = new Intent(sign_up.this, page.class);
                                startActivity(intent);
                            }
                        }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        nworked.setText("a7a....");
                        error.printStackTrace();
                        requestQueue.stop();
                    }
                });
                requestQueue.add(stringRequest);
            }
/*
            Intent intent = new Intent(sign_up.this, page.class);
            startActivity(intent);
*/

        });
    }

    /*
        Inspired from stackoverflow:http://stackoverflow.com/questions/22348212/android-check-if-an-email-address-is-valid-or-not
     */
    public boolean isValidPassword(final String password)
    {
        Pattern pattern;
        Matcher matcher;

        final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[@#$%]).{5,15})\n";

        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);

        return matcher.matches();
    }

    public static boolean isValidEmail(String target)
    {
        return target != null && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }
}