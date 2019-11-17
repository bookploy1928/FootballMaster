package buu.informatics.s59160378.footballmaster


import android.os.Bundle
import android.text.format.DateUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import buu.informatics.s59160378.footballmaster.databinding.FragmentGameBinding
import timber.log.Timber

/**
 * A simple [Fragment] subclass.
 */
class GameFragment : Fragment() {
    private lateinit var viewModelFactory: GameViewModelFactory
    private lateinit var viewModel: GameViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val args = GameFragmentArgs.fromBundle(arguments!!)

//        if (args.questions.isEmpty()) {
//            Timber.i("Yes")
//            NavHostFragment.findNavController(this).navigate(R.id.action_gameFragment_to_scoreFragment)
//        }

        viewModelFactory = GameViewModelFactory(args.questions,args.yourName)
        viewModel = ViewModelProviders.of(this,viewModelFactory).get(GameViewModel::class.java)
        val binding = DataBindingUtil.inflate<FragmentGameBinding>(inflater,
            R.layout.fragment_game,container,false)

        binding.gameViewModel = viewModel

        binding.buttonAns1.setOnClickListener { view : View ->
            val action = GameFragmentDirections.actionGameFragmentToAnswerFragment(viewModel.getCurrentQuestionFact(), viewModel.answerCheck(0), viewModel.questionsArr,viewModel.yourName)
            NavHostFragment.findNavController(this).navigate(action)
        }

        binding.buttonAns2.setOnClickListener { view : View ->
            val action = GameFragmentDirections.actionGameFragmentToAnswerFragment(viewModel.getCurrentQuestionFact(), viewModel.answerCheck(1), viewModel.questionsArr,viewModel.yourName)
            NavHostFragment.findNavController(this).navigate(action)
        }
        binding.buttonAns3.setOnClickListener { view : View ->
            val action = GameFragmentDirections.actionGameFragmentToAnswerFragment(viewModel.getCurrentQuestionFact(), viewModel.answerCheck(2), viewModel.questionsArr,viewModel.yourName)
            NavHostFragment.findNavController(this).navigate(action)
        }
        binding.buttonAns4.setOnClickListener { view : View ->
            val action = GameFragmentDirections.actionGameFragmentToAnswerFragment(viewModel.getCurrentQuestionFact(), viewModel.answerCheck(3), viewModel.questionsArr,viewModel.yourName)
            NavHostFragment.findNavController(this).navigate(action)
        }

        viewModel.onGameFinish.observe(this, Observer { onGameFinish ->
           if (onGameFinish){
               val action = GameFragmentDirections.actionGameFragmentToAnswerFragment(viewModel.getCurrentQuestionFact(), viewModel.answerCheck(-1), viewModel.questionsArr,viewModel.yourName)
               NavHostFragment.findNavController(this).navigate(action)
               viewModel.onFinishNavigate()
           }
        })

        viewModel.onQuestionEmpty.observe(this, Observer { onQuestionEmpty ->
            if (onQuestionEmpty){
                NavHostFragment.findNavController(this).navigate(R.id.action_gameFragment_to_scoreFragment)
                viewModel.onFinishNavigate()
            }
        })

        binding.lifecycleOwner = this

        Timber.i("onCreate called")
        return binding.root
    }

}
