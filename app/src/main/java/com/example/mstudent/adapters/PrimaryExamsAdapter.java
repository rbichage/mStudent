package com.example.mstudent.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mstudent.R;
import com.example.mstudent.models.PrimaryExam;

import java.util.List;

public class PrimaryExamsAdapter extends RecyclerView.Adapter<PrimaryExamsAdapter.ViewHolder> {

    private Context context;
    private List<PrimaryExam> primaryExamList;

    public PrimaryExamsAdapter(Context context, List<PrimaryExam> primaryExamList) {
        this.context = context;
        this.primaryExamList = primaryExamList;
    }

    public void setPrimaryExamList(List<PrimaryExam> primaryExamList) {
        this.primaryExamList = primaryExamList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.primary_item, parent, false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PrimaryExam primaryExam = primaryExamList.get(position);

        holder.tvSchool.setText(primaryExam.getSchool());
        holder.tvScoreValue.setText(String.valueOf(primaryExam.getTotalscore()));
        holder.tvKlass.setText("level: " + primaryExam.getKlass());

    }

    @Override
    public int getItemCount() {
        if (primaryExamList != null) {
            Log.e("TOTAL ITEMS", "getItemCount: " + primaryExamList.size() );
            return primaryExamList.size();
        }

        else
            return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private CardView primaryCard;
        TextView tvSchool, tvScore, tvScoreValue, tvKlass;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            primaryCard = itemView.findViewById(R.id.primary_item_card);
            primaryCard.setOnClickListener(this);

            tvSchool = itemView.findViewById(R.id.school_name);
            tvScore = itemView.findViewById(R.id.tv_score);
            tvScoreValue = itemView.findViewById(R.id.tv_score_value);
            tvKlass = itemView.findViewById(R.id.student_klass);


        }

        @Override
        public void onClick(View v) {
            PrimaryExam primaryExam = primaryExamList.get(getAdapterPosition());

            Toast.makeText(context, primaryExam.getDate() + " : " + primaryExam.getKlass(), Toast.LENGTH_SHORT).show();


        }
    }
}
