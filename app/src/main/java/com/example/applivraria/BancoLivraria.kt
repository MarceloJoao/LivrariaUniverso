package com.example.applivraria

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BancoLivraria(contexto : Context) : SQLiteOpenHelper(contexto, Nome, null, Versao) {

    companion object{
        private const val Nome = "dbLivrariaUniverso"
        private const val Versao = 1
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(
            """
               CREATE TABLE livros(
                  isbn INTEGER PRIMARY KEY,
                  autor TEXT,
                  editora TEXT,
                  titulo TEXT,
                  descricao TEXT,
                  urlimagem TEXT
               ) 
            """
        )
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

    fun Salvar(isbn: Long, titulo:String, autor:String, editora:String, descricao:String, url:String):Long{
         val banco = this.writableDatabase
         val container = ContentValues()
         container.put("isbn", isbn)
         container.put("autor", autor)
         container.put("editora", editora)
         container.put("titulo",titulo)
         container.put("descricao", descricao)
         container.put("urlimagem", url)
         val result = banco.insert("livros", null, container)
         banco.close()
         return result
    }

    fun Alterar(isbn: Long, titulo:String, autor:String, editora:String, descricao:String, url:String):Int{
        val banco = this.writableDatabase
        val container = ContentValues()
        container.put("isbn", isbn)
        container.put("autor", autor)
        container.put("editora", editora)
        container.put("titulo", titulo)
        container.put("descricao", descricao)
        container.put("urlimagem", url)
        val result = banco.update("livros", container, "isbn=" + isbn, null)
        banco.close()
        return result

    }

    fun Deletar(isbn: Long):Int{
        val banco = this.writableDatabase
        val result = banco.delete("livros", "isbn =" + isbn, null)
        banco.close()
        return result
    }

    fun ListarLivros(): ArrayList<Livro> {
       val banco = this.readableDatabase
       var cursor = banco.rawQuery("SELECT * FROM livros", null)
       var array = ArrayList<Livro>()
       if(cursor.count > 0){
           cursor.moveToFirst()
           do{
               var isbnLivro = cursor.getLong(0)
               var autorLivro = cursor.getString(1)
               var editoraLivro = cursor.getString(2)
               var tituloLivro = cursor.getString(3)
               var descricaoLivro = cursor.getString(4)
               var urlImgLivro = cursor.getString(5)
               array.add(Livro(isbnLivro, autorLivro, editoraLivro, tituloLivro, descricaoLivro, urlImgLivro))
           }while (cursor.moveToNext())
       }
        cursor.close()
        banco.close()
        return array
    }

    fun BuscarporIsbn(isbn: Long): Livro{
      val banco = this.readableDatabase
      val cursor = banco.rawQuery("SELECT * FROM livros WHERE isbn=" + isbn, null)
      var livro = Livro()
      if(cursor.count > 0){
          cursor.moveToFirst()
      do{
          livro.ISBN = cursor.getLong(0)
          livro.Autor = cursor.getString(1)
          livro.Editora = cursor.getString(2)
          livro.titulo = cursor.getString(3)
          livro.Descricao = cursor.getString(4)
          livro.urlImagem = cursor.getString(5)

      }while (cursor.moveToNext())

      }
        cursor.close()
       return livro
   }
}

