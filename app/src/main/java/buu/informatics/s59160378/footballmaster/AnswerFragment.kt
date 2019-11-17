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
import buu.informatics.s59160378.footballmaster.databinding.FragmentAnswerBinding

/**
 * A simple [Fragment] subclass.
 */
class AnswerFragment : Fragment() {
    private lateinit var viewModelFactory: AnswerViewModelFactory
    private lateinit var viewModel: AnswerViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val args = AnswerFragmentArgs.fromBundle(arguments!!)
        viewModelFactory = AnswerViewModelFactory(args.textFact, args.correction)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(AnswerViewModel::class.java)


        val binding = DataBindingUtil.inflate<FragmentAnswerBinding>(inflater,
            R.layout.fragment_answer,container,false)


        binding.answerViewModel = viewModel

        binding.buttonNext.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_answerFragment_to_gameFragment)
        }
        return binding.root
    }


}
