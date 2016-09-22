package com.kuwako.kotlinandroid

import android.content.Context
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        var text = "clicked";
        setSupportActionBar(toolbar)

        val fab = findViewById(R.id.fab) as FloatingActionButton
        fab.setOnClickListener(View.OnClickListener {
            view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show() })

        val tvHelloWorld = findViewById(R.id.textViewHello) as TextView
        val changeBtn = findViewById(R.id.changeBtn) as Button
        val etName = findViewById(R.id.editName) as EditText
        etName.setOnFocusChangeListener { view, hasFocus ->
            Log.i("@@@focus", hasFocus.toString())
            if (hasFocus == false) {
                Log.i("@@@focus", "false")
            }
        }
        changeBtn.setOnClickListener { view ->
            if (!etName.text.toString().equals("")) {
                text = etName.text.toString()
                etName.editableText.clear()
            }
            tvHelloWorld.text = text
            val imn :InputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imn.hideSoftInputFromWindow(view.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
        }
    }
}
