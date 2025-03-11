package com.training.app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.training.app.R;
import com.training.app.DashboardActivity;

public class Scroll extends AppCompatActivity {

    Button BackDashboard,BackProfileActivity;
    TextView NameShow,CourseShow,EmailShow,PhoneShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_scroll);

        NameShow=findViewById(R.id.showName);
        CourseShow=findViewById(R.id.showCourse);
        EmailShow=findViewById(R.id.showEmail);
        PhoneShow=findViewById(R.id.showPhone);
        BackDashboard=findViewById(R.id.btnBackDashboard);
        BackProfileActivity=findViewById(R.id.btnBackProfileActivity);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        SharedPreferences sharedPreferencesProfileActivity = getSharedPreferences("userData",MODE_PRIVATE);
        String savedName =  sharedPreferencesProfileActivity.getString("name", "");
        String savedCourse =  sharedPreferencesProfileActivity.getString("course", "");
        String savedEmail =  sharedPreferencesProfileActivity.getString("email", "");
        String savedPhone =  sharedPreferencesProfileActivity.getString("phone", "");

        NameShow.setText("Name : "+savedName);
        CourseShow.setText("Course : "+savedCourse);
        EmailShow.setText("Email : "+savedEmail);
        PhoneShow.setText("Phone : "+savedPhone);

        BackDashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Scroll.this, DashboardActivity.class));
            }
        });

        BackProfileActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Scroll.this,NewActivity.class));
            }
        });
    }
}

