package com.jakey.calc80085

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.ViewModelProvider
import com.jakey.calc80085.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        
        binding.textInput.text = viewModel.input.value

        binding.apply {

            button0.setOnClickListener {
                viewModel.input.value += 0
                textInput.text = viewModel.input.value
            }
            button1.setOnClickListener {
                viewModel.input.value += 1
                textInput.text = viewModel.input.value
            }
            button2.setOnClickListener {
                viewModel.input.value += 2
                textInput.text = viewModel.input.value
            }
            button3.setOnClickListener {
                viewModel.input.value += 3
                textInput.text = viewModel.input.value
            }
            button4.setOnClickListener {
                viewModel.input.value += 4
                textInput.text = viewModel.input.value
            }
            button5.setOnClickListener {
                viewModel.input.value += 5
                textInput.text = viewModel.input.value
            }
            button6.setOnClickListener {
                viewModel.input.value += 6
                textInput.text = viewModel.input.value
            }
            button7.setOnClickListener {
                viewModel.input.value += 7
                textInput.text = viewModel.input.value
            }
            button8.setOnClickListener {
                viewModel.input.value += 8
                textInput.text = viewModel.input.value
            }
            button9.setOnClickListener {
                viewModel.input.value += 9
                textInput.text = viewModel.input.value
            }
            buttonDeleteChar.setOnClickListener {
                viewModel.deleteInput()
            }
            buttonDeleteChar.setOnClickListener {
                //TODO
            }

        }
    }
}