package com.example.applivraria.model

import java.io.Serializable

class Livro(var ISBN: Long = 0, var Autor:String = "", var Editora:String = "", var titulo: String= "", var Descricao:String= "", var urlImagem:String = ""): Serializable {

    override fun toString(): String {
        return "Isbn: $ISBN \n Autor: $Autor \n Editora: $Editora \n Titulo: $titulo \n Descricao: $Descricao \n UrlImagem: $urlImagem"
    }
}