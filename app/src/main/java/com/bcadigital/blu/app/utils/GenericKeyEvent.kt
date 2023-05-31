package com.bcadigital.blu.app.utils

import android.view.KeyEvent
import android.view.View
import android.widget.EditText
import com.bcadigital.blu.R

class GenericKeyEvent constructor(private val currentView: EditText, private val previousView: EditText?) : View.OnKeyListener {
    override fun onKey(v: View?, keyCode: Int, event: KeyEvent?): Boolean {
        if(event!!.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_DEL && currentView.id != R.id.etOne && currentView.text.isEmpty()) {
            //If current is empty then previous EditText's number will also be deleted
            previousView?.text = null
            previousView?.requestFocus()
            return true
        }
        return false
    }
}