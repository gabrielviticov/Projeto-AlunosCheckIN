package com.unicid.alunoscheckin.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;

import com.unicid.alunoscheckin.dataclass.AppCrud;
import com.unicid.alunoscheckin.datamodel.DisciplinasDataModel;
import com.unicid.alunoscheckin.datasource.AppDataBase;
import com.unicid.alunoscheckin.model.Disciplinas;

import java.util.List;

public class DisciplinasController extends AppDataBase implements AppCrud<Disciplinas> {

    ContentValues values;

    public DisciplinasController(Context context) {
        super(context);
    }

    @Override
    public Boolean inserir(Disciplinas obj) {
        values = new ContentValues();
        values.put(DisciplinasDataModel.REGISTRO_DISCIPLINA, obj.getRegistro());
        values.put(DisciplinasDataModel.NOME_DISCIPLINA, obj.getNome());
        values.put(DisciplinasDataModel.CARGA_HORARIA, obj.getCargaHoraria());
        return AppDataBase.insert(DisciplinasDataModel.TABELA, values);
    }

    @Override
    public Boolean alterar(Disciplinas obj) {
        return null;
    }

    @Override
    public Boolean deletar(Integer id) {
        return null;
    }

    @Override
    public List<Disciplinas> listar() {
        return null;
    }
}
