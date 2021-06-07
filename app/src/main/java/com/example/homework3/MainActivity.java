package com.example.homework3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Moon> moons = new ArrayList<Moon>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setInitialData();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);
        MoonAdapter.OnStateClickListener moonClickListener = new MoonAdapter.OnStateClickListener() {
            @Override
            public void onStateClick(Moon moon, int position) {
                Toast.makeText(getApplicationContext(), "Был выбрвн пункт" + moon.getName(), Toast.LENGTH_SHORT).show();
            }
        };
        MoonAdapter adapter = new MoonAdapter(this, moons, moonClickListener);
        recyclerView.setAdapter(adapter);
    }

    private void setInitialData() {
        moons.add(new Moon("Планета", "Нептун", R.drawable.neptun));
        moons.add(new Moon("Планета", "Сатурн", R.drawable.saturn));
        moons.add(new Moon("Планета", "Юпитер", R.drawable.yupiter));
        moons.add(new Moon("Планета", "Земля", R.drawable.zemlya));
    }
}