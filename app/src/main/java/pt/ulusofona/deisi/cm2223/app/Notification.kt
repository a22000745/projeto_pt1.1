package pt.ulusofona.deisi.cm2223.app

import java.text.SimpleDateFormat
import java.util.*

class Notification(val filme : String,val dataEstreia :Calendar) {
    fun getData():String{
        val dateFormat = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
        return dateFormat.format(dataEstreia.time)
    }

}