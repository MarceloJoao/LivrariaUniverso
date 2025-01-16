package com.example.applivraria

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.applivraria.databinding.ActivityGerenciamentoLivroBinding
import com.example.applivraria.databinding.ActivityLoginBinding

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