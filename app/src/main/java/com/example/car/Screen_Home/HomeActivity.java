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

        Car skoda0 = new Car(getResources().getDrawable(R.drawable.skoda));
        Car golf1 = new Car(getResources().getDrawable(R.drawable.golf));
        Car mercedes2 = new Car(getResources().getDrawable(R.drawable.mercedes));
        Car mitsubishi3 = new Car(getResources().getDrawable(R.drawable.mitsubishi));
        Car kia4 = new Car(getResources().getDrawable(R.drawable.kia));
        Car hundai5 = new Car(getResources().getDrawable(R.drawable.hundi));

        carArrayList.add(skoda0);
        carArrayList.add(golf1);
        carArrayList.add(mercedes2);
        carArrayList.add(mitsubishi3);
        carArrayList.add(kia4);
        carArrayList.add(hundai5);
        carAdapter = new CarAdapter(getBaseContext(),carArrayList);
        binding.spinnerType.setAdapter(carAdapter);
    }
}