package com.example.diegopacheco.viewmodel_demo.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.diegopacheco.viewmodel_demo.R;
import com.example.diegopacheco.viewmodel_demo.ui.ViewModelSumarActivity;

public class MainActivity extends AppCompatActivity {
    private Button btnViewModelSumar,btnViewModelUser,btnLiveDataActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configView();
    }

    public void configView() {
        btnViewModelSumar = findViewById(R.id.btnViewModelSumar);
        btnViewModelSumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ViewModelSumarActivity.class));
            }
        });

        btnViewModelUser = findViewById(R.id.btnViewModelUser);
        btnViewModelUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),ViewModelUserActivity.class));
            }
        });

        btnLiveDataActivity = findViewById(R.id.btnLiveDataUser);
        btnLiveDataActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),LiveDataActivity.class));
            }
        });
    }
}
