package com.ezzytech.expensesmanager.fragment;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.ezzytech.expensesmanager.R;
import com.ezzytech.expensesmanager.Spinner_Classes.AllArray;
import com.ezzytech.expensesmanager.Spinner_Classes.MonthAdapter;
import com.ezzytech.expensesmanager.date_time.Date_Time;

import java.util.ArrayList;

import io.blackbox_vision.datetimepickeredittext.view.DatePickerEditText;
import io.blackbox_vision.datetimepickeredittext.view.TimePickerEditText;


public class AddIncome extends Fragment {

    private Context context;
    private DatePickerEditText datePickerEditText;
    private TimePickerEditText timePickerEditText;
    private ImageView tooberBackArrowAddIncome,saveButtonAddAddIncome;
    private Spinner spinnerCategoryAddIncome;
    private EditText addIncomeAmountET, addIncomeNoteET;
    private FragmentManager fragmentManagerAddIncomeFragment;
    private FragmentTransaction fragmentTransactionAddIncomeFragment;
    private AllArray allArrayAddIncomeFregment,allArrayAddIncomeFregmentPaymentCat;
    private MonthAdapter monthAdapterAddIncomeFregment;
    private ArrayList<AllArray> allArrays_AddIncomeFregment,allArrays_AddIncomeFregmentPaymentCat;

    private Date_Time date_time;



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context=context;

    }

    public AddIncome() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View addIncomeView= inflater.inflate(R.layout.fragment_add_income, container, false);

        date_time = new Date_Time(this.context);

        datePickerEditText = addIncomeView.findViewById(R.id.datePickerEditText);
        timePickerEditText = addIncomeView.findViewById(R.id.timePickerEditText);

        tooberBackArrowAddIncome=addIncomeView.findViewById(R.id.toober_back_arrow_add_income);
        spinnerCategoryAddIncome=addIncomeView.findViewById(R.id.incomeCategorySpinner_add_income);
        addIncomeAmountET=addIncomeView.findViewById(R.id.addAmount_add_income);
        addIncomeNoteET=addIncomeView.findViewById(R.id.addNote_add_income);
        saveButtonAddAddIncome=addIncomeView.findViewById(R.id.save_button_add_income_add_income);

        allArrayAddIncomeFregment = new AllArray();
        allArrays_AddIncomeFregment=allArrayAddIncomeFregment.getIncomeName();
        monthAdapterAddIncomeFregment=new MonthAdapter(getContext(),allArrays_AddIncomeFregment);
        spinnerCategoryAddIncome.setAdapter(monthAdapterAddIncomeFregment);
        spinnerCategoryAddIncome.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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


        allArrayAddIncomeFregmentPaymentCat = new AllArray();
        allArrays_AddIncomeFregmentPaymentCat=allArrayAddIncomeFregmentPaymentCat.getPaymentCatagory();
        monthAdapterAddIncomeFregment=new MonthAdapter(getContext(),allArrays_AddIncomeFregmentPaymentCat);

        tooberBackArrowAddIncome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeFragment homeFragment =new HomeFragment();
                loadFragment(homeFragment);
            }
        });

        saveButtonAddAddIncome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Save Button active", Toast.LENGTH_SHORT).show();
                insert ();
            }
        });

        return addIncomeView;
    }

    private void insert() {
        long date ;



    }

    /*@Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        addDate_Income.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                date_time.handleDateButton();
            }
        });
        addTime_Income.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                date_time.handleTimeButton();
            }
        });

    }*/


    public void loadFragment(Fragment fragment) {
        fragmentManagerAddIncomeFragment = getFragmentManager();
        fragmentTransactionAddIncomeFragment = fragmentManagerAddIncomeFragment.beginTransaction();
        fragmentTransactionAddIncomeFragment.replace(R.id.main_frame_container, fragment);
        fragmentTransactionAddIncomeFragment.addToBackStack(null);
        fragmentTransactionAddIncomeFragment.commit();

    }

}
