package pt.ulusofona.deisi.cm2223.app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import pt.ulusofona.deisi.cm2223.app.databinding.FragmentAddNotBinding
import pt.ulusofona.deisi.cm2223.app.databinding.FragmentNotificationsBinding

class NotificationsFragment :androidx.fragment.app.DialogFragment()  {
    private val adapter = NotificationAdapter()
    private lateinit var binding: FragmentNotificationsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(
            R.layout.fragment_notifications, container, false
        )
        binding = FragmentNotificationsBinding.bind(view)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        val list = Notifications.getNotificationList()
        adapter.updateItems(list)
        binding.notifications.layoutManager = LinearLayoutManager(requireContext())
        binding.notifications.adapter = adapter
    }
}