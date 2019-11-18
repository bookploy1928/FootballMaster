package buu.informatics.s59160378.footballmaster

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment
import buu.informatics.s59160378.footballmaster.Database.UserDatabase
import buu.informatics.s59160378.footballmaster.databinding.ScoreboardFragmentBinding
import timber.log.Timber


class ScoreboardFragment : Fragment() {
    private lateinit var viewModelFactory: ScoreboardViewModelFactory
    private lateinit var viewModel: ScoreboardViewModel
    companion object {
        fun newInstance() = ScoreboardFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val application = requireNotNull(this.activity).application
        val dataSource = UserDatabase.getInstance(application).scoreDatabaseDao
        viewModelFactory = ScoreboardViewModelFactory(dataSource,application)
        viewModel = ViewModelProviders.of(this,viewModelFactory).get(ScoreboardViewModel::class.java)
        val binding = DataBindingUtil.inflate<ScoreboardFragmentBinding>(inflater,
            R.layout.scoreboard_fragment,container,false)

        var adapter = ScoreboardAdapter()

        binding.listScore.adapter = adapter


        viewModel.scoreList?.observe(this, Observer {
//            Timber.i(list.size.toString())
            adapter.submitList(it)
        })

        Timber.i("onCreate called")
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ScoreboardViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
