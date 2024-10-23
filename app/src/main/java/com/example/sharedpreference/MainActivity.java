package com.example.sharedpreference;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private static final String PREF_NAME = "student_info";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);

        EditText etName = findViewById(R.id.et_name);
        EditText etMSV = findViewById(R.id.et_msv);
        EditText etClass = findViewById(R.id.et_class);
        EditText etAddress = findViewById(R.id.et_address);
        Button btnSave = findViewById(R.id.btn_save);

        btnSave.setOnClickListener(v -> {
            String name = etName.getText().toString();
            String msv = etMSV.getText().toString();
            String classInfo = etClass.getText().toString();
            String address = etAddress.getText().toString();

            saveStudentInfo(name, msv, classInfo, address);
        });

        String name = getStudentName();
        String msv = getStudentMSV();
        String classInfo = getStudentClass();
        String address = getStudentAddress();

    }

    private void saveStudentInfo(String name, String msv, String classInfo, String address) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("student_name", name);
        editor.putString("student_msv", msv);
        editor.putString("student_class", classInfo);
        editor.putString("student_address", address);
    }

    private String getStudentName() {
        return sharedPreferences.getString("student_name", "");
    }

    private String getStudentMSV() {
        return sharedPreferences.getString("student_msv", "");
    }

    private String getStudentClass() {
        return sharedPreferences.getString("student_class", "");
    }

    private String getStudentAddress() {
        return sharedPreferences.getString("student_address", "");
    }
}
