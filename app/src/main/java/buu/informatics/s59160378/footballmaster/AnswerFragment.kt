package buu.informatics.s59160378.footballmaster


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import buu.informatics.s59160378.footballmaster.databinding.FragmentAnswerBinding

/**
 * A simple [Fragment] subclass.
 */
class AnswerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentAnswerBinding>(inflater,
            R.layout.fragment_answer,container,false)
        return binding.root
    }


}
