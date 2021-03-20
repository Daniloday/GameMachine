package com.missclick.GameMachine.ui.lastRound

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.missclick.GameMachine.R
import com.missclick.GameMachine.databinding.FragmentLastRoundBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LastRoundFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LastRoundFragment : Fragment() {
    val bind by viewBinding(FragmentLastRoundBinding::bind)
    val viewModel : LastRoundViewModel by viewModel()
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_last_round, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (param1!! == "") param1 = "0"
        if (param2!! == "") param2 = "0"
        val last = param1!!.toInt() % 101
        val random = (1..100).random()
        val delta = if (last > random) last - random else random - last
        val score2 = (100 - delta) * 2
        val score1 = param2!!.toInt()
        val score = score1 + score2
        bind.score.text = score.toString()
        bind.materialButton.setOnClickListener {
            (context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).
            hideSoftInputFromWindow(view.windowToken, 0)
            findNavController().navigate(R.id.action_lastRoundFragment_to_splashFragment)
        }
        bind.textView5.setOnClickListener {
            viewModel.saveStatka(score)
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment LastRoundFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }

    }
}