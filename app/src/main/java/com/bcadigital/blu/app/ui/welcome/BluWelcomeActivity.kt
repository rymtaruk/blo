package com.bcadigital.blu.app.ui.welcome

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bcadigital.blu.databinding.ActivityBluWelcomeBinding

class BluWelcomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityBluWelcomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBluWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}