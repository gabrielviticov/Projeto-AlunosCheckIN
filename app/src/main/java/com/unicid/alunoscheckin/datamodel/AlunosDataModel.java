package com.unicid.alunoscheckin.datamodel;

public class AlunosDataModel {

    public static final String TABELA = "ALUNOS";
    public static final String ID = "ID";
    public static final String REGISTRO = "REGISTRO_ALUNO";
    public static final String NOME = "NOME_COMPLETO";
    public static final String CPF = "CPF";
    public static final String SEXO = "SEXO";
    public static final String DTA_NASCIMENTO = "DTA_NASCIMENTO";
    public static final String EMAIL = "EMAIL";
    public static final String TELEFONE = "TELEFONE";
    public static final String SENHA = "SENHA";
    public static String query = "";

    public static String queryCreateTable(){

        query += "CREATE TABLE IF NOT EXISTS "+TABELA+" ( ";
        query += ID+" INTEGER PRIMARY KEY AUTOINCREMENT, ";
        query += REGISTRO+" TEXT NOT NULL UNIQUE, ";
        query += NOME+" TEXT NOT NULL, ";
        query += CPF+" TEXT, ";
        query += SEXO+" TEXT, ";
        query += DTA_NASCIMENTO+" TEXT, ";
        query += EMAIL+" TEXT NOT NULL UNIQUE, ";
        query += TELEFONE+" TEXT, ";
        query += SENHA+" TEXT NOT NULL ";
        query += " ) ";

        return query;
    }
}
