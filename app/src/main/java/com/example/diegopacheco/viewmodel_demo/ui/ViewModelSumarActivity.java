package com.example.diegopacheco.viewmodel_demo.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.diegopacheco.viewmodel_demo.R;
import com.example.diegopacheco.viewmodel_demo.Sumar;
import com.example.diegopacheco.viewmodel_demo.viewmodel.SumarViewModel;

public class ViewModelSumarActivity extends AppCompatActivity {

    private TextView tvSumar,tvSumarViewModel;
    private Button btnSumar;

    private int numero;
    private SumarViewModel sumarViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_model_sumar);
        configView();
    }

    private void configView(){
        //instanciar viewModel
        sumarViewModel = ViewModelProviders.of(this).get(SumarViewModel.class);

        tvSumar = findViewById(R.id.tv_Sumar);
        tvSumarViewModel = findViewById(R.id.tv_SumarViewModel);

        tvSumar.setText("" + numero);
        tvSumarViewModel.setText("" + sumarViewModel.getResultado());

        btnSumar = findViewById(R.id.btnSumar);
        btnSumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numero = Sumar.sumar(numero);
                tvSumar.setText("" + numero);
                sumarViewModel.setResultado(Sumar.sumar(sumarViewModel.getResultado()));
                tvSumarViewModel.setText("" + sumarViewModel.getResultado());
            }
        });

    }
}
