package com.bcadigital.blu.app.ui.passcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import com.bcadigital.blu.app.utils.PasscodeWatcher
import com.bcadigital.blu.databinding.ActivityBluPasscodeBinding

class BluPasscodeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBluPasscodeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBluPasscodeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.etOne.addTextChangedListener(PasscodeWatcher(binding.etOne, binding.etTwo, null))
        binding.etTwo.addTextChangedListener(PasscodeWatcher(binding.etTwo, binding.etThree, null))
        binding.etThree.addTextChangedListener(
            PasscodeWatcher(
                binding.etThree,
                binding.etFour,
                null
            )
        )
        binding.etFour.addTextChangedListener(PasscodeWatcher(binding.etFour, binding.etFive, null))
        binding.etFive.addTextChangedListener(PasscodeWatcher(binding.etFive, binding.etSix, null))
        binding.etSix.addTextChangedListener(
            PasscodeWatcher(
                binding.etSix,
                null,
                object : PasscodeWatcher.PasscodeCallback {
                    override fun onFinish() {
                        binding.pbLoading.visibility = View.VISIBLE
                        binding.llPin.visibility = View.INVISIBLE
                        val handler = Handler(Looper.getMainLooper())
                        handler.postDelayed({
                            binding.pbLoading.visibility = View.INVISIBLE
                            binding.llPin.visibility = View.VISIBLE

                            binding.etOne.text = null
                            binding.etTwo.text = null
                            binding.etThree.text = null
                            binding.etFour.text = null
                            binding.etFive.text = null
                            binding.etSix.text = null
                            binding.etOne.requestFocus()
                        }, 300)
                    }
                })
        )

        keyboardListener()
    }

    private fun keyboardListener() {
        val buttons = listOf(
            binding.btnOne,
            binding.btnTwo,
            binding.btnThree,
            binding.btnFour,
            binding.btnFive,
            binding.btnSix,
            binding.btnSeven,
            binding.btnEight,
            binding.btnNine,
            binding.btnZero
        )

        for (button in buttons) {
            button.setOnClickListener {
                passcodeListener(button.text.toString())
            }
        }

        binding.btnDelete.setOnClickListener {
            deleteListener()
        }
    }

    private fun passcodeListener(number: String) {
        val editTexts = listOf(
            binding.etOne,
            binding.etTwo,
            binding.etThree,
            binding.etFour,
            binding.etFive,
            binding.etSix
        )

        val index = editTexts.indexOfFirst { it.text.isEmpty() }
        if (index != -1) editTexts[index].setText(number)
    }

    private fun deleteListener() {
        val editTexts = listOf(
            binding.etSix,
            binding.etFive,
            binding.etFour,
            binding.etThree,
            binding.etTwo,
            binding.etOne
        )

        val index = editTexts.indexOfFirst { it.text.isNotEmpty() }
        if (index != -1) {
            val editText = editTexts[index]
            editText.text = null
            editText.requestFocus()
        }
    }
}