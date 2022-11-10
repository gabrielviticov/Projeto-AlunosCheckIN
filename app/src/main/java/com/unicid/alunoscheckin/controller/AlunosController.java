package com.unicid.alunoscheckin.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;

import com.unicid.alunoscheckin.dataclass.AppCrud;
import com.unicid.alunoscheckin.datamodel.AlunosDataModel;
import com.unicid.alunoscheckin.datasource.AppDataBase;
import com.unicid.alunoscheckin.model.Alunos;

import java.util.List;

public class AlunosController extends AppDataBase implements AppCrud<Alunos> {

    ContentValues values;

    public AlunosController(Context context) {
        super(context);
    }

    @Override
    public Boolean inserir(Alunos obj) {
        values = new ContentValues();
        values.put(AlunosDataModel.REGISTRO, obj.getRegistroAluno());
        values.put(AlunosDataModel.NOME, obj.getNomeCompleto());
        values.put(AlunosDataModel.CPF, obj.getCpf());
        values.put(AlunosDataModel.SEXO, obj.getSexo());
        values.put(AlunosDataModel.DTA_NASCIMENTO, obj.getDtaNascimento());
        values.put(AlunosDataModel.EMAIL, obj.getEmail());
        values.put(AlunosDataModel.TELEFONE, obj.getTelefone());
        values.put(AlunosDataModel.SENHA, obj.getSenha());
        return AppDataBase.insert(AlunosDataModel.TABELA, values);
    }

    @Override
    public Boolean alterar(Alunos obj) {
        return null;
    }

    @Override
    public Boolean deletar(Integer id) {
        return null;
    }

    @Override
    public List<Alunos> listar() {
        return null;
    }
}
