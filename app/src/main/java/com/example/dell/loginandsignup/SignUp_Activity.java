package com.example.dell.loginandsignup;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SignUp_Activity extends Activity {
    TextView heading;
    EditText name;
    EditText email;
    EditText password;
    EditText phone_number;
    EditText address;
    Button signup;
    TextView signin_link;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        heading=(TextView) findViewById(R.id.textviewfoodzilla);
        name=(EditText) findViewById(R.id.input_name);
        email=(EditText) findViewById(R.id.input_email);
        password=(EditText) findViewById(R.id.input_password);
        phone_number=(EditText) findViewById(R.id.phone);
        address=(EditText) findViewById(R.id.address);
        signup=(Button) findViewById(R.id.btn_signup);
        signin_link= findViewById(R.id.link_login);
        signin_link.setPaintFlags(signin_link.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
        signin_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
            }
        });



    }

}
