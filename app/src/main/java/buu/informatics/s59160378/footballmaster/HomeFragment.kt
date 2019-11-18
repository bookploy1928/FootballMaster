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
import buu.informatics.s59160378.footballmaster.databinding.FragmentHomeBinding
import timber.log.Timber

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {
    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val binding = DataBindingUtil.inflate<FragmentHomeBinding>(inflater,
            R.layout.fragment_home,container,false)

        binding.playButton.setOnClickListener { view : View ->

            viewModel.setName(binding.editText.text.toString())
            val action = HomeFragmentDirections.actionHomeFragmentToGameFragment(viewModel.questions,viewModel.yourName,viewModel.score)
            NavHostFragment.findNavController(this).navigate(action)
        }

        binding.buttonScoreboard.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_homeFragment_to_scoreboardFragment)
        }
        Timber.i("onCreate called")
        return binding.root
    }


}
