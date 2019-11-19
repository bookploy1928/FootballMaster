package buu.informatics.s59160378.footballmaster


import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import buu.informatics.s59160378.footballmaster.databinding.FragmentHomeBinding
import timber.log.Timber
import android.view.*
import androidx.lifecycle.Observer

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
            val action = HomeFragmentDirections.actionHomeFragmentToGameFragment(viewModel.questions,viewModel.yourName.value!!,viewModel.score)
            NavHostFragment.findNavController(this).navigate(action)
        }

        binding.buttonScoreboard.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_homeFragment_to_scoreboardFragment)
        }

        binding.editText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                binding.playButton.isEnabled = binding.editText.text.toString() != ""
            }
        })

        binding.homeViewModel = viewModel
        binding.lifecycleOwner = this

        Timber.i("onCreate called")
        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.option_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!,
            view!!.findNavController()) || super.onOptionsItemSelected(item)
    }


}
