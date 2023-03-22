package com.example.car.Screen_Login_Register;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.AnimationUtils;

import com.example.car.R;
import com.example.car.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Animation();
    }

    void Animation(){
        binding.imageIconLoin.startAnimation(AnimationUtils.loadAnimation(LoginActivity.this, R.anim.lefttoright));
        binding.tvDetailsIntro3.startAnimation(AnimationUtils.loadAnimation(LoginActivity.this, R.anim.fadein));
        binding.tvMyCarLogin.startAnimation(AnimationUtils.loadAnimation(LoginActivity.this, R.anim.fadein));
        binding.cardLogin.startAnimation(AnimationUtils.loadAnimation(LoginActivity.this, R.anim.fadein));
    }
}