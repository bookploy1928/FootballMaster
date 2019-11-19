package buu.informatics.s59160378.footballmaster


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import buu.informatics.s59160378.footballmaster.databinding.FragmentAnswerBinding
import com.google.android.material.snackbar.Snackbar

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
        viewModelFactory = AnswerViewModelFactory(args.textFact, args.correction,args.questions,args.yourName,args.score)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(AnswerViewModel::class.java)


        val binding = DataBindingUtil.inflate<FragmentAnswerBinding>(inflater,
            R.layout.fragment_answer,container,false)


        binding.answerViewModel = viewModel

        binding.buttonNext.setOnClickListener { view : View ->
            val action = AnswerFragmentDirections.actionAnswerFragmentToGameFragment( viewModel.arrQuestion,viewModel.yourName,viewModel.score)
            NavHostFragment.findNavController(this).navigate(action)
        }

        viewModel.showSnackBarEvent.observe(this, Observer {
            if (it == true) { // Observed state is true.
                Snackbar.make(
                    activity!!.findViewById(android.R.id.content),"คุณได้คะแนน " +viewModel.score+" คะแนน",
                    Snackbar.LENGTH_SHORT // How long to display the message.
                ).show()
                viewModel.doneShowingSnackbar()
            }
        })
        return binding.root
    }


}


