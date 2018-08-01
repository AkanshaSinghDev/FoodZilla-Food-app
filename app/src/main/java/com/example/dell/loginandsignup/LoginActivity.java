package com.example.dell.loginandsignup;

import android.content.Intent;
import android.graphics.Paint;
import android.nfc.Tag;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity
{
    EditText editText1;
    EditText editText2;
    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1=(EditText) findViewById(R.id.input_email);
        editText2 =(EditText) findViewById(R.id.input_password);
        button=(Button) findViewById(R.id.btn_login);
        textView=(TextView) findViewById(R.id.link_signup);
        textView.setPaintFlags(textView.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
        textView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent=new Intent(getApplicationContext(),SignUp_Activity.class);
                startActivity(intent);
            }
            // String email=editText1.getText().toString();
        });}
        public void yes(View view)
{
            try
            {
                String username = editText1.getText().toString();
                String password = editText2.getText().toString();

                switch (username)
                {
                    case "abc":
                        if (password.equals("123"))
                        {
                            Intent intent = new Intent(getApplicationContext(), Menu_Actitivity.class);
                            intent.putExtra("username", username);
                            intent.putExtra("password", password);
                            startActivity(intent);
                        } else
                        {
                            Toast.makeText(this, "Invalid Password", Toast.LENGTH_LONG).show();
                        }
                        break;
                    case "def":
                        if (password.equals("456"))
                        {
                            Intent intent = new Intent(getApplicationContext(), Menu_Actitivity.class);
                            intent.putExtra("username", username);
                            intent.putExtra("password", password);
                            startActivity(intent);
                        } else {
                            Toast.makeText(this, "Invaid Password", Toast.LENGTH_LONG).show();
                        }
                        break;
                }
            }catch (Exception e)
            {
                e.printStackTrace();
            }

        }



    }
