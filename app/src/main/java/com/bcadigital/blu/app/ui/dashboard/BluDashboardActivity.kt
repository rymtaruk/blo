package com.bcadigital.blu.app.ui.dashboard

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.bcadigital.blu.databinding.ActivityBluDashboardBinding

class BluDashboardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBluDashboardBinding
    private lateinit var bluDashboardAdapter: BluDashboardAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBluDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bluDashboardAdapter = BluDashboardAdapter(this)

        binding.vpContent.adapter = bluDashboardAdapter

        binding.vpContent.currentItem = 1
        binding.tvTracker.setTextColor(Color.WHITE)
        binding.tvHome.setTextColor(Color.BLACK)
        binding.tvSimpanan.setTextColor(Color.WHITE)
        binding.vpContent.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                when (position){
                    0-> {
                        binding.tabSelected.animate().x(0f).duration = 300
                        binding.tvTracker.setTextColor(Color.BLACK)
                        binding.tvHome.setTextColor(Color.WHITE)
                        binding.tvSimpanan.setTextColor(Color.WHITE)
                    }
                    1-> {
                        binding.tvTracker.setTextColor(Color.WHITE)
                        binding.tvHome.setTextColor(Color.BLACK)
                        binding.tvSimpanan.setTextColor(Color.WHITE)
                        binding.tabSelected.animate().x(binding.tabHome.width.toFloat()+16).duration = 300
                    }
                    2-> {
                        binding.tvTracker.setTextColor(Color.WHITE)
                        binding.tvHome.setTextColor(Color.WHITE)
                        binding.tvSimpanan.setTextColor(Color.BLACK)
                        binding.tabSelected.animate().x((binding.tabHome.width.toFloat() * 2)+33).duration = 300
                    }
                }
            }
        })
        selectMenu()
    }

    private fun selectMenu(){
        binding.tabTracker.setOnClickListener {
            binding.tabSelected.animate().x(0f).duration = 300
            binding.tvTracker.setTextColor(Color.BLACK)
            binding.tvHome.setTextColor(Color.WHITE)
            binding.tvSimpanan.setTextColor(Color.WHITE)
            binding.vpContent.currentItem = 0
        }

        binding.tabHome.setOnClickListener {
            binding.tvTracker.setTextColor(Color.WHITE)
            binding.tvHome.setTextColor(Color.BLACK)
            binding.tvSimpanan.setTextColor(Color.WHITE)
            binding.vpContent.currentItem = 1
            binding.tabSelected.animate().x(binding.tabHome.width.toFloat()+16).duration = 300
        }

        binding.tabSaving.setOnClickListener {
            binding.tvTracker.setTextColor(Color.WHITE)
            binding.tvHome.setTextColor(Color.WHITE)
            binding.tvSimpanan.setTextColor(Color.BLACK)
            binding.vpContent.currentItem = 2
            binding.tabSelected.animate().x((binding.tabHome.width.toFloat() * 2)+33).duration = 300
        }
    }
}