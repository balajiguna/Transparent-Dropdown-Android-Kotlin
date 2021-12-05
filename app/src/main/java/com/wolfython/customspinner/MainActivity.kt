package com.wolfython.customspinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //To hide a Action Bar
        supportActionBar?.hide()

        val data = arrayOf("KTM", "Suzuki", "Yamaha", "BMW", "Ducati", "TVS")

        val adapter = ArrayAdapter(this, R.layout.spinner_textview, data)
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_color)

        val spinner = findViewById<Spinner>(R.id.custom_spinner)
        spinner.adapter = adapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                Toast.makeText(this@MainActivity, parent.getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }
    }
}