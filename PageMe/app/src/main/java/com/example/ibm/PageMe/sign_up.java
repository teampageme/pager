package com.example.ibm.PageMe;

import android.content.Intent;
import android.support.design.widget.Snackbar;
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

import com.example.ibm.pager__9_10.R;

public class sign_up extends AppCompatActivity {
    //Predeclarations
    private TextView nineBit, nworked, pworked, eworked;
    private EditText pass, email;
    private int pin;
    private Button generate, finish, checkP, checkE;
    private String id, password, key, checkID, encryptedPass;
    private String createUser, checkExisitngID;
    private String chkIdResponse, signUpResponse, chkIdResponse2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //Declarations
        pass = (EditText) findViewById(R.id.ps);
        email = (EditText) findViewById(R.id.EL);
        nineBit = (TextView) findViewById(R.id.st);
        nworked = (TextView) findViewById(R.id.validNum);
        pworked = (TextView) findViewById(R.id.validPass);
        eworked = (TextView) findViewById(R.id.validEmail);
        generate = (Button) findViewById(R.id.gen);
        finish = (Button) findViewById(R.id.fn);
        checkP = (Button) findViewById(R.id.chkP);
        checkE = (Button) findViewById(R.id.chkE);

        //Generating 9-bit #
        generate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //needs to check if the generated number is not already been used in the database.
                //after generating a valid number then you can display the 9-bit # to the screen and later send it as an e-mail
                //if valid then use TEXTVIEW "nworked" to say it worked, else then make it say try a different one.
                generate.setClickable(false); //disables generate button after it has been pressed.
                Random rnd = new Random();
                pin = rnd.nextInt(999999999) + 100000000;
                checkID = String.valueOf(pin);
                checkExisitngID = "http://64.137.191.97/testCheckForExistingID.php?id=" + checkID;
                if (checkExisting(checkExisitngID) == "Error checking ID") {
                    nineBit.setText("Error checking ID");
                }
                else
                {
                    while (checkExisting(checkExisitngID) == "EXISTS" && checkExisting(checkExisitngID) != "DOES_NOT_EXIST" && checkExisting(checkExisitngID) != "Error checking ID") {
                        pin = rnd.nextInt(999999999) + 100000000;
                        checkID = String.valueOf(pin);
                        checkExisitngID = "http://64.137.191.97/testCheckForExistingID.php?id=" + checkID;
                    }
                    nineBit.setText(checkID);
                    nworked.setText(("worked"));
                    //Toast.makeText(sign_up.this, "this is my Toast message!!! =)",  Toast.LENGTH_LONG).show();
                }
            }
        });

        //Password Validation
        checkP.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //checks if the password conditions are met.
                //if valid then use TEXTVIEW "pworked" to say it worked, else then make it say try a different one.
                if (isValidPassword(pass.getText().toString())) {
                    pworked.setText("worked");
                    checkP.setClickable(false); //disables checkP button after it has been pressed.
                } else {
                    pworked.setText("didn't worked");
                }
            }
        });

        //Email Validation
        checkE.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //checks if the e-mail entered conditions are met.
                //if valid then use TEXTVIEW "eworked" to say it worked, else then make it say try a different one.
                if (isValidEmail(email.getText().toString())) {
                    eworked.setText("worked");
                    checkE.setClickable(false); //disables checkE button after it has been pressed.
                } else {
                    eworked.setText("didn't work");
                }
            }
        });

        //Sign up procedure
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nworked.getText() == "worked" && pworked.getText() == "worked" && eworked.getText() == "worked") {
                    id = nineBit.getText().toString();
                    password = "'" + pass.getText().toString() + "'";
                    key = "0"; //temporary.

                    /*try {
                        encryptedPass = AES.encrypt(password);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }*/

                    /*
                        Should have another field for inserting email address in the database for email confirmation later on.
                     */
                    createUser = "http://64.137.191.97/testCreateUser.php?id=" + id + "&password=" + password + "&key=" + key; //should include email address for confirmation
                    eworked.setText(signUp(createUser));

                    Intent intent = new Intent(sign_up.this, page.class);
                    startActivity(intent);
                }
            }
        });

    }


    //functions
    /*
        Password regex pattern.
        Inspired from stackoverflow:http://stackoverflow.com/questions/22348212/android-check-if-an-email-address-is-valid-or-not
    */
    public boolean isValidPassword(final String password) {
        Pattern pattern;
        Matcher matcher;

        final String PASSWORD_PATTERN = "^.{4,20}$"; //pass between 4 and 20 chars, with no other restrictions.

        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);

        return matcher.matches();
    }

    /*
        Checking whether entered email is valid(not existing.
    */
    public static boolean isValidEmail(String target) {
        return target != null && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches(); //checks whether email is valid or not. But it doens't check whether email is exisitng or not(confirmation link in the entered email).
    }

    /*
        Function for checking existing IDs.
    */
    public String checkExisting(String checking) {
        final RequestQueue requestQueue = Volley.newRequestQueue(sign_up.this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, checking,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        chkIdResponse = response;
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                chkIdResponse = "Error checking ID";
                error.printStackTrace();
                requestQueue.stop();
            }
        });
        requestQueue.add(stringRequest);
        return chkIdResponse;
    }

    /*
        Function for signing up users as an entry in the database.
    */
    public String signUp(String credentials) {
        final RequestQueue requestQueue = Volley.newRequestQueue(sign_up.this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, credentials,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        signUpResponse = response;
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                signUpResponse = "Error checking ID";
                error.printStackTrace();
                requestQueue.stop();
            }
        });
        requestQueue.add(stringRequest);
        return signUpResponse;
    }

}