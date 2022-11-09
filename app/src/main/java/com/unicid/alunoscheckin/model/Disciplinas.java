package com.unicid.alunoscheckin.model;

public class Disciplinas {
    private Integer id;
    private String registro;
    private String nome;
    private Integer cargaHoraria;

    public Disciplinas(){}
    public Disciplinas(Integer id, String registro, String nome, Integer cargaHoraria){
        this.setId(id);
        this.setRegistro(registro);
        this.setNome(nome);
        this.setCargaHoraria(cargaHoraria);
    }

    public Integer getId(){ return id; }
    public String getRegistro(){ return registro; }
    public String getNome(){ return nome; }
    public Integer getCargaHoraria(){ return cargaHoraria; }


    public void setId(Integer id){ this.id = id; }
    public void setRegistro(String registro){ this.registro = registro; }
    public void setNome(String nome){ this.nome = nome; }
    public void setCargaHoraria(Integer cargaHoraria){ this.cargaHoraria = cargaHoraria; }
}
