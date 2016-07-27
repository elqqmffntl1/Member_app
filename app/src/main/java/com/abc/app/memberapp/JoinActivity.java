package com.abc.app.memberapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class JoinActivity extends Activity implements View.OnClickListener{
    TextView et_id,et_pw,et_name,et_ssn,et_email,et_phone;
    Button bt_join,bt_reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);
        et_id = (TextView) findViewById(R.id.et_id);
        et_pw = (TextView) findViewById(R.id.et_pw);
        et_name = (TextView) findViewById(R.id.et_name);
        et_ssn = (TextView) findViewById(R.id.et_ssn);
        et_email = (TextView) findViewById(R.id.et_email);
        et_phone = (TextView) findViewById(R.id.et_phone);
        bt_join = (Button) findViewById(R.id.bt_join);
        bt_reset = (Button) findViewById(R.id.bt_reset);
        bt_join.setOnClickListener(this);
        bt_reset.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_join:
                Toast.makeText(JoinActivity.this,"ID :"+et_id.getText().toString()+
                        "PW :"+et_pw.getText().toString()+
                        "NAME :"+et_name.getText().toString()+
                        "SSN :"+et_ssn.getText().toString()+
                        "EMAIL :"+et_email.getText().toString()+
                        "PHONE :"+et_phone.getText().toString(),Toast.LENGTH_LONG).show();
                startActivity(new Intent(this,MainActivity.class));
                break;
            case R.id.bt_reset:
                startActivity(new Intent(this,MainActivity.class));
                break;
        }
    }
}
