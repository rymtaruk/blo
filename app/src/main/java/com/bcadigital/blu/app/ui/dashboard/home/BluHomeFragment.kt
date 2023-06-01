package com.bcadigital.blu.app.ui.dashboard.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bcadigital.blu.R
import com.bcadigital.blu.app.ui.dashboard.home.card.BluCardAdapter
import com.bcadigital.blu.databinding.FragmentBluHomeBinding
import com.google.android.material.tabs.TabLayoutMediator

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BluHomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BluHomeFragment : Fragment() {
    private var _binding: FragmentBluHomeBinding? = null
    private lateinit var cardAdapter: BluCardAdapter

    private val binding get() = _binding!!
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
    ): View {
        _binding = FragmentBluHomeBinding.inflate(inflater, container, false)
        cardAdapter = BluCardAdapter(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvWelcome.text = requireContext().getString(R.string.home_good_day_s, "Rio")

        binding.vpCard.adapter = cardAdapter

        TabLayoutMediator(binding.tabCard, binding.vpCard){ _, _ ->

        }.attach()

        binding.tabCard.getTabAt(0)?.setText("Saldo")
        binding.tabCard.getTabAt(1)?.setText("Kartu")
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BluHomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}