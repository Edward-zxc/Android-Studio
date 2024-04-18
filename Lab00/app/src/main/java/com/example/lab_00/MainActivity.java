package com.example.lab_00;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.*;


import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    private EditText etName, etEmail, etPwd;
    private String name, email, pwd, sex = "", hobbies = ""; // Initialize hobbys with an empty string

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        etName = findViewById(R.id.et_name);
        etEmail = findViewById(R.id.et_email);
        etPwd = findViewById(R.id.et_pwd);
        RadioGroup rg_Sex = findViewById(R.id.rg_sex);
        CheckBox cbSing = findViewById(R.id.cb_sing);
        CheckBox cbDance = findViewById(R.id.cb_dance);
        CheckBox cbRead = findViewById(R.id.cb_read);
        TextView btn_Submit = findViewById(R.id.btn_submit);

        btn_Submit.setOnClickListener(this);

        cbSing.setOnCheckedChangeListener(this);
        cbDance.setOnCheckedChangeListener(this);
        cbRead.setOnCheckedChangeListener(this);

        rg_Sex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rb_boy) {
                    sex = "男";
                } else if (checkedId == R.id.rb_girl) {
                    sex = "女";
                } else {
                    sex = ""; // Handle the case where no radio button is selected
                }
            }
        });
    }

    private void getData() {
        name = etName.getText().toString().trim();
        email = etEmail.getText().toString().trim();
        pwd = etPwd.getText().toString().trim();
    }

    @Override
    public void onClick(View v) {
        int viewId = v.getId();
        if (viewId == R.id.btn_submit) {
            getData();
            if (TextUtils.isEmpty(name)) {
                Toast.makeText(MainActivity.this, "请输入名字", Toast.LENGTH_SHORT).show();
            } else if (TextUtils.isEmpty(email)) {
                Toast.makeText(MainActivity.this, "请输入邮箱", Toast.LENGTH_SHORT).show();
            } else if (TextUtils.isEmpty(pwd)) {
                Toast.makeText(MainActivity.this, "请输入密码", Toast.LENGTH_SHORT).show();
            } else if (TextUtils.isEmpty(sex)) {
                Toast.makeText(MainActivity.this, "请选择性别", Toast.LENGTH_SHORT).show();
            } else if (TextUtils.isEmpty(hobbies)) {
                Toast.makeText(MainActivity.this, "请选择兴趣爱好", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                Log.i("MainActivity", "注册的用户信息：" + "姓名：" + name + "，邮箱：" + email + "，性别：" + sex + "，兴趣爱好：" + hobbies);
            }
        }
    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        String hobby = buttonView.getText().toString();
        if (isChecked) {
            if (!hobbies.contains(hobby)) {
                hobbies += hobby + " "; // Using StringBuilder might be more efficient
            }
        } else {
            hobbies = hobbies.replace(hobby + " ", ""); // Remove the unchecked hobby
        }
    }
}

