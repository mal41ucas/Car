package com.example.car.Screen_Login_Register;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.car.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(ActivityLoginBinding.inflate(getLayoutInflater()).getRoot());
    }
}