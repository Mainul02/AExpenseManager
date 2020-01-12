package com.ezzytech.expensesmanager.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.ezzytech.expensesmanager.R;
import com.ezzytech.expensesmanager.Spinner_Classes.AllArray;
import com.ezzytech.expensesmanager.Spinner_Classes.MonthAdapter;
import com.ezzytech.expensesmanager.date_time.Date_Time;

import java.util.ArrayList;

public class AddExpenses extends Fragment {
    private Context context;
    private ImageView tooberBackArrowAddExpense,saveButtonAddAddExpense;
    private Spinner spinnerCategoryAddExpense;
    private EditText addExpenseAmountET, addExpenseNoteET;
    private FragmentManager fragmentManagerAddExpenseFragment;
    private FragmentTransaction fragmentTransactionAddExpenseFragment;
    private AllArray allArrayAddExpenseFregment,allArrayAddExpenseFregmentPaymentCat;
    private MonthAdapter monthAdapterAddExpenseFregment;
    private ArrayList<AllArray> allArrays_AddExpenseeFregment,allArrays_AddExpenseeFregmentPaymentCat;
    private TextView addDateExpense,addTimeExpense;
    private Date_Time date_time;

    public AddExpenses() {
        // Required empty public constructor
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context=context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View addExpenseView= inflater.inflate(R.layout.fragment_add_expenses, container, false);

        date_time = new Date_Time(this.context);

        tooberBackArrowAddExpense=addExpenseView.findViewById(R.id.toober_back_arrow);
        spinnerCategoryAddExpense=addExpenseView.findViewById(R.id.incomeCategorySpinner);
        addExpenseAmountET=addExpenseView.findViewById(R.id.addAmount);
        addExpenseNoteET=addExpenseView.findViewById(R.id.addNote);
        saveButtonAddAddExpense=addExpenseView.findViewById(R.id.save_button);

        addDateExpense = addExpenseView.findViewById(R.id.addDateExpense);
        addTimeExpense = addExpenseView.findViewById(R.id.addTimeExpense);

        allArrayAddExpenseFregment = new AllArray();
        allArrays_AddExpenseeFregment=allArrayAddExpenseFregment.getExpenseName();
        monthAdapterAddExpenseFregment=new MonthAdapter(getContext(),allArrays_AddExpenseeFregment);
        spinnerCategoryAddExpense.setAdapter(monthAdapterAddExpenseFregment);

        spinnerCategoryAddExpense.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                AllArray clickedCatagory = (AllArray) parent.getItemAtPosition(position);
                String clickedCatagoryName = clickedCatagory.getItemName();
                int clickedCatagoryIcon=clickedCatagory.getIcon();
                Toast.makeText(getContext(), clickedCatagoryName + " selected", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        allArrayAddExpenseFregmentPaymentCat = new AllArray();
        allArrays_AddExpenseeFregmentPaymentCat=allArrayAddExpenseFregmentPaymentCat.getPaymentCatagory();
        monthAdapterAddExpenseFregment=new MonthAdapter(getContext(),allArrays_AddExpenseeFregmentPaymentCat);


        tooberBackArrowAddExpense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeFragment homeFragment =new HomeFragment();
                loadFragment(homeFragment);

            }
        });

        saveButtonAddAddExpense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(getContext(), "Save Button active", Toast.LENGTH_SHORT).show();

            }
        });

        return addExpenseView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        addDateExpense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                date_time.handleDateButton();
//                String date=date_time.thisIsDate;               // ------------------------------------------------------------------????????????????
//                addDateExpense.setText(date);
//                Toast.makeText(getContext(), date + " selected", Toast.LENGTH_SHORT).show();
            }
        });
        addTimeExpense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                date_time.handleTimeButton();
//                String time=date_time.thisIsTime;                ------------------------------------------------------------------????????????????
//                addTimeExpense.setText(time);
            }
        });

    }



    public void loadFragment(Fragment fragment) {
        fragmentManagerAddExpenseFragment = getFragmentManager();
        fragmentManagerAddExpenseFragment.popBackStackImmediate();   //------something fishy,fragment is changing on its own.why men why?????---------//
        fragmentTransactionAddExpenseFragment = fragmentManagerAddExpenseFragment.beginTransaction();
        fragmentTransactionAddExpenseFragment.replace(R.id.main_frame_container, fragment);
        fragmentTransactionAddExpenseFragment.addToBackStack(null);
        fragmentTransactionAddExpenseFragment.commit();

    }



}
