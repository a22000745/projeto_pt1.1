package pt.ulusofona.deisi.cm2223.app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import pt.ulusofona.deisi.cm2223.app.databinding.FragmentDetailsBinding
import pt.ulusofona.deisi.cm2223.app.databinding.FragmentFormBinding

class DetailsFragment(val arrayPosition: Int) : Fragment() {
    private lateinit var binding: FragmentDetailsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(
            R.layout.fragment_details , container, false
        )
        binding = FragmentDetailsBinding.bind(view)
        binding.dEdit.setOnClickListener {
            View.OnClickListener(){
                val transaction = childFragmentManager.beginTransaction()
                transaction.replace(R.id.details, FormFragment())
                transaction.addToBackStack(null)
                transaction.commit()
            }
        }
        binding.dErase.setOnClickListener{
            Movies.removeMovie(arrayPosition)
        }
        binding.dFilme.text = Movies.movieList[arrayPosition].nome
        binding.dCinema.text = Movies.movieList[arrayPosition].cinema
        binding.dAvaliacao.text = Movies.movieList[arrayPosition].avaliacao.toString()
        binding.dData.text = Movies.movieList[arrayPosition].getData()
        binding.dObservacoes.text = Movies.movieList[arrayPosition].observacoes

        return binding.root
    }
}