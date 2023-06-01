package com.bcadigital.blu.app.ui.dashboard

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.bcadigital.blu.app.ui.dashboard.home.BluHomeFragment

class BluDashboardAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun createFragment(position: Int): Fragment {
        val fragment: Fragment = when (position) {
            0 -> BluHomeFragment()
            1 -> BluHomeFragment()
            3 -> BluHomeFragment()
            else -> BluHomeFragment()
        }

        return fragment
    }

    override fun getItemCount(): Int {
        return 3
    }
}