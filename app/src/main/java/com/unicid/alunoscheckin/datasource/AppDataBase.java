package com.unicid.alunoscheckin.datasource;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import com.unicid.alunoscheckin.datamodel.AlunosDataModel;
import com.unicid.alunoscheckin.datamodel.CursaDataModel;
import com.unicid.alunoscheckin.datamodel.DisciplinasDataModel;
import com.unicid.alunoscheckin.model.Alunos;
import com.unicid.alunoscheckin.model.Disciplinas;
import com.unicid.alunoscheckin.view.AlunosDashboard;
import com.unicid.alunoscheckin.view.LoginActivity;

public class AppDataBase extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "INSTITUICAO.sqlite";
    public static final Integer DATABASE_VERSION = 1;
    public static final String TAG = "@ALUNOS_CHECKIN";
    static Intent intent;

    static SQLiteDatabase sqLiteDatabase;

    public AppDataBase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

        sqLiteDatabase = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try {
            sqLiteDatabase.execSQL(DisciplinasDataModel.queryCreateTable());
            Log.i(TAG, "onCreate: "+DisciplinasDataModel.queryCreateTable());

            sqLiteDatabase.execSQL(AlunosDataModel.queryCreateTable());
            Log.i(TAG, "onCreate: "+AlunosDataModel.queryCreateTable());

            sqLiteDatabase.execSQL(CursaDataModel.queryCreateTable());
            Log.i(TAG, "onCreate: "+CursaDataModel.queryCreateTable());



        } catch(SQLiteException e){
            Log.e(TAG, "onCreate: "+e.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public static Boolean insert(String tabela, ContentValues values){
        boolean result = false;

        try {
            result = sqLiteDatabase.insert(tabela, null, values) > 0;
        } catch(Exception e){
            Log.e(TAG, "insert: "+e.getMessage());
        }

        return result;
    }

    public static String autenticaUsuario(Alunos alunos){

        String query_select = "SELECT * FROM ALUNOS WHERE REGISTRO_ALUNO = '"+LoginActivity.editRgm.getText().toString()+"' AND SENHA = '"+LoginActivity.editSenha.getText().toString()+"' ";

        Cursor cursor = sqLiteDatabase.rawQuery(query_select, null);
        while(cursor.moveToNext()){
            if(alunos.getRegistroAluno().equals(cursor.getColumnIndex("REGISTRO_ALUNO"))){
                if(alunos.getSenha().equals(cursor.getColumnIndex("SENHA"))){
                    return "sucesso autenticação";
                }
            }
        }

        cursor.close();
        return "falhou autenticação";
    }

}
