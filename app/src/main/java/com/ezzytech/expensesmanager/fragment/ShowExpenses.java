package com.ezzytech.expensesmanager.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.ezzytech.expensesmanager.R;
import com.ezzytech.expensesmanager.Spinner_Classes.AllArray;
import com.ezzytech.expensesmanager.Spinner_Classes.MonthAdapter;
import com.github.mikephil.charting.charts.PieChart;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class ShowExpenses extends Fragment {

    private Context context;
    private ImageView tooberBackArrowshowExpenses,showExpenseaddExpenses;
    private Spinner showExpensesFilterByMonth;
    private PieChart showExpensesPieChart;
    private RecyclerView showExpensesRV;
    private FragmentManager fragmentManagerShowExpenseFragment;
    private FragmentTransaction fragmentTransactionShowExpenseFragment;
    private AllArray allArrayShowExpenseFregment;
    private MonthAdapter monthAdapterShowExpenseFregment;
    private ArrayList<AllArray> allArrays_ShowExpenseFregment;


    public ShowExpenses() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View showExpensesView= inflater.inflate(R.layout.fragment_show_expenses, container, false);

        tooberBackArrowshowExpenses=showExpensesView.findViewById(R.id.show_expenses_backbutton);
        showExpensesFilterByMonth=showExpensesView.findViewById(R.id.show_expenses_mounth_Spinner);
        showExpensesPieChart=showExpensesView.findViewById(R.id.show_expenses_PieChart);
        showExpensesRV=showExpensesView.findViewById(R.id.expenses_show_RV);
        showExpenseaddExpenses=showExpensesView.findViewById(R.id.subtract_button_show_expense);


        // Inflate the layout for this fragment

        tooberBackArrowshowExpenses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeFragment homeFragment =new HomeFragment();
                loadFragment(homeFragment);
            }
        });

        showExpenseaddExpenses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddExpenses addExpenses =new AddExpenses();
                loadFragment(addExpenses);
            }
        });

        findId();


        return showExpensesView;
    }

    public void loadFragment(Fragment fragment) {
        fragmentManagerShowExpenseFragment = getFragmentManager();
        fragmentTransactionShowExpenseFragment = fragmentManagerShowExpenseFragment.beginTransaction();
        fragmentTransactionShowExpenseFragment.replace(R.id.main_frame_container, fragment);
        fragmentTransactionShowExpenseFragment.addToBackStack(null);
        fragmentTransactionShowExpenseFragment.commit();

    }

    private void findId() {
        allArrayShowExpenseFregment = new AllArray();
        allArrays_ShowExpenseFregment=allArrayShowExpenseFregment.getMonthName();
        monthAdapterShowExpenseFregment=new MonthAdapter(getContext(),allArrays_ShowExpenseFregment);
        showExpensesFilterByMonth.setAdapter(monthAdapterShowExpenseFregment);

    }

}
