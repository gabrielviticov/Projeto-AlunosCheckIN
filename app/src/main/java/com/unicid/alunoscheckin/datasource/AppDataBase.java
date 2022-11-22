package com.unicid.alunoscheckin.datasource;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.unicid.alunoscheckin.datamodel.AlunosDataModel;
import com.unicid.alunoscheckin.datamodel.CursaDataModel;
import com.unicid.alunoscheckin.datamodel.DisciplinasDataModel;
import com.unicid.alunoscheckin.model.Disciplinas;

public class AppDataBase extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "INSTITUICAO.sqlite";
    public static final Integer DATABASE_VERSION = 1;
    public static final String TAG = "@ALUNOS_CHECKIN";

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




            sqLiteDatabase.execSQL(DisciplinasDataModel.queryInsertInto("PRJ67M", "PROJETO INTERDISCIPLINAR III", 120));

            Log.i(TAG, "onCreate: "+DisciplinasDataModel.queryInsertInto("PRJ67M", "PROJETO INTERDISCIPLINAR III", 120));
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
}
