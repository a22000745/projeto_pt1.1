package pt.ulusofona.deisi.cm2223.app

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import pt.ulusofona.deisi.cm2223.app.databinding.FragmentDashBoardBinding
import pt.ulusofona.deisi.cm2223.app.databinding.FragmentFormBinding
import java.util.*

class DashBoardFragment : Fragment() {
    private lateinit var binding: FragmentDashBoardBinding
    private val adapter = NotificationAdapter()
   // val context: Context = this.requireContext()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       val view = inflater.inflate(
           R.layout.fragment_dash_board, container, false
       )
       binding = FragmentDashBoardBinding.bind(view)
       binding.filmesMedia.text = Movies.getAvaliacaoMedia().toString()
       binding.filmesMes.text = Movies.nFilmesMes().toString()
       binding.nEstreias.text = Notifications.getNotificationList().size.toString()
       binding.addNot.setOnClickListener {
           val dialogFragment = AddNotFragment()
           dialogFragment.show(parentFragmentManager, "dialog")
       }
       binding.seeNot.setOnClickListener {
           val dialogFragment = NotificationsFragment()
           dialogFragment.show(parentFragmentManager, "dialog")
       }
       binding.voiceButton.setOnClickListener {
           val dialogFragment = DialogFragment()
           dialogFragment.show(parentFragmentManager, "dialog")
       }
       val list = Notifications.getNotificationList()
       adapter.updateItems(list)
       binding.nEstreias.text = Notifications.getNotificationList().size.toString()
       return  binding.root
    }

    override fun onStart() {
        super.onStart()
        val list = Notifications.getNotificationList()
        adapter.updateItems(list)
    }

}
