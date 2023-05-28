package com.bcadigital.blu.app.ui.splashScreen

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.bcadigital.blu.databinding.ActivityBluSplashScreenBinding

@SuppressLint("CustomSplashScreen")
class BluSplashScreenActivity : AppCompatActivity() {
    private lateinit var binding:ActivityBluSplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)

        splashScreen.setOnExitAnimationListener{ splashScreenView ->
            splashScreenView.remove()
        }
        binding = ActivityBluSplashScreenBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}