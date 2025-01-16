    package com.example.applivraria.ui

    import android.os.Bundle
    import androidx.activity.enableEdgeToEdge
    import androidx.appcompat.app.AppCompatActivity
    import androidx.recyclerview.widget.DividerItemDecoration
    import androidx.recyclerview.widget.LinearLayoutManager
    import com.example.applivraria.adapter.LivroAdapter
    import com.example.applivraria.databinding.ActivityListagemLivrosBinding
    import com.example.applivraria.model.BancoLivraria

    class ListagemLivrosActivity : AppCompatActivity() {
        private lateinit var binding : ActivityListagemLivrosBinding
        private lateinit var bancoLivraria: BancoLivraria
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            enableEdgeToEdge()
            binding = ActivityListagemLivrosBinding.inflate(layoutInflater)
            setContentView(binding.root)

            bancoLivraria = BancoLivraria(this)

            initRecyclerView()

        }

        fun initRecyclerView(){
            val recyclerView = binding.listaLivros
            recyclerView.layoutManager = LinearLayoutManager(this)

            val listaLivros = bancoLivraria.ListarLivros()

            recyclerView.adapter = LivroAdapter(listaLivros)


            val decoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
            recyclerView.addItemDecoration(decoration)

        }

    }