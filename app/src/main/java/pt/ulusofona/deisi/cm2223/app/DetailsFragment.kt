package pt.ulusofona.deisi.cm2223.app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import pt.ulusofona.deisi.cm2223.app.databinding.FragmentDetailsBinding

class DetailsFragment(private val arrayPosition: Int) : Fragment() {
    private lateinit var binding: FragmentDetailsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(
            R.layout.fragment_details, container, false
        )
        binding = FragmentDetailsBinding.bind(view)
        binding.dEdit.setOnClickListener {
            NavigationManager.goToFormFragment(parentFragmentManager, arrayPosition)
        }
        binding.dErase.setOnClickListener {
            Movies.removeMovie(arrayPosition)
            NavigationManager.goToListFragment(parentFragmentManager)
        }
        binding.voiceButton.setOnClickListener {
            val dialogFragment = DialogFragment()
            dialogFragment.show(parentFragmentManager, "dialog")
        }
        binding.dFilme.text = Movies.movieList[arrayPosition].nome
        binding.dCinema.text = Movies.movieList[arrayPosition].cinema
        binding.dAvaliacao.text = Movies.movieList[arrayPosition].avaliacao.toString()
        binding.dData.text = Movies.movieList[arrayPosition].getData()
        binding.dObservacoes.text = Movies.movieList[arrayPosition].observacoes

        return binding.root
    }
}