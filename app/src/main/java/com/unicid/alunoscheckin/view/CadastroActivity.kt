package com.unicid.alunoscheckin.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import com.unicid.alunoscheckin.R
import com.unicid.alunoscheckin.controller.AlunosController
import com.unicid.alunoscheckin.model.Alunos

class CadastroActivity : AppCompatActivity() {

    lateinit var editRegistro: EditText
    lateinit var editNome: EditText
    lateinit var editCpf: EditText
    lateinit var editDtaNascimento: EditText
    lateinit var editEmail: EditText
    lateinit var editTelefone: EditText
    lateinit var editSenha: EditText



    lateinit var btnVoltar: Button
    lateinit var btnCadastrar: Button

    lateinit var a1: Alunos
    lateinit var ac: AlunosController

    val TAG: String = "@ALUNOS_CHECKIN"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        findElementsDeclared()
        customizeElements()
        eventsButton()
    }

    fun findElementsDeclared(){
        editRegistro = findViewById(R.id.editRegistro)
        editNome = findViewById(R.id.editNome)
        editCpf = findViewById(R.id.editCpf)
        editDtaNascimento = findViewById(R.id.editDtaNascimento)
        editEmail = findViewById(R.id.editEmail)
        editTelefone = findViewById(R.id.editTelefone)
        editSenha = findViewById(R.id.editSenha)



        btnCadastrar = findViewById(R.id.btnCadastrar)
        btnVoltar = findViewById(R.id.btnVoltar)
    }

    fun customizeElements(){
        editRegistro.hint = "Seu RA: "
        editNome.hint = "Seu Nome: "
        editCpf.hint = "Seu CPF: "
        editDtaNascimento.hint = "Sua data de nascimento: "
        editEmail.hint = "Seu endereço de e-mail: "
        editTelefone.hint = "Seu número de telefone: "
        editSenha.hint = "Sua senha: "


        btnCadastrar.text = "Cadastrar"
        btnVoltar.text = "Voltar"


    }

    fun eventsButton(){
        btnCadastrar.setOnClickListener {
            a1 = Alunos()
            ac = AlunosController(applicationContext)

            if(TextUtils.isEmpty(editRegistro.text)){ editRegistro.error = "*" }
            if(TextUtils.isEmpty(editNome.text)){ editNome.error = "*" }
            if(TextUtils.isEmpty(editEmail.text)){ editEmail.error = "*" }
            if(TextUtils.isEmpty(editSenha.text)){ editSenha.error = "*" }

            if(!TextUtils.isEmpty(editRegistro.text) && !TextUtils.isEmpty(editNome.text) && !TextUtils.isEmpty(editEmail.text) && !TextUtils.isEmpty(editSenha.text)){
                try {
                    a1.registroAluno = editRegistro.text.toString()
                    a1.nomeCompleto = editNome.text.toString()
                    a1.cpf = editCpf.text.toString()
                    a1.dtaNascimento = editDtaNascimento.text.toString()
                    a1.email = editEmail.text.toString()
                    a1.telefone = editTelefone.text.toString()
                    a1.senha = editSenha.text.toString()

                    if(ac.inserir(a1)){
                        Toast.makeText(applicationContext, "O aluno: "+a1.nomeCompleto+" foi inserido com sucesso!", Toast.LENGTH_LONG).show()

                        editRegistro.text.clear()
                        editNome.text.clear()
                        editCpf.text.clear()
                        editDtaNascimento.text.clear()
                        editEmail.text.clear()
                        editTelefone.text.clear()
                        editSenha.text.clear()

                        editRegistro.requestFocus()
                    }
                } catch(e: java.lang.Exception){
                    Log.e(TAG, "eventsButton: error: "+e.message)
                }
            }
        }

        btnVoltar.setOnClickListener {
            startActivity(Intent(this@CadastroActivity, MainActivity::class.java))
            finish()
        }
    }


}