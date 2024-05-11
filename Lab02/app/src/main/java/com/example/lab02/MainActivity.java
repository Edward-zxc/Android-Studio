package com.example.lab02;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    private EditText et_name,et_sno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_name = findViewById(R.id.et_name);
        et_sno = findViewById(R.id.et_sno);
    }
    // Register
    public void register(View view) {
        Intent intent = new Intent(this,ShowInfoActivity.class);
        String strName = et_name.getText().toString().trim();
        String strSno = et_sno.getText().toString().trim();
        intent.putExtra("name",strName);
        intent.putExtra("sno",strSno);

        startActivity(intent);
    }
}