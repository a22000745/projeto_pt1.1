package pt.ulusofona.deisi.cm2223.app

import android.content.Context
import android.os.Bundle
import android.text.SpannableStringBuilder
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import pt.ulusofona.deisi.cm2223.app.databinding.FragmentFormBinding

class FormFragment(arrayPosition : Int = -1) : Fragment() {
    private val position = arrayPosition
    private lateinit var binding: FragmentFormBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(
            R.layout.fragment_form, container, false
        )
        binding = FragmentFormBinding.bind(view)
        if(position !=-1){//no caso de estar a editar um filme
            binding.fNome.text = SpannableStringBuilder(Movies.movieList[position].nome)
            binding.fCinema.text = SpannableStringBuilder(Movies.movieList[position].cinema)
            binding.fAvaliacao.text = SpannableStringBuilder(Movies.movieList[position].avaliacao.toString())
            binding.fData.text = SpannableStringBuilder(Movies.movieList[position].getData())
            binding.fObservacoes.text = SpannableStringBuilder(Movies.movieList[position].observacoes)
        }
        val nome = view?.findViewById<EditText>(R.id.f_nome)
        val cinema = view?.findViewById<EditText>(R.id.f_cinema)
        val avaliacao = view?.findViewById<EditText>(R.id.f_avaliacao)
        val data = view?.findViewById<EditText>(R.id.f_data)
        val observacoes = view?.findViewById<EditText>(R.id.f_observacoes)
        var result = false
        binding.voiceButton.setOnClickListener {
            val dialogFragment = DialogFragment()
            dialogFragment.show(parentFragmentManager, "dialog")
        }
        binding.fSubmit.setOnClickListener {
            val resultado = Movies.checkForm(this, nome?.text.toString(), cinema?.text.toString(), avaliacao?.text.toString(), data?.text.toString(),observacoes?.text.toString())
            if (resultado == getString(R.string.form_sucesso)) {
                if(position != -1){
                    Movies.removeMovie(position)
                }
                result = Movies.addMovieForm(nome?.text.toString(), cinema?.text.toString(), avaliacao?.text.toString(), data?.text.toString(), observacoes?.text.toString())
            }
            this.context?.let { it -> showToast(it, resultado) }
        }
        return binding.root
    }
    fun showToast(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }
}