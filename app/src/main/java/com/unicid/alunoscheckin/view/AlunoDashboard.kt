package com.unicid.alunoscheckin.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.unicid.alunoscheckin.R

class AlunoDashboard : AppCompatActivity() {

    var disciplinas: HashMap<Int, String> = HashMap()
    var alunos: HashMap<Int, String> = HashMap()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aluno_dashboard)

        inserirDisciplinas()
        inserirAlunos()
    }

    fun inserirDisciplinas(){
        disciplinas.put(1, "Projeto Interdisciplinar I")
        disciplinas.put(2, "Projeto Interdisciplinar II")
        disciplinas.put(3, "Projeto Interdisciplinar III")
        disciplinas.put(4, "Projeto Interdisciplinar IV")
        disciplinas.put(5, "Algoritmos e Lógica de Programação")
        disciplinas.put(6, "Programação Estruturada I")
        disciplinas.put(7, "Programação Estruturada II")
        disciplinas.put(8, "Programação Orientada a Objetos I")
        disciplinas.put(9, "Programação Orientada a Objetos II")
        disciplinas.put(10, "Banco de Dados")
        disciplinas.put(11, "Programação Web")
        disciplinas.put(12, "Engenharia de Software I")
        disciplinas.put(13, "Engenharia de Software II")
        disciplinas.put(14, "Programação para Android")
        disciplinas.put(15, "Análise e Projeto de Sistemas I")
        disciplinas.put(16, "Análise e Projeto de Sistemas II")
    }

    fun inserirAlunos(){
        alunos.put(1, "Pedro Henrique Cardoso Silva")
        alunos.put(2, "Yago Dias Nunes Costa")
        alunos.put(3, "Maria Nazaré Cardoso")
        alunos.put(4, "Santana Román Salvador")
        alunos.put(5, "Larissa Campos da Silva")
        alunos.put(6, "Ycaro Oliver de Souza")
    }
}