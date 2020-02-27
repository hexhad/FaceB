package com.hexhad.faceb;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;


public class MainActivity extends AppCompatActivity {


    ViewPager viewPager;
    MyFirstAdapter adapter;
    TabLayout tabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.fragment_1);

        adapter = new MyFirstAdapter(getSupportFragmentManager());
        tabLayout = findViewById(R.id.Tab_Layout);

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        //to crud


//        addData();
//        viewAll();
//        updateData();
//        deleteData();


    }


}
