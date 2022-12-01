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
    static Cursor cursor;

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

            sqLiteDatabase.execSQL("SELECT REGISTRO_ALUNO FROM ALUNOS WHERE ID = 1");


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

    public static Boolean validarLogin(String rgm, String senha){
        cursor = sqLiteDatabase.rawQuery("SELECT REGISTRO_ALUNO, SENHA FROM ALUNOS WHERE REGISTRO_ALUNO = ? AND SENHA = ?", new String[] {rgm, senha});

        if(cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }



}
