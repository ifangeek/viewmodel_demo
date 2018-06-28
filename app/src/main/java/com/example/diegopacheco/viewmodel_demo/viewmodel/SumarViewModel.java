package com.example.diegopacheco.viewmodel_demo.viewmodel;

import android.arch.lifecycle.ViewModel;

public class SumarViewModel  extends ViewModel{

    private int resultado;

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }
}
