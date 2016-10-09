package com.example.ibm.pager_testing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ImageButton;


public class MainActivity extends AppCompatActivity {
	Button logIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
	logIn = (Button)this.findViewById(R.id.Log_in);
	Button signUp = (Button)this.findViewById(R.id.Sign_up);	



    }


public void in(){
setContentView(R.layout.activity_log_in)


}

public void up(){
setContentView(R.layout.activity_sign_up)


}

}
