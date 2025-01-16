package com.example.applivraria.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.applivraria.databinding.ActivityAlteracaoLivroBinding
import com.example.applivraria.model.BancoLivraria

class AlteracaoLivroActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAlteracaoLivroBinding
    private lateinit var banco : BancoLivraria
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        banco = BancoLivraria(this)
        binding = ActivityAlteracaoLivroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btCadast.setOnClickListener {
            var isbn = binding.edIsbn.text.toString().toLong()

            if(isbn != null){
                val livro = banco.BuscarporIsbn(isbn)

                if(livro != null){
                    binding.edIsbn.setText(livro.ISBN.toString())
                    binding.edTitulo.setText(livro.titulo)
                    binding.edAutor.setText(livro.Autor)
                    binding.edEditora.setText(livro.Editora)
                    binding.edDescricao.setText(livro.Descricao)
                    binding.edImg.setText(livro.urlImagem)
                    Toast.makeText(this, "Livro encontrado!", Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(this, "Livro não encontrado!", Toast.LENGTH_LONG).show()
                }
            }else{
                Toast.makeText(this, "Por favor, insira um isbn valido", Toast.LENGTH_LONG).show()
            }
        }

       binding.btAlterar.setOnClickListener {
           var isbn = binding.edIsbn.text.toString().toLong()
           var titulo = binding.edTitulo.text.toString()
           var autor = binding.edAutor.text.toString()
           var editora = binding.edEditora.text.toString()
           var descricao = binding.edDescricao.text.toString()
           var url = binding.edImg.text.toString()

           if(isbn !=null && titulo.isNotEmpty() && descricao.isNotEmpty() && autor.isNotEmpty() && editora.isNotEmpty() && url.isNotEmpty()){
               val livroAlterado = banco.Alterar(isbn, titulo, autor, editora, descricao, url)

               if(livroAlterado > 0){
                   binding.edIsbn.setText("")
                   binding.edTitulo.setText("")
                   binding.edAutor.setText("")
                   binding.edEditora.setText("")
                   binding.edDescricao.setText("")
                   binding.edImg.setText("")

                   Toast.makeText(this, "Livro alterado com sucesso!", Toast.LENGTH_LONG).show()
                   val i = Intent(this, GerenciamentoLivroActivity::class.java)
                   startActivity(i)
               }else{
                   Toast.makeText(this, "Falha ao alterar livro!", Toast.LENGTH_LONG).show()
               }
           }else{
               Toast.makeText(this, "Preencha todos os campos corretamente!", Toast.LENGTH_LONG).show()
           }

       }
    }
}