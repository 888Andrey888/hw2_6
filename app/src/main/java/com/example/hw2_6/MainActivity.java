package com.example.hw2_6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btEnter = findViewById(R.id.bt_enter);
        EditText etEmail = findViewById(R.id.et_email);
        EditText etPass = findViewById(R.id.et_pass);
        ConstraintLayout clLogin = findViewById(R.id.cl_login);

        if (etEmail.getText().length() == 0 && etPass.getText().length() == 0) {
            btEnter.setEnabled(false);
        } else {
            btEnter.setEnabled(true);
        }

        etEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.toString().length() >= 0) {
                    btEnter.setEnabled(true);
                }
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() <= 0){
                    btEnter.setEnabled(false);
                }
            }
        });

        btEnter.setOnClickListener(view -> {
            if(etEmail.getText().toString().equals("Admin") && etPass.getText().toString().equals("Admin")){
                clLogin.setVisibility(View.GONE);
                Toast.makeText(this, "Вы успешно зарегистрировались", Toast.LENGTH_LONG).show();
            }else {
                Toast.makeText(this, "Неправильный логин и пароль", Toast.LENGTH_LONG).show();
            }
        });
    }
}