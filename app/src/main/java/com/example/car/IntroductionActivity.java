package com.example.car;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.car.Screen_Login_Register.LoginActivity;
import com.example.car.databinding.ActivityIntroductionBinding;

import java.util.ArrayList;

public class IntroductionActivity extends AppCompatActivity {

    ActivityIntroductionBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityIntroductionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.imageIconIntro.startAnimation(AnimationUtils.loadAnimation(IntroductionActivity.this, R.anim.lefttoright));
        binding.tvMyCarIntro.startAnimation(AnimationUtils.loadAnimation(IntroductionActivity.this, R.anim.fadein));
        binding.tvDetailsIntro.startAnimation(AnimationUtils.loadAnimation(IntroductionActivity.this, R.anim.fadein));
        binding.linearWelcome.startAnimation(AnimationUtils.loadAnimation(IntroductionActivity.this, R.anim.fadein_fast));

        ArrayList<String> arrayList = new ArrayList<>();
        binding.btnNext.setOnClickListener(view -> {
            startActivity(new Intent(getBaseContext(), LoginActivity.class));
            finish();
        });
    }
}