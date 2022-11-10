package com.unicid.alunoscheckin.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.unicid.alunoscheckin.R;
import com.unicid.alunoscheckin.controller.AlunosController;

public class MainActivity extends AppCompatActivity {

    AlunosController alunosController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alunosController = new AlunosController(getApplicationContext());

        irProxTela();

    }

    protected void irProxTela(){
        Button btnCadastro = findViewById(R.id.btnCadastro);

        btnCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CadastroActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}