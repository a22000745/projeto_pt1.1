package pt.ulusofona.deisi.cm2223.app

import java.text.SimpleDateFormat
import java.util.*

class Movie(var nome : String,
            var cinema : String,
            var data : Calendar,
             var avaliacao : Int,
            //var fotos: List<String> = listOf<String>(),
            var observacoes : String){
    fun getData():String{
        val dateFormat = SimpleDateFormat("dd-MM-yyyy",Locale.getDefault())
        return dateFormat.format(data.time)
    }
}