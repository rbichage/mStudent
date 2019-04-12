package com.example.mstudent.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mstudent.R;
import com.example.mstudent.models.UniversityExam;

import java.util.List;

public class UniversityExamsAdapter extends RecyclerView.Adapter<UniversityExamsAdapter.ViewHolder> {
    private Context context;
    private List<UniversityExam> universityExamsList;

    public UniversityExamsAdapter(Context context, List<UniversityExam> universityExamsList) {
        this.context = context;
        this.universityExamsList = universityExamsList;
    }

    @NonNull
    @Override
    public UniversityExamsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.university_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UniversityExamsAdapter.ViewHolder holder, int position) {
        UniversityExam universityExam = universityExamsList.get(position);

        holder.tvCourseCode.setText(universityExam.getCourseCode());
        holder.tvCourseName.setText(universityExam.getCourseName());
        holder.tvScoreValue.setText(String.valueOf(universityExam.getMarks()));

    }

    @Override
    public int getItemCount() {
        return universityExamsList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvCourseCode, tvCourseName, tvScore, tvScoreValue;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCourseCode = itemView.findViewById(R.id.course_code);
            tvCourseName = itemView.findViewById(R.id.course_name);
            tvScore = itemView.findViewById(R.id.tv_score);
            tvScoreValue = itemView.findViewById(R.id.tv_score_value);
        }
    }
}
