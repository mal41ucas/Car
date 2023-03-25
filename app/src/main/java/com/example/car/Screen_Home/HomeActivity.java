package com.example.car.Screen_Home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.example.car.Adapter.CarAdapter;
import com.example.car.Adapter.WelcomeAdapter;
import com.example.car.Model.Car;
import com.example.car.R;
import com.example.car.Screen_Fragment.AddPostFragment;
import com.example.car.databinding.ActivityHomeBinding;

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
        ArrayAdapter<String> yearsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, yearsList);
        binding.spinnerYear.setAdapter(yearsAdapter);

        arrayList = new ArrayList<>();
        arrayList.add(new AddPostFragment());
//        arrayList.add(new SearchFragment());
//        arrayList.add(new UsersFragment());

        adapter = new WelcomeAdapter(HomeActivity.this, arrayList);
        binding.viewPagerHome.setAdapter(adapter);
        binding.viewPagerHome.setUserInputEnabled(false);
    }
}