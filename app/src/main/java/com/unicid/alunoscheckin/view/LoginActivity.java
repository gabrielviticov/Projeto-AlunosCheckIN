package com.unicid.alunoscheckin.view;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.safetynet.SafetyNet;
import com.google.android.gms.safetynet.SafetyNetApi;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.unicid.alunoscheckin.R;
import com.unicid.alunoscheckin.controller.AlunosController;
import com.unicid.alunoscheckin.controller.DisciplinasController;
import com.unicid.alunoscheckin.model.Alunos;
import com.unicid.alunoscheckin.model.Disciplinas;

import java.util.HashMap;
import java.util.concurrent.Executor;

public class LoginActivity extends AppCompatActivity implements GoogleApiClient.ConnectionCallbacks {

    Button btnEntrar;
    Button btnCadastrar;
    EditText editRgm;
    EditText editSenha;
    Intent intent;
    CheckBox ckCaptcha;
    GoogleApiClient googleApiClient;
    String site ="6LfHrSAjAAAAABkDCci1ufEujimvBlVTCKIuRaq2";
    Disciplinas disciplinas;
    DisciplinasController disciplinasController;
    Alunos alunos;
    AlunosController alunosController;
    public static final String TAG = "@ALUNOS_CHECKIN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findElementsByID();
        forceFields();
        recaptchaSystem();

        disciplinasController = new DisciplinasController(getApplicationContext());
        alunosController = new AlunosController(getApplicationContext());


    }

    protected void recaptchaSystem(){
        googleApiClient= new GoogleApiClient.Builder(this).addApi(SafetyNet.API).addConnectionCallbacks(LoginActivity.this)
                .build();
        googleApiClient.connect();

        ckCaptcha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ckCaptcha.isChecked()){
                    SafetyNet.SafetyNetApi.verifyWithRecaptcha(googleApiClient,site)
                            .setResultCallback(new ResultCallback<SafetyNetApi.RecaptchaTokenResult>() {
                                @Override
                                public void onResult(@NonNull SafetyNetApi.RecaptchaTokenResult recaptchaTokenResult) {
                                    Status status = recaptchaTokenResult.getStatus();
                                    if ((status!=null) && status.isSuccess()){
                                        Toast.makeText(LoginActivity.this,"sucesso",Toast.LENGTH_SHORT).show();
                                        ckCaptcha.setTextColor(Color.BLUE);
                                    }
                                }
                            });
                }else{
                    Toast.makeText(LoginActivity.this,"falha",Toast.LENGTH_SHORT).show();
                    ckCaptcha.setTextColor(Color.RED);
                }
            }
        });

    }

    protected void findElementsByID(){
        btnEntrar = findViewById(R.id.btnEntrar);
        btnCadastrar = findViewById(R.id.btnCadastrar);
        editRgm = findViewById(R.id.editRgm);
        editSenha = findViewById(R.id.editSenha);
        ckCaptcha = findViewById(R.id.ckCaptcha);

    }

    protected void forceFields(){
        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(editRgm.getText().toString()) && TextUtils.isEmpty(editSenha.getText().toString())){
                    editRgm.setError("*");
                    editSenha.setError("*");
                } if(TextUtils.isEmpty(editRgm.getText().toString())){
                    editRgm.setError("*");
                } if(TextUtils.isEmpty(editSenha.getText().toString())){
                    editSenha.setError("*");
                } else {
                    String rgm = editRgm.getText().toString();
                    String senha = editSenha.getText().toString();

                    if(rgm.equals("ER98E4") || rgm.equals("MR56P4") || rgm.equals("SE70W2") || rgm.equals("JH74K1")){

                    }
                }

            }
        });

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(LoginActivity.this, CadastroActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

}