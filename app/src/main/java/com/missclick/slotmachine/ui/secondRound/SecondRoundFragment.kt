package com.missclick.slotmachine.ui.secondRound

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.missclick.slotmachine.R
import com.missclick.slotmachine.databinding.FragmentSecondRoundBinding
import com.missclick.slotmachine.ui.thirdRound.ThirdRoundFragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SecondRoundFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SecondRoundFragment : Fragment() {
    val bind by viewBinding(FragmentSecondRoundBinding::bind)
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
        return inflater.inflate(R.layout.fragment_second_round, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (param1!! == "") param1 = "0"
        val last = param1!!.toInt() % 101
        val random = (1..100).random()
        val delta = if (last > random) last - random else random - last
        val score = (100 - delta) * 2
        bind.appCompatTextView2.text = bind.appCompatTextView2.text.toString() + score.toString() + " очков"
        bind.text3.text = bind.text3.text.toString() + random.toString()
        bind.materialButton2.setOnClickListener {
            (context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).
            hideSoftInputFromWindow(view.windowToken, 0)
            findNavController().navigate(R.id.action_secondRoundFragment_to_thirdRoundFragment,ThirdRoundFragment.newInstance(score.toString(),"statka"))
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SecondRoundFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                 Bundle().apply{
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }

    }
}