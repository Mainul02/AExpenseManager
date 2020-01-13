package com.ezzytech.expensesmanager.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ezzytech.expensesmanager.R;
import com.ezzytech.expensesmanager.database_helper.DatabaseOpenHelper;
import com.ezzytech.expensesmanager.model.Insert;

import java.util.ArrayList;

public class IncomeAdapter extends RecyclerView.Adapter<IncomeAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Insert> inserts;

    private DatabaseOpenHelper helper;

    public IncomeAdapter(Context context, ArrayList<Insert> inserts) {
        this.context = context;
        this.inserts = inserts;
    }

    @NonNull
    @Override
    public IncomeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.show_exp_and_incom_card_desing,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final IncomeAdapter.ViewHolder holder, final int position) {
        final Insert insert = inserts.get(position);

        holder.icon.setImageResource(insert.getImage());
        holder.category.setText(insert.getSpinnerCategory());
        holder.amount.setText(insert.getAmount());

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                helper= new DatabaseOpenHelper(context);
                //helper.deleteData(inserts.getId());
                inserts.remove(position);
                notifyDataSetChanged();
                return false;
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,""+position,Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return inserts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView icon;
        private TextView category,amount;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            icon = itemView.findViewById(R.id.show_expense_income_card_design_icon);
            category = itemView.findViewById(R.id.show_expence_card_desing_catagory_TV);
            amount = itemView.findViewById(R.id.show_expence_card_desing_amount_TV);
        }
    }
}
