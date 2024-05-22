package com.example.lab03;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class  MainActivity2 extends Activity{
    private Button btFinish;
    private EditText etName,etCompany,etNumber,etEmail;
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        init();
    }

    private void init(){
        etName = findViewById(R.id.et_name);
        etCompany = findViewById(R.id.et_company);
        etNumber = findViewById(R.id.et_number);
        etEmail = findViewById(R.id.et_email);
        btFinish = findViewById(R.id.btFinish);
        etName.setTextColor(Color.GRAY);
        etNumber.setTextColor(Color.GRAY);
        etEmail.setTextColor(Color.GRAY);
        etCompany.setTextColor(Color.GRAY);
        btFinish.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v){
                String name = etName.getText().toString();
                String number = etNumber.getText().toString();
                String email = etEmail.getText().toString();
                Intent intent = new Intent(MainActivity2.this,MainActivity.class);
                intent.putExtra("name",name);
                intent.putExtra("number",name);
                intent.putExtra("email",name);
                intent.putExtra("result","success");
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}
