package buu.informatics.s59160378.footballmaster


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import buu.informatics.s59160378.footballmaster.databinding.FragmentGameBinding

/**
 * A simple [Fragment] subclass.
 */
class GameFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentGameBinding>(inflater,
            R.layout.fragment_game,container,false)
        binding.buttonAns1.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_gameFragment_to_answerFragment)
        }
        binding.buttonAns2.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_gameFragment_to_answerFragment)
        }
        binding.buttonAns3.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_gameFragment_to_answerFragment)
        }
        binding.buttonAns4.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_gameFragment_to_answerFragment)
        }
        return binding.root
    }


}
