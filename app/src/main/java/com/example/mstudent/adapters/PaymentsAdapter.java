package com.example.mstudent.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mstudent.R;
import com.example.mstudent.models.Payment;

import java.util.List;

public class PaymentsAdapter extends RecyclerView.Adapter<PaymentsAdapter.ViewHolder> {
    private Context context;
    private List<Payment> paymentList;

    public PaymentsAdapter(Context context, List<Payment> paymentList) {
        this.context = context;
        this.paymentList = paymentList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.payment_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Payment payment = paymentList.get(position);

        holder.tvSchoolName.setText(payment.getSchool());
        holder.tvDate.setText(String.format("Date Paid: %s", payment.getDate()));
        holder.tvAmount.setText(String.valueOf(payment.getAmount()));

    }

    @Override
    public int getItemCount() {
        return paymentList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        CardView cardView;
        TextView tvSchoolName, tvDate, tvAmount;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.payment_item_card);
            cardView.setOnClickListener(this);

            tvSchoolName = itemView.findViewById(R.id.school_name);
            tvDate = itemView.findViewById(R.id.payment_date);
            tvAmount = itemView.findViewById(R.id.amount_paid);

        }

        @Override
        public void onClick(View v) {


        }
    }
}
