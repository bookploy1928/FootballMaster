package buu.informatics.s59160378.footballmaster


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import buu.informatics.s59160378.footballmaster.databinding.FragmentGameBinding
import timber.log.Timber

/**
 * A simple [Fragment] subclass.
 */
class GameFragment : Fragment() {

    private lateinit var viewModel: GameViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel = ViewModelProviders.of(this).get(GameViewModel::class.java)
        val binding = DataBindingUtil.inflate<FragmentGameBinding>(inflater,
            R.layout.fragment_game,container,false)

        binding.gameViewModel = viewModel

        binding.buttonAns1.setOnClickListener { view : View ->
            val action = GameFragmentDirections.actionGameFragmentToAnswerFragment(viewModel.answerCheck(0))
            NavHostFragment.findNavController(this).navigate(action)
        }

        binding.buttonAns2.setOnClickListener { view : View ->
            val action = GameFragmentDirections.actionGameFragmentToAnswerFragment(viewModel.answerCheck(0))
            NavHostFragment.findNavController(this).navigate(action)
        }
        binding.buttonAns3.setOnClickListener { view : View ->
            val action = GameFragmentDirections.actionGameFragmentToAnswerFragment(viewModel.answerCheck(0))
            NavHostFragment.findNavController(this).navigate(action)
        }
        binding.buttonAns4.setOnClickListener { view : View ->
            val action = GameFragmentDirections.actionGameFragmentToAnswerFragment(viewModel.answerCheck(0))
            NavHostFragment.findNavController(this).navigate(action)
        }
        Timber.i("onCreate called")
        return binding.root
    }

}
