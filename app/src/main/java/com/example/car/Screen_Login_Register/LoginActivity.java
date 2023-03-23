package com.example.car.Screen_Login_Register;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.example.car.R;
import com.example.car.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnSignIn.setOnClickListener(view -> {
            if (binding.dividerM.getVisibility() == View.VISIBLE){
                Toast.makeText(this, "Merchant", Toast.LENGTH_SHORT).show();
            }
            if (binding.dividerC.getVisibility() == View.VISIBLE){
                Toast.makeText(this, "Customer", Toast.LENGTH_SHORT).show();
            }
        });
        Animation();
        selectAccount();
    }

    void Animation() {
        binding.imageIconLoin.startAnimation(AnimationUtils.loadAnimation(LoginActivity.this, R.anim.lefttoright));
        binding.tvDetailsIntro3.startAnimation(AnimationUtils.loadAnimation(LoginActivity.this, R.anim.fadein));
        binding.tvMyCarLogin.startAnimation(AnimationUtils.loadAnimation(LoginActivity.this, R.anim.fadein));
        binding.cardLogin.startAnimation(AnimationUtils.loadAnimation(LoginActivity.this, R.anim.fadein));
    }

    void selectAccount() {
        binding.tvMerchant.setOnClickListener(view -> {
            binding.tvMerchant.setBackground(getDrawable(R.drawable.shape_btn_next));
            binding.tvMerchant.setTextColor(getColor(R.color.white));
            binding.tvCustomer.setBackground(getDrawable(R.drawable.shape_edit_login));
            binding.tvCustomer.setTextColor(getColor(R.color.teal_700));
            binding.dividerM.setVisibility(View.VISIBLE);
            binding.dividerC.setVisibility(View.INVISIBLE);
        });
        binding.tvCustomer.setOnClickListener(view -> {
            binding.tvCustomer.setBackground(getDrawable(R.drawable.shape_btn_next));
            binding.tvCustomer.setTextColor(getColor(R.color.white));
            binding.tvMerchant.setBackground(getDrawable(R.drawable.shape_edit_login));
            binding.tvMerchant.setTextColor(getColor(R.color.teal_700));
            binding.dividerC.setVisibility(View.VISIBLE);
            binding.dividerM.setVisibility(View.INVISIBLE);
        });
    }

}