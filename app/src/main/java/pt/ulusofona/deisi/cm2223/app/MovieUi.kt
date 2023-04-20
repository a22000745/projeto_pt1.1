package pt.ulusofona.deisi.cm2223.app

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class MovieUi(var nome : String,
                   var cinema : String,
                   var data : Date,
                   var fotos: List<String> = listOf<String>(),
                   var observacoes : String) : Parcelable {

}