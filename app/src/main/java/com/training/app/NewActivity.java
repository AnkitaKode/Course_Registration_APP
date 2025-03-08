package com.training.app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class NewActivity extends AppCompatActivity {

    Button InsertData,UpdateData,DeleteData,VIEW;
    EditText Name,Email,Course,Phone;
    SharedPreferences sharedPreferencesProfileActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_new);

        InsertData=findViewById(R.id.buttonInsertData);
        UpdateData=findViewById(R.id.buttonUpdateData);
        DeleteData=findViewById(R.id.buttonDeleteData);
        VIEW=findViewById(R.id.buttonView);

        Name=findViewById(R.id.editTextName);
        Email=findViewById(R.id.editTextEmail);
        Course=findViewById(R.id.editTextCourse);
        Phone=findViewById(R.id.editTextPhone);

        sharedPreferencesProfileActivity = getSharedPreferences("userData",MODE_PRIVATE);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Name.setText(sharedPreferencesProfileActivity.getString("name",""));
        Email.setText(sharedPreferencesProfileActivity.getString("email",""));
        Course.setText(sharedPreferencesProfileActivity.getString("course",""));
        Phone.setText(sharedPreferencesProfileActivity.getString("phone",""));



        InsertData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = Name.getText().toString();
                String email = Email.getText().toString();
                String course = Course.getText().toString();
                String phone = Phone.getText().toString();

                if(!name.isEmpty() && !email.isEmpty() && !course.isEmpty() && !phone.isEmpty())
                {
                    SharedPreferences.Editor editor = sharedPreferencesProfileActivity.edit();
                    editor.putString("name", name);
                    editor.putString("course", course);
                    editor.putString("email", email);
                    editor.putString("phone", phone);
                    editor.apply();

                    Toast.makeText(NewActivity.this, "Data Inserted", Toast.LENGTH_SHORT).show();

                }
                else
                {
                    Toast.makeText(NewActivity.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
                }
            }
        });

        DeleteData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferencesProfileActivity.edit();
                editor.clear();
                editor.apply();
                Name.setText("");
                Email.setText("");
                Course.setText("");
                Phone.setText("");
                Toast.makeText(NewActivity.this, "Data Deleted", Toast.LENGTH_SHORT).show();
            }
        });

        UpdateData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = Name.getText().toString().trim();
                String email = Email.getText().toString().trim();
                String course = Course.getText().toString().trim();
                String phone = Phone.getText().toString().trim();

                if(!name.isEmpty() && !email.isEmpty() && !course.isEmpty() && !phone.isEmpty())
                {
                    SharedPreferences.Editor editor = sharedPreferencesProfileActivity.edit();
                    editor.putString("name", name);
                    editor.putString("course", course);
                    editor.putString("email", email);
                    editor.putString("phone", phone);
                    editor.apply();

                    Toast.makeText(NewActivity.this, "Data Updated", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(NewActivity.this, "Please fill all the fields to update!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        VIEW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NewActivity.this,Scroll.class));
            }
        });
    }
}