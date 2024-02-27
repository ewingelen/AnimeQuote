package com.ewingelen.github.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ewingelen.github.presentation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel = (application as ProvideViewModel).viewModel()

        viewModel.quoteLiveData.observe(this) {
            binding.quoteTextView.text = it
        }

        viewModel.loadQuote()
    }
}
