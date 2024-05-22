package com.example.lab03;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;

public  class MainActivity extends  Activity{
    private Button btBegin;
    private  EditText etName,etNumber,etEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    private void init(){
        btBegin = findViewById(R.id.btBegin);
        etName = findViewById(R.id.btNAME);
        etNumber = findViewById(R.id.btNUMBER);
        etEmail = findViewById(R.id.btEMAIL);
        etName.setTextColor(Color.GRAY);
        etNumber.setTextColor(Color.GRAY);
        etEmail.setTextColor(Color.GRAY);
        btBegin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                startActivityForResult(intent,0);
            }
        });
    }

    @Override
    protected  void onActivityResult(int requestCode, int resultCode, @NonNull Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode == 0 && resultCode == RESULT_OK){
            String name = data.getStringExtra("name");
            String number = data.getStringExtra("number");
            String email = data.getStringExtra("email");
            String result = data.getStringExtra("result");
            if(result.equals("success")){
                Button bt = findViewById(R.id.btBegin);
                bt.setText("联系人信息");
                bt.setEnabled(false);
            }
            etName.setText(name);
            etNumber.setText(number);
            etEmail.setText(email);
        }
    }
}
