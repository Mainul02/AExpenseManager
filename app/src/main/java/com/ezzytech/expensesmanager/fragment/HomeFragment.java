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
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.ezzytech.expensesmanager.R;
import com.ezzytech.expensesmanager.Spinner_Classes.AllArray;
import com.ezzytech.expensesmanager.Spinner_Classes.MonthAdapter;
import com.yangp.ypwaveview.YPWaveView;

import java.util.ArrayList;


public class HomeFragment extends Fragment {
    private Context context;
    private TextView incomeHomFregment, expensesHomFregment, balanceHomFregment;
    private RecyclerView HomFregmentRV;
    private ImageView addButtonHomFregment, subtractButtonHomFregment;
    private Spinner spinnerHomeFregment;
    private FragmentManager fragmentManagerHomeFragment;
    private FragmentTransaction fragmentTransactionHomeFragment;
    private LinearLayout incomeLayoutHomeFregment,expensesLayoutHomeFregment;
    private AllArray allArrayHomeFregment;
    private MonthAdapter monthAdapterHomeFregment;
    private ArrayList<AllArray> allArrays_HomeFregment;
    private YPWaveView ypWaveViewHomeFragment;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View homeFregmentView= inflater.inflate(R.layout.fragment_home, container, false);

        spinnerHomeFregment=homeFregmentView.findViewById(R.id.spinner_Home_Fregment);
        incomeHomFregment = homeFregmentView.findViewById(R.id.incomehome_fragment);
        expensesHomFregment = homeFregmentView.findViewById(R.id.expenseshome_fragment);
        balanceHomFregment = homeFregmentView.findViewById(R.id.balancehome_fragment);
        HomFregmentRV = homeFregmentView.findViewById(R.id.home_fragmentRV);
        addButtonHomFregment = homeFregmentView.findViewById(R.id.add_button_home_fragment);
        subtractButtonHomFregment = homeFregmentView.findViewById(R.id.subtract_button_home_fragment);
        incomeLayoutHomeFregment= homeFregmentView.findViewById(R.id.incomTitelLayouthome_fragment);
        expensesLayoutHomeFregment= homeFregmentView.findViewById(R.id.expensesTitelLayouthome_fragment);

        allArrayHomeFregment = new AllArray();
        allArrays_HomeFregment=allArrayHomeFregment.getMonthName();
        monthAdapterHomeFregment=new MonthAdapter(context,allArrays_HomeFregment);
        spinnerHomeFregment.setAdapter(monthAdapterHomeFregment);



        init();

        return homeFregmentView;
    }

    private void init() {

        addButtonHomFregment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddIncome addIncome = new AddIncome();
                loadFragment(addIncome);

            }
        });
        subtractButtonHomFregment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddExpenses addExpenses = new AddExpenses();
                loadFragment(addExpenses);
            }
        });

        incomeLayoutHomeFregment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowIncome showIncome = new ShowIncome();
                loadFragment(showIncome);
            }
        });

        expensesLayoutHomeFregment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowExpenses showExpenses = new ShowExpenses();
                loadFragment(showExpenses);
            }
        });
    }




    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context=context;

    }
    public HomeFragment() {
        // Required empty public constructor
    }

    public void loadFragment(Fragment fragment) {
        fragmentManagerHomeFragment = getFragmentManager();
        fragmentTransactionHomeFragment = fragmentManagerHomeFragment.beginTransaction();
        fragmentTransactionHomeFragment.replace(R.id.main_frame_container, fragment);
        fragmentTransactionHomeFragment.addToBackStack(null);
        fragmentTransactionHomeFragment.commit();

    }
}
