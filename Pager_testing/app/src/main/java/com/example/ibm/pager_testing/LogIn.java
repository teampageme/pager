package com.example.ibm.pager_testing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class LogIn extends AppCompatActivity {
    TextView errorText;
    EditText username, password;
    String errormsg = "Incorrect Username/Password, try again";
    Button logIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
	
        errorText = (TextView)findViewById(R.id.error);

        username = (EditText)findViewById(R.id.username);

        password = (EditText)findViewById(R.id.password);


    }



    public void signIn(){

        boolean account = true;
        //check from server if account exists
        if (account){
            if(username == password){
                //change this
                setContentView(R.layout.activity_second_);

            }
            else{
                errorText.setText(errormsg);
            }


        }
        else{
            setContentView(R.layout.activity_sign_up);
        }

	







    }

public void signUp(){
	setContentView(R.layout.activity_sign_up);
	}

}

    
