package com.example.nguyenvanthang;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nguyenvanthang.adapter.EmployeeAdapter;
import com.example.nguyenvanthang.database.AppDatabase;
import com.example.nguyenvanthang.database.Employee;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edName, edDes, edSalary;
    Button btAdd, btUpdate, btDelete;
    AppDatabase db;
    EmployeeAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);
        db = AppDatabase.getAppDatabase(this);
        edName = findViewById(R.id.edName);
        edDes = findViewById(R.id.edDes);
        edSalary = findViewById(R.id.edSalary);
        btAdd = findViewById(R.id.btAdd);
        btAdd.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btAdd:
                onAdd();
                break;
            default:break;
        }
    }
    private void onAdd(){
        if(!validate()){
            return;
        }
        Employee employee = new Employee();
        employee.name = edName.getText().toString();
        employee.des = edDes.getText().toString();
        employee.salary = edSalary.getText().toString();
        long id = db.employeeDao().insertEmployee(employee);
        if(id>0){
            Toast.makeText(this,"Success",Toast.LENGTH_SHORT).show();
        }

    }
    private boolean validate(){
        String mess = null;
        if(edName.getText().toString().trim().isEmpty()){
            mess = "Input Name Please";
        } else if (edDes.getText().toString().trim().isEmpty()) {
            mess = "Input Designation Please";
        } else if (edSalary.getText().toString().trim().isEmpty()) {
            mess = "Input Salary Please";
        }if (mess !=null){
            Toast.makeText(this, mess, Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}