package pt.ulusofona.deisi.cm2223.app

import android.content.Context
import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import pt.ulusofona.deisi.cm2223.app.databinding.FragmentAddNotBinding

class AddNotFragment :androidx.fragment.app.DialogFragment()  {
    private lateinit var binding: FragmentAddNotBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(
            R.layout.fragment_add_not, container, false
        )
        binding = FragmentAddNotBinding.bind(view)
        val data = view?.findViewById<EditText>(R.id.n_data)
        val filme = view?.findViewById<EditText>(R.id.n_nome)
        binding.nSubmit.setOnClickListener {
            val resultado = Notifications.checkForm(filme?.text.toString(),data?.text.toString(), this)
            this.context?.let { it -> showToast(it, resultado) }
            if(resultado == getString(R.string.form_sucesso)){
                Notifications.addNotification(filme?.text.toString(),data?.text.toString())
                dismiss()
            }
        }
        return binding.root
    }
    fun showToast(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }
}