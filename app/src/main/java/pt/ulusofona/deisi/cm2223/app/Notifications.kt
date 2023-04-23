package pt.ulusofona.deisi.cm2223.app

import java.util.*

object Notifications {
    private val _notificationList = mutableListOf<Notification>(
        Notification("Super Homem", Movies.dateToCalendar("26-04-2023"))
    )
    val notificationList get() = _notificationList.toList()
    fun addNotification(movie: String,date : String){
        _notificationList.add(Notification(movie,Movies.dateToCalendar(date)))
    }
    fun removeNotification(notification : Notification) :Boolean{
        return if(_notificationList.contains(notification)){
            _notificationList.remove(notification)
            true
        }else{
            false
        }
    }
    fun checkMovie(movie : String, context : AddNotFragment):String{
        return if(Movies.getMovieDataBase().contains(movie)){
            ""
        }else{
            "${context.getString(R.string.worning_filme_errado)}\n"
        }
    }
    fun checkDate(sDate : String, context : AddNotFragment):String{
        if(Movies.parseDate(sDate) == null){
            return context.getString(R.string.worning_data_formato)
        }
        val date = Movies.dateToCalendar(sDate)
        if(date.after(Calendar.getInstance())){
            return ""
        }else{
            return context.getString(R.string.data_no_fut)
        }
    }
    fun checkForm(movie:String,date: String, context : AddNotFragment) : String{
        var devolve = ""
        if(movie == ""||date == ""){
            return context.getString(R.string.worning_campos_vazios)
        }
        devolve+= checkMovie(movie,context)
        devolve+= checkDate(date,context)
        return if(devolve == ""){
            context.getString(R.string.form_sucesso)
        }else{
            devolve
        }
    }
}