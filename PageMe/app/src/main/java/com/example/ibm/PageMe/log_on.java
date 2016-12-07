package com.example.ibm.PageMe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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

        errorID       = (TextView) findViewById(R.id.errorNum); //make sure you use that to report errors.
        errorPassword = (TextView) findViewById(R.id.errorPass); //make sure you use that to report errors.
        num           = (EditText) findViewById(R.id.ninBit);
        passw         = (EditText) findViewById(R.id.ser);
        logIn         = (Button) findViewById(R.id.SingingIN);
        create        = (Button) findViewById(R.id.SingingUP);

        logIn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                id = num.getText().toString();
                password = passw.getText().toString();
                //Log.d("password", password);
                //double startTime = (double) System.currentTimeMillis();

                try {
                    encryptedPass = AES.encrypt(password);
                    encryptedPass = encryptedPass.replaceAll("\n", "");
                } catch (Exception e) {
                    e.printStackTrace();
                }

                loginValidation = "https://henrietta.ml/interface.php?script=login&id=" + id + "&password=" + encryptedPass; //later should send the password encrypted.
                Log.d("printing", loginValidation);
                LogIn(loginValidation);

                //double stopTime = (double) System.currentTimeMillis();
                //double elapsedTime = stopTime - startTime;
                //Log.d("runtime", String.valueOf(elapsedTime/1000));
            }
        });

        create.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(log_on.this, sign_up.class);
                startActivity(intent);
            }
        });
    }


    /*
        TODO: Change volley timeout request
    */
    public void LogIn(String credentials) {
        final RequestQueue requestQueue = Volley.newRequestQueue(log_on.this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, credentials,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response)
                    {
                        //errorPassword.setText(id);
                        //Log.d("response ", response);
                        if (response.trim().equalsIgnoreCase("VALID")) //if edit text is saying valid then move on else fuck it
                        {
                            Intent intent = new Intent(log_on.this, page.class);
                                    intent.putExtra("ourID", id);
                            startActivity(intent);
                            //Log.d("response ", "fuck yea");
                        }
                        else if (response.trim().equalsIgnoreCase("INVALID"))
                        {
                            Toast.makeText(log_on.this, "Wrong userID or password!", Toast.LENGTH_LONG).show();
                        }
                        else
                        {
                            //Log.d("response ", response);
                            Toast.makeText(log_on.this, "Please fill all the required fields!", Toast.LENGTH_LONG).show();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(log_on.this, "Error signing in!", Toast.LENGTH_LONG).show();
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