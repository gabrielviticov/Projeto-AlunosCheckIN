package com.unicid.alunoscheckin.model;

public class Cursa {
    private Integer id;
    private String graduacao;
    private String semestreTurma;
    private Alunos idAlunos;
    private Disciplinas idDisciplinas;

    public Cursa(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGraduacao() {
        return graduacao;
    }

    public void setGraduacao(String graduacao) {
        this.graduacao = graduacao;
    }

    public String getSemestreTurma() {
        return semestreTurma;
    }

    public void setSemestreTurma(String semestreTurma) {
        this.semestreTurma = semestreTurma;
    }

    public Alunos getIdAlunos() {
        return idAlunos;
    }

    public void setIdAlunos(Alunos idAlunos) {
        this.idAlunos = idAlunos;
    }

    public Disciplinas getIdDisciplinas() {
        return idDisciplinas;
    }

    public void setIdDisciplinas(Disciplinas idDisciplinas) {
        this.idDisciplinas = idDisciplinas;
    }
}
