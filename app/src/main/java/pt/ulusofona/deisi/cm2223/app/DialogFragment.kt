package pt.ulusofona.deisi.cm2223.app

import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import pt.ulusofona.deisi.cm2223.app.databinding.FragmentDialogBinding

class DialogFragment :androidx.fragment.app.DialogFragment() {
    private lateinit var binding: FragmentDialogBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val countdownTimer = object : CountDownTimer(10000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val remainingTime = millisUntilFinished / 1000
                binding.dialogText.text = "$remainingTime"
            }

            override fun onFinish() {
                dismiss()
            }
        }
        val view = inflater.inflate(
            R.layout.fragment_dialog, container, false
        )
        countdownTimer.start()
        binding = FragmentDialogBinding.bind(view)
        return binding.root
    }
}