package buu.informatics.s59160378.footballmaster


import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import buu.informatics.s59160378.footballmaster.Database.UserDatabase
import buu.informatics.s59160378.footballmaster.databinding.FragmentScoreBinding
import com.google.android.material.snackbar.Snackbar
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
        binding.buttonShare.setOnClickListener { view : View ->
            shareSuccess()
        }
        binding.scoreViewModel = viewModel
        Timber.i("onCreate called")
        Toast.makeText(activity, "เกมจบแล้ว", Toast.LENGTH_SHORT).show()
        return binding.root
    }

    private fun getShareIntent() : Intent {
        val args = ScoreFragmentArgs.fromBundle(arguments!!)
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain")
            .putExtra(Intent.EXTRA_TEXT,args.yourName+ " ได้คะแนน "+args.score +" คะแนน จากเกม Football Master")
        return shareIntent
    }

    private fun shareSuccess() {
        startActivity(getShareIntent())
    }




}

