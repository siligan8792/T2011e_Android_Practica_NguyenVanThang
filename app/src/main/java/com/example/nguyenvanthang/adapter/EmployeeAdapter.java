package com.example.nguyenvanthang.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nguyenvanthang.R;
import com.example.nguyenvanthang.database.Employee;

import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter {

    Activity activity;
    List<Employee>listEmployee;

    public EmployeeAdapter(Activity activity, List<Employee> listEmployee) {
        this.activity = activity;
        this.listEmployee = listEmployee;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = activity.getLayoutInflater().inflate(R.layout.item_employee,parent,false);
        EmployeeHolder holder = new EmployeeHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        EmployeeHolder vh = (EmployeeHolder) holder;
        Employee model = listEmployee.get(position);
        vh.tvID.setText(model.id+"");
        vh.tvName.setText(model.name);
        vh.tvDes.setText(model.des);
        vh.tvSalary.setText(model.salary);
    }

    @Override
    public int getItemCount() {
        return listEmployee.size();
    }
    public class EmployeeHolder extends RecyclerView.ViewHolder{
        TextView tvName, tvID, tvDes,tvSalary;
        public EmployeeHolder (View itemView){
            super(itemView);
            tvID = itemView.findViewById(R.id.tvID);
            tvName = itemView.findViewById(R.id.tvName);
            tvDes = itemView.findViewById(R.id.tvDes);
            tvSalary = itemView.findViewById(R.id.tvSalary);
        }
    }
    public  void  reloadData(List<Employee>employees){
        this.listEmployee = employees;
        this.notifyDataSetChanged();
    }
}
