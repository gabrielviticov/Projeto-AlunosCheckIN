package com.unicid.alunoscheckin.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.unicid.alunoscheckin.R;

import org.w3c.dom.Text;

public class AlunosDashboard2 extends AppCompatActivity {

    TextView txtPre1;
    TextView txtPre2;
    TextView txtPoo1;
    TextView txtPoo2;
    TextView txtEng1;
    TextView txtEng2;
    TextView txtEst;
    TextView txtPrw;
    Button btnBack;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alunos_dashboard2);

        findElementsById();
        programmingEvents();
    }

    protected void findElementsById(){
        txtPre1 = findViewById(R.id.txtPre1);
        txtPre2 = findViewById(R.id.txtPre2);
        txtPoo1 = findViewById(R.id.txtPoo1);
        txtPoo2 = findViewById(R.id.txtPoo2);
        txtEng1 = findViewById(R.id.txtEng1);
        txtEng2 = findViewById(R.id.txtEng2);
        txtEst = findViewById(R.id.txtEst);
        txtPrw = findViewById(R.id.txtPrw);
        btnBack = findViewById(R.id.btnBack);
    }

    protected void programmingEvents(){

        txtPre1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(AlunosDashboard2.this, ScanActivity.class);
                startActivity(intent);
                finish();
            }
        });

        txtPre2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(AlunosDashboard2.this, ScanActivity.class);
                startActivity(intent);
                finish();
            }
        });

        txtPoo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(AlunosDashboard2.this, ScanActivity.class);
                startActivity(intent);
                finish();
            }
        });

        txtPoo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(AlunosDashboard2.this, ScanActivity.class);
                startActivity(intent);
                finish();
            }
        });

        txtEng1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(AlunosDashboard2.this, ScanActivity.class);
                startActivity(intent);
                finish();
            }
        });

        txtEng2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(AlunosDashboard2.this, ScanActivity.class);
                startActivity(intent);
                finish();
            }
        });

        txtEst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(AlunosDashboard2.this, ScanActivity.class);
                startActivity(intent);
                finish();
            }
        });

        txtPrw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(AlunosDashboard2.this, AlunosDashboard.class);
                startActivity(intent);
                finish();
            }
        });
    }
}