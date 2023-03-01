package com.example.nguyenvanthang.database;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nguyenvanthang.R;
import com.example.nguyenvanthang.adapter.EmployeeAdapter;

import java.util.List;

public class ListEmpActivity extends AppCompatActivity {
    RecyclerView rvEmp;
    AppDatabase db;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);
        db = AppDatabase.getAppDatabase(this);
        List<Employee>listEmp = db.employeeDao().getAllEmployee();
        EmployeeAdapter adapter = new EmployeeAdapter(this,listEmp);
    }
}
