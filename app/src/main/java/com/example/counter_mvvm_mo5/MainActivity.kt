package com.example.counter_mvvm_mo5

import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.counter_mvvm_mo5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    private val mainActivityViewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        textView = binding.txt1

        binding.btnPlus.setOnClickListener {
            mainActivityViewModel.incrementCount()
        }

        binding.btnMinus.setOnClickListener {
            mainActivityViewModel.decrementCount()
        }

        binding.btnClear.setOnClickListener {
            mainActivityViewModel.defaultCount()
        }

        val countLiveData = mainActivityViewModel.getInitialCount()
        countLiveData.observe(this, Observer {
            textView.text = "Count is $it"
        })
    }
}
