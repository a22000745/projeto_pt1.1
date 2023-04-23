package pt.ulusofona.deisi.cm2223.app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import pt.ulusofona.deisi.cm2223.app.databinding.FragmentListBinding

class ListFragment : Fragment() {
    private val adapter = MovieAdapter(::onOperationClick)
    private lateinit var binding: FragmentListBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(
            R.layout.fragment_list, container, false
        )
        binding = FragmentListBinding.bind(view)
        binding.voiceButton.setOnClickListener {
            val dialogFragment = DialogFragment()
            dialogFragment.show(parentFragmentManager, "dialog")
        }
        return binding.root
    }
    override fun onStart() {
        super.onStart()
        val list = Movies.movieList
        adapter.updateItems(list)
        binding.list.layoutManager = LinearLayoutManager(requireContext())
        binding.list.adapter = adapter
    }

    private fun onOperationClick(position:Int) {
        NavigationManager.goToDetailsFragment(parentFragmentManager,position)
    }
}