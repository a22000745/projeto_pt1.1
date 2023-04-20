package pt.ulusofona.deisi.cm2223.app

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import pt.ulusofona.deisi.cm2223.app.databinding.FragmentFormBinding

class FormFragment : Fragment() {
    private lateinit var binding: FragmentFormBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(
            R.layout.fragment_form, container, false
        )
        binding = FragmentFormBinding.bind(view)
        val nome = view?.findViewById<EditText>(R.id.f_nome)
        val cinema = view?.findViewById<EditText>(R.id.f_cinema)
        val avaliacao = view?.findViewById<EditText>(R.id.f_avaliacao)
        val data = view?.findViewById<EditText>(R.id.f_data)
        val observacoes = view?.findViewById<EditText>(R.id.f_observacoes)
        var result = false
        binding.fSubmit.setOnClickListener {
            val resultado = Movies.checkForm(this, nome?.text.toString(), cinema?.text.toString(), avaliacao?.text.toString(), data?.text.toString())
            if (resultado == getString(R.string.form_sucesso)) {
                result = Movies.addMovieForm(nome?.text.toString(), cinema?.text.toString(), avaliacao?.text.toString(), data?.text.toString(), observacoes?.text.toString())
                val size = Movies.movieList.size
            }
            this.context?.let { it -> showToast(it, resultado) }
        }
        return binding.root
    }
    fun showToast(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }
}