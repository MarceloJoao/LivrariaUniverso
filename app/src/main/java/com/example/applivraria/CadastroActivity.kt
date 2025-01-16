    package com.example.applivraria

    import android.content.Intent
    import android.os.Bundle
    import android.view.LayoutInflater
    import android.widget.Toast
    import androidx.activity.enableEdgeToEdge
    import androidx.appcompat.app.AppCompatActivity
    import androidx.core.view.ViewCompat
    import androidx.core.view.WindowInsetsCompat
    import com.example.applivraria.databinding.ActivityCadastroBinding

    class CadastroActivity : AppCompatActivity() {
        private lateinit var binding: ActivityCadastroBinding
        private lateinit var banco : BancoLivraria

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            enableEdgeToEdge()
            banco = BancoLivraria(this)
            binding = ActivityCadastroBinding.inflate(layoutInflater)
            setContentView(binding.root)


            binding.btCadast.setOnClickListener {
                var ISBN = binding.edIsbn.text.toString()
                var titulo = binding.edTitulo.text.toString()
                var autor = binding.edAutor.text.toString()
                var editora = binding.edEditora.text.toString()
                var descricao = binding.edDescricao.text.toString()
                var url = binding.edImg.text.toString()

                if(ISBN.isNotEmpty() && titulo.isNotEmpty() && descricao.isNotEmpty() && autor.isNotEmpty() && editora.isNotEmpty() && url.isNotEmpty()){
                    var isbnNumber = ISBN.toLong()
                    banco.Salvar(isbnNumber, titulo, autor, editora, descricao, url)

                    Toast.makeText(this, "Livro cadastrado com sucesso", Toast.LENGTH_LONG).show()

                    binding.edIsbn.setText("")
                    binding.edTitulo.setText("")
                    binding.edAutor.setText("")
                    binding.edEditora.setText("")
                    binding.edDescricao.setText("")
                    binding.edImg.setText("")

                    val i = Intent(this, GerenciamentoLivroActivity::class.java)
                    startActivity(i)
                }else{
                    Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_LONG).show()
                }
            }

            binding.btlimpar.setOnClickListener {
                binding.edIsbn.setText("")
                binding.edTitulo.setText("")
                binding.edAutor.setText("")
                binding.edEditora.setText("")
                binding.edDescricao.setText("")
                binding.edImg.setText("")
            }
        }
    }
