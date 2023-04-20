package pt.ulusofona.deisi.cm2223.app

import android.widget.Button
import java.text.SimpleDateFormat
import java.util.*

object Movies {
    private val _movieList = mutableListOf<Movie>(
        Movie("Batman", "Colombo", Date(),9,"Teve intervalo"),
        Movie("Avatar", "Alvalade", Date(),8,"As pipocas eram baratas"),
    )
    val movieList get() = _movieList.toList()

    fun addMovieForm(filme: String,cinema: String,avaliacao: String,date: String, observacoes :String):Boolean {
        val data = parseDate(date)
        data?.let {
            val movie = Movie(filme, cinema, data, avaliacao.toInt(), observacoes)
            _movieList.add(movie)
            return true
        }
        return false
    }
    fun removeMovie(position : Int) :Boolean{
        return if(_movieList.size <= position){
            _movieList.removeAt(position)
            true
        }else{
            false
        }
    }
    fun parseDate(dateString: String): Date? {
        val format = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
        return try {
            format.parse(dateString)
        }catch (e: Exception){
            null
        }
    }
    fun checkDate(date: String, context: FormFragment): String{
        val parsedDate = parseDate(date)
        if (parsedDate != null) {
            if(parsedDate.after(Date())){
                return context.getString(R.string.worning_data_errada)
            }
        }else{
            return context.getString(R.string.worning_data_formato)
        }
        return ""
    }
    fun checkAvaliacao(avaliacao: String, context: FormFragment) :
            String{
        var intAvaliacao = 0
        try {
            intAvaliacao = avaliacao.toInt()
        }catch (e:java.lang.NumberFormatException){
            return "${context.getString(R.string.worning_avaliacao_formato)}\n"
        }
        if(!(intAvaliacao in 1..10)){
            return "${context.getString(R.string.worning_avaliacao_errada)}\n"
        }
        return ""
    }
    fun checkForm(context: FormFragment, filme: String, cinema: String, avaliacao: String, date: String): String{
        var devolve = ""
        if(filme == "" || cinema == "" || date == "" || avaliacao == ""){
            return context.getString(R.string.worning_campos_vazios)
        }
        devolve += checkAvaliacao(avaliacao,context)
        devolve += checkDate(date,context)
        if(devolve.isEmpty()){
            return context.getString(R.string.form_sucesso)
        }
        return devolve
    }
}