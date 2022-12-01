package com.unicid.alunoscheckin.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.unicid.alunoscheckin.R;

import org.w3c.dom.Text;


public class AlunosDashboard extends AppCompatActivity {

    TextView prj1;
    TextView prj2;
    TextView prj3;
    TextView prj4;
    TextView Alp;
    TextView Bd;
    TextView Aps1;
    TextView Aps2;
    Button btnNext;
    Intent intent;
    Integer qntPresenca = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alunos_dashboard);

        findElementsById();
        navigatorTextViews();


    }

    protected void findElementsById(){
        prj1 = findViewById(R.id.txtPrj1);
        prj2 = findViewById(R.id.txtPrj2);
        prj3 = findViewById(R.id.txtPrj3);
        prj4 = findViewById(R.id.txtPrj4);
        Alp = findViewById(R.id.txtAlp);
        Bd = findViewById(R.id.txtBd);
        Aps1 = findViewById(R.id.txtAps1);
        Aps2 = findViewById(R.id.txtAps2);
        btnNext = findViewById(R.id.btnNext);

    }



    protected void navigatorTextViews(){
        prj1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(AlunosDashboard.this, ScanActivity.class);
                qntPresenca += 1;
                intent.putExtra("presenca", qntPresenca);
                startActivity(intent);
                finish();
            }
        });

        prj2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(AlunosDashboard.this, ScanActivity.class);
                qntPresenca += 1;
                intent.putExtra("presenca", qntPresenca);
                startActivity(intent);
                finish();
            }
        });

        prj3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(AlunosDashboard.this, ScanActivity.class);
                qntPresenca += 1;
                intent.putExtra("presenca", qntPresenca);
                startActivity(intent);
                finish();
            }
        });

        prj4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(AlunosDashboard.this, ScanActivity.class);
                startActivity(intent);
                finish();
            }
        });

        Alp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(AlunosDashboard.this, ScanActivity.class);
                startActivity(intent);
                finish();
            }
        });

        Bd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(AlunosDashboard.this, ScanActivity.class);
                startActivity(intent);
                finish();
            }
        });

        Aps1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(AlunosDashboard.this, ScanActivity.class);
                startActivity(intent);
                finish();
            }
        });

        Aps2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(AlunosDashboard.this, ScanActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(AlunosDashboard.this, AlunosDashboard2.class);
                startActivity(intent);
                finish();
            }
        });

    }


}