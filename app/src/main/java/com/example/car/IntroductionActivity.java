package com.example.car;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.example.car.databinding.ActivityIntroductionBinding;

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

        binding.btnNext.setOnClickListener(view -> {

        });
    }
}