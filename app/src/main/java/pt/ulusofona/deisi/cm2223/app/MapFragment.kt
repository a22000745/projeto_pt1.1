package pt.ulusofona.deisi.cm2223.app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import pt.ulusofona.deisi.cm2223.app.databinding.FragmentListBinding
import pt.ulusofona.deisi.cm2223.app.databinding.FragmentMapBinding

class MapFragment : Fragment() {
    private lateinit var binding: FragmentMapBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(
            R.layout.fragment_map, container, false
        )
        binding = FragmentMapBinding.bind(view)
        binding.voiceButton.setOnClickListener {
            val dialogFragment = DialogFragment()
            dialogFragment.show(parentFragmentManager, "dialog")
        }
        return binding.root
    }
}