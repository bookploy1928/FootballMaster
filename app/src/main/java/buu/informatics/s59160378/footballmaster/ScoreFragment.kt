package buu.informatics.s59160378.footballmaster


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import buu.informatics.s59160378.footballmaster.Database.UserDatabase
import buu.informatics.s59160378.footballmaster.databinding.FragmentScoreBinding
import timber.log.Timber

/**
 * A simple [Fragment] subclass.
 */
class ScoreFragment : Fragment() {
    private lateinit var viewModelFactory: ScoreViewModelFactory
    private lateinit var viewModel: ScoreViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val args = ScoreFragmentArgs.fromBundle(arguments!!)
        val application = requireNotNull(this.activity).application
        val dataSource = UserDatabase.getInstance(application).scoreDatabaseDao
        viewModelFactory = ScoreViewModelFactory(args.yourName,args.score,dataSource,application)
        viewModel = ViewModelProviders.of(this,viewModelFactory).get(ScoreViewModel::class.java)
        val binding = DataBindingUtil.inflate<FragmentScoreBinding>(inflater,
            R.layout.fragment_score,container,false)

        binding.buttonBackToHome.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_scoreFragment_to_homeFragment)
        }
        binding.scoreViewModel = viewModel
        Timber.i("onCreate called")
        return binding.root
    }


}

