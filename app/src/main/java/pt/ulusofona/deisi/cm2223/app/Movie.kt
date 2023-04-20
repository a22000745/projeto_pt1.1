package pt.ulusofona.deisi.cm2223.app

import java.util.*

class Movie(var nome : String,
            var cinema : String,
            var data : Date,
             var avaliacao : Int,
            //var fotos: List<String> = listOf<String>(),
            var observacoes : String){
    fun getData():String{
        return "${data.day}-${data.month}-${data.year}"
    }
}