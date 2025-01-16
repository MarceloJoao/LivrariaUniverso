    package com.example.applivraria

    import android.content.Intent
    import android.os.Bundle
    import android.widget.Toast
    import androidx.activity.enableEdgeToEdge
    import androidx.appcompat.app.AppCompatActivity
    import androidx.core.view.ViewCompat
    import androidx.core.view.WindowInsetsCompat
    import com.example.applivraria.databinding.ActivityExclusaoLivroBinding

    class ExclusaoLivroActivity : AppCompatActivity() {
        private lateinit var binding: ActivityExclusaoLivroBinding
        private lateinit var banco : BancoLivraria
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            enableEdgeToEdge()
            setContentView(R.layout.activity_exclusao_livro)

            binding = ActivityExclusaoLivroBinding.inflate(layoutInflater)
            setContentView(binding.root)
            banco = BancoLivraria(this)

            binding.btDeleta.setOnClickListener {
                val isbn = binding.edIb.text.toString().toLong()

                val resultado = banco.Deletar(isbn)

                if(resultado > 0){
                    Toast.makeText(this, "Livro deletado com sucesso!", Toast.LENGTH_LONG).show()
                    binding.edIb.setText("")

                    val i = Intent(this, GerenciamentoLivroActivity::class.java)
                    startActivity(i)

                }else{
                    Toast.makeText(this, "Livro não encontrado.", Toast.LENGTH_LONG).show()
                }
            }

            binding.btLim.setOnClickListener {
                binding.edIb.setText("")
            }
        }
    }