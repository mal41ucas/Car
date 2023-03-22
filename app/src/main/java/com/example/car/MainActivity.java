package com.example.car;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AnimationUtils;

import com.example.car.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    startActivity(new Intent(getBaseContext(), IntroductionActivity.class));
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        Animation();
    }

    void Animation() {
        binding.imageViewIcon.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.lefttoright));
        binding.imageViewTop.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.fadein));
        binding.imageViewBottom.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.lefttoright));
        binding.tvDetailsSplash.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.fadein));
        binding.tvMyCarSplash.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.fadein));
    }
}