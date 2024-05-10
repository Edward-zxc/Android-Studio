package com.example.lab02;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("MainActivity","onCreate方法被调用了");
    }
    public void open(View view){
        Intent intent = new Intent(this,SecondActivity.class);
        startActivity(intent);
    }

    protected void onStart(){
        super.onStart();
        Log.i("MainActivity","onStart方法被调用了");
    }
    protected void onResume(){
        super.onResume();
        Log.i("MainActivity","onResume方法被调用了");
    }
    protected void onDestroy(){
        super.onDestroy();
        Log.i("MainActivity","onDestroy方法被调用了");
    }
    protected void onStop(){
        super.onStop();
        Log.i("MainActivity","onStop方法被调用了");
    }
    protected void onRestart(){
        super.onRestart();
        Log.i("MainActivity","onRestart方法被调用了");
    }
}