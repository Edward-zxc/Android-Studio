package com.example.lab03;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    private EditText nameInput;
    private EditText companyInput;
    private EditText phoneInput;
    private EditText emailInput;
    private Button doneButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        nameInput = findViewById(R.id.name_input);
        companyInput = findViewById(R.id.company_input);
        phoneInput = findViewById(R.id.phone_input);
        emailInput = findViewById(R.id.email_input);
        doneButton = findViewById(R.id.done_button);

        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String info = nameInput.getText().toString() + "\n" +
                        companyInput.getText().toString() + "\n" +
                        phoneInput.getText().toString() + "\n" +
                        emailInput.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("info", info);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}