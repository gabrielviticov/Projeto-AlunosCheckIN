package com.unicid.alunoscheckin.datamodel;

public class CursaDataModel {
    public static final String TABELA = "CURSA";
    public static final String TABELA_ALUNOS = "ALUNOS";
    public static final String TABELA_DISCIPLINAS = "DISCIPLINAS";
    public static final String ID = "ID";
    public static final String GRADUACAO = "GRADUACAO";
    public static final String SEMESTRE_TURMA = "SEMESTRE_TURMA";
    public static final String ID_ALUNO = "ID_ALUNO";
    public static final String ID_DISCIPLINA = "ID_DISCIPLINA";
    public static String query = "";

    public static String queryCreateTable(){
        query += "CREATE TABLE IF NOT EXISTS "+TABELA+" ( ";
        query += ID+" INTEGER PRIMARY KEY AUTOINCREMENT, ";
        query += GRADUACAO+" TEXT NOT NULL UNIQUE, ";
        query += SEMESTRE_TURMA+" TEXT NOT NULL, ";
        query += ID_ALUNO+" INTEGER NOT NULL, ";
        query += ID_DISCIPLINA+" INTEGER NOT NULL, ";
        query += "FOREIGN KEY ( "+ID_ALUNO+" ) REFERENCES "+TABELA_ALUNOS+" ( "+ID_ALUNO+" )";
        query += "FOREIGN KEY ( "+ID_DISCIPLINA+" ) REFERENCES "+TABELA_DISCIPLINAS+" ( "+ID_DISCIPLINA+" )";
        query += " ) ";
        return query;
    }
}
