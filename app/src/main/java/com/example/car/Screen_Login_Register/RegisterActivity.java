package com.example.car.Screen_Login_Register;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.car.databinding.ActivityRegisterBinding;

public class RegisterActivity extends AppCompatActivity {

    ActivityRegisterBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(ActivityRegisterBinding.inflate(getLayoutInflater()).getRoot());
    }
}