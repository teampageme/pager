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

public class log_on extends AppCompatActivity {
    private TextView errorID, errorPassword;
    EditText num, passw;
    private Button logIn, create;
    private String id, password, encryptedPass;
    private String loginValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_on);

        errorID = (TextView) findViewById(R.id.errorNum); //make sure you use that to report errors.
        errorPassword = (TextView) findViewById(R.id.errorPass); //make sure you use that to report errors.
        num = (EditText) findViewById(R.id.ninBit);
        passw = (EditText) findViewById(R.id.ser);
        logIn = (Button) findViewById(R.id.SingingIN);
        create = (Button) findViewById(R.id.SingingUP);

        logIn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                id = num.getText().toString();
                password = passw.getText().toString();

                /*try {
                    encryptedPass = AES.encrypt(password);
                } catch (Exception e) {
                    e.printStackTrace();
                }*/

                loginValidation = "http://64.137.191.97/testValidateLogin.php?id=" + id + "&password='" + password + "'"; //later should send the password encrypted.
                LogIn(loginValidation);
            }
        });

        create.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(log_on.this, sign_up.class);
                startActivity(intent);
            }
        });
    }

    public void LogIn(String credentials) {
        final RequestQueue requestQueue = Volley.newRequestQueue(log_on.this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, credentials,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response)
                    {
                        errorPassword.setText(id);
                        if (response.compareTo("VALID") == 0) //if edit text is saying valid then move on else fuck it
                        {
                            Intent intent = new Intent(log_on.this, page.class);
                            intent.putExtra("ourID", id);
                            startActivity(intent);

                        }
                        else if (response.compareTo("INVALID") == 0)
                        {
                            errorPassword.setText("Wrong Password or Username!");
                        }
                        else
                        {
                            errorID.setText("Please type all the required credentials");
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                errorID.setText("Error Logging in!");
                error.printStackTrace();
                requestQueue.stop();
            }
        });
        requestQueue.add(stringRequest);
    }

    //Prevent user from going back to previous activity.
    @Override
    public void onBackPressed() {
        return;
    }
}