package com.example.car;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.car.Adapter.WelcomeAdapter;
import com.example.car.Screen_Login_Register.LoginActivity;
import com.example.car.Welcome.AddCarFragment;
import com.example.car.Welcome.SearchFragment;
import com.example.car.Welcome.UsersFragment;
import com.example.car.databinding.ActivityIntroductionBinding;

import java.util.ArrayList;

public class IntroductionActivity extends AppCompatActivity {

    ActivityIntroductionBinding binding;
    ArrayList<Fragment> arrayList;
    WelcomeAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityIntroductionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnNext.setOnClickListener(view -> {
            startActivity(new Intent(getBaseContext(), LoginActivity.class));
            finish();
        });

        arrayList = new ArrayList<>();
        arrayList.add(new AddCarFragment());
        arrayList.add(new UsersFragment());
        arrayList.add(new SearchFragment());

        adapter = new WelcomeAdapter(IntroductionActivity.this,arrayList);
        binding.viewPager2.setAdapter(adapter);
        binding.viewPager2.setUserInputEnabled(false);

        binding.btnNext.setOnClickListener(view -> {
            if (binding.viewPager2.getCurrentItem() == 0){
                binding.viewPager2.startAnimation(AnimationUtils.loadAnimation(IntroductionActivity.this, R.anim.fadein_fast));
                binding.viewPager2.setCurrentItem(1);
            }
            else if (binding.viewPager2.getCurrentItem() == 1){
                binding.viewPager2.startAnimation(AnimationUtils.loadAnimation(IntroductionActivity.this, R.anim.fadein));
                binding.viewPager2.setCurrentItem(2);
            }
            else if (binding.viewPager2.getCurrentItem() == 2){
                startActivity(new Intent(getBaseContext(),LoginActivity.class));
                finish();
            }
        });

        binding.btnBack.setOnClickListener(view -> {
            if (binding.viewPager2.getCurrentItem() == 1){
                binding.viewPager2.startAnimation(AnimationUtils.loadAnimation(IntroductionActivity.this, R.anim.fadein_fast));
                binding.viewPager2.setCurrentItem(0);
            }
            else if (binding.viewPager2.getCurrentItem() == 2){
                binding.viewPager2.startAnimation(AnimationUtils.loadAnimation(IntroductionActivity.this, R.anim.fadein));
                binding.viewPager2.setCurrentItem(1);
            }
        });
        Animation();
    }

    void Animation(){
        binding.imageIconIntro.startAnimation(AnimationUtils.loadAnimation(IntroductionActivity.this, R.anim.lefttoright));
        binding.tvMyCarIntro.startAnimation(AnimationUtils.loadAnimation(IntroductionActivity.this, R.anim.fadein));
        binding.tvDetailsIntro.startAnimation(AnimationUtils.loadAnimation(IntroductionActivity.this, R.anim.fadein));
        binding.cardWelcome.startAnimation(AnimationUtils.loadAnimation(IntroductionActivity.this, R.anim.fadein_fast));
    }
}