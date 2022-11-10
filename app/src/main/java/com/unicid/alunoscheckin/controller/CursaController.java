package com.unicid.alunoscheckin.controller;

import android.content.Context;

import com.unicid.alunoscheckin.dataclass.AppCrud;
import com.unicid.alunoscheckin.datasource.AppDataBase;
import com.unicid.alunoscheckin.model.Cursa;

import java.util.List;

public class CursaController extends AppDataBase implements AppCrud<Cursa> {
    public CursaController(Context context) {
        super(context);
    }

    @Override
    public Boolean inserir(Cursa obj) {
        return null;
    }

    @Override
    public Boolean alterar(Cursa obj) {
        return null;
    }

    @Override
    public Boolean deletar(Integer id) {
        return null;
    }

    @Override
    public List<Cursa> listar() {
        return null;
    }
}
