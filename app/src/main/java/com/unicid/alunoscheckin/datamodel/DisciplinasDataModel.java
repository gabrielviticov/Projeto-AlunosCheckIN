package com.unicid.alunoscheckin.datamodel;

public class DisciplinasDataModel {
    public static final String TABELA = "DISCIPLINAS";
    public static final String ID = "ID";
    public static final String REGISTRO_DISCIPLINA = "REGISTRO_DISCIPLINA";
    public static final String NOME_DISCIPLINA = "NOME_DISCIPLINA";
    public static final String CARGA_HORARIA = "CARGA_HORARIA";
    public static String query = "";

    public static String queryCreateTable(){
        query += "CREATE TABLE IF NOT EXISTS "+TABELA+" ( ";
        query += ID+" INTEGER PRIMARY KEY AUTOINCREMENT, ";
        query += REGISTRO_DISCIPLINA+" TEXT NOT NULL UNIQUE, ";
        query += NOME_DISCIPLINA+" TEXT NOT NULL, ";
        query += CARGA_HORARIA+" INTEGER DEFAULT 30 ";
        query += " ) ";

        return query;
    }
}
