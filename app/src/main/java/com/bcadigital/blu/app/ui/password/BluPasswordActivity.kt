package com.bcadigital.blu.app.ui.password

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bcadigital.blu.databinding.ActivityBluPasswordBinding

class BluPasswordActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBluPasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBluPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}