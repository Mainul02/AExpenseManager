package com.ezzytech.expensesmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.ezzytech.expensesmanager.fragment.AddExpenses;
import com.ezzytech.expensesmanager.fragment.AddIncome;
import com.ezzytech.expensesmanager.fragment.HomeFragment;
import com.ezzytech.expensesmanager.fragment.ShowExpenses;
import com.ezzytech.expensesmanager.fragment.ShowIncome;

public class MainActivity extends AppCompatActivity {


    private FrameLayout mainFrameLayout;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainFrameLayout = findViewById(R.id.main_frame_container);


        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        HomeFragment homeFragment = new HomeFragment();
        fragmentTransaction.replace(R.id.main_frame_container, homeFragment);
        fragmentTransaction.commit();





    }}
