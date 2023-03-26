package com.example.car.Screen_Home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.car.Adapter.CarAdapter;
import com.example.car.Adapter.WelcomeAdapter;
import com.example.car.Model.Car;
import com.example.car.R;
import com.example.car.Screen_Fragment.AddPostFragment;
import com.example.car.Screen_Fragment.HomeFragment;
import com.example.car.databinding.ActivityHomeBinding;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.Calendar;

public class HomeActivity extends AppCompatActivity {

    ActivityHomeBinding binding;
    ArrayList<Car> carArrayList;
    CarAdapter carAdapter;
    ArrayList<Fragment> arrayList;
    WelcomeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<String> yearsList = new ArrayList<>();
        int current_year = Calendar.getInstance().get(Calendar.YEAR);
        int count = 60;
        for (int i = 0; i < count; i++) {
            yearsList.add(Integer.toString(current_year - i));
        }
        ArrayAdapter<String> yearsAdapter = new ArrayAdapter<>
                (this, android.R.layout.simple_spinner_item, yearsList);
        binding.spinnerYear.setAdapter(yearsAdapter);

        arrayList = new ArrayList<>();
        arrayList.add(new HomeFragment());
        arrayList.add(new AddPostFragment());
        arrayList.add(new AddPostFragment());
        arrayList.add(new AddPostFragment());

        adapter = new WelcomeAdapter(HomeActivity.this, arrayList);
        binding.viewPagerHome.setAdapter(adapter);
        binding.viewPagerHome.setUserInputEnabled(false);

        binding.bottomNavigationHome.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int itemId = item.getItemId();
                if (itemId == R.id.home_nav) {
                    binding.viewPagerHome.setCurrentItem(0);
                } else if (itemId == R.id.search_nav) {
                    binding.viewPagerHome.setCurrentItem(1);
                } else if (itemId == R.id.add_nav) {
                    binding.viewPagerHome.setCurrentItem(0);
                } else if (itemId == R.id.buy_nav) {
                    binding.viewPagerHome.setCurrentItem(3);
                }else if (itemId == R.id.user_nav) {
                    binding.viewPagerHome.setCurrentItem(4);
                }
                return false;
            }
        });

        binding.viewPagerHome.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
               binding.bottomNavigationHome.getMenu().getItem(position).setChecked(true);
            }
        });

        binding.imageAddPost.setOnClickListener(v -> {
            startActivity(new Intent(getBaseContext(),AddPostActivity.class));
        });
    }
}