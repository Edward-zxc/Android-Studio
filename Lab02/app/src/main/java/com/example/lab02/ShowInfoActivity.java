package com.example.lab02;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ShowInfoActivity extends AppCompatActivity {
    private TextView tv_name,tv_sno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_show_info);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;});

        tv_name = findViewById(R.id.tv_name);
        tv_sno = findViewById(R.id.tv_sno);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String sno = intent.getStringExtra("sno");
        tv_name.setText("姓名："+name);
        tv_sno.setText("学号："+sno);
    }
}