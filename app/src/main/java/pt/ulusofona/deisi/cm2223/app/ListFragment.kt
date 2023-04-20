package pt.ulusofona.deisi.cm2223.app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        return binding.root
    }
    override fun onStart() {
        super.onStart()
        binding.list.layoutManager = LinearLayoutManager(requireContext())
        binding.list.adapter = adapter

    }

    override fun onResume() {
        super.onResume()
        val list = Movies.movieList
        adapter.updateItems(list)
    }

    private fun onOperationClick(position:Int) {
        val transaction = childFragmentManager.beginTransaction()
        transaction.replace(R.id.list, DetailsFragment(position))
        transaction.addToBackStack(null)
        transaction.commit()
    }

}