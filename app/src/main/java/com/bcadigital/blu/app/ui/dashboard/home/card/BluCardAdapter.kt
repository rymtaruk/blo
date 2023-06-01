package com.bcadigital.blu.app.ui.dashboard.home.card

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class BluCardAdapter constructor(fragment: Fragment) :
    FragmentStateAdapter(fragment) {

    override fun createFragment(position: Int): Fragment {
        val fragment: Fragment = when (position) {
            0 -> BluAmountFragment()
            1 -> BluAmountFragment()
            else -> BluAmountFragment()
        }

        return fragment
    }

    override fun getItemCount(): Int {
        return 2
    }
}