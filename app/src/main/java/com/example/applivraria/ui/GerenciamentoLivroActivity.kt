package com.example.applivraria.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.applivraria.databinding.ActivityGerenciamentoLivroBinding

class GerenciamentoLivroActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGerenciamentoLivroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityGerenciamentoLivroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btCadastro.setOnClickListener {
            val i = Intent(this, CadastroActivity::class.java)
            startActivity(i)
        }

        binding.btAtualizar.setOnClickListener {
            val i = Intent(this, AlteracaoLivroActivity::class.java)
            startActivity(i)
        }

        binding.btDeletar.setOnClickListener {
            val i = Intent(this, ExclusaoLivroActivity::class.java)
            startActivity(i)
        }

        binding.btListar.setOnClickListener {
            val i = Intent(this, ListagemLivrosActivity::class.java)
            startActivity(i)
        }
    }
}