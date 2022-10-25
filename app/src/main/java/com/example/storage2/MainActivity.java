package com.example.storage2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBManager dbManager=new DBManager(this);
    }

    public void buSave(View view){
        EditText etUserName=(EditText)findViewById(R.id.etUserName);
        EditText etPassword=(EditText)findViewById(R.id.etPassword);
    }

    public void buLoad(View view){

    }
}