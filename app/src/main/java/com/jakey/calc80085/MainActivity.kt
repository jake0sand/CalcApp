package com.jakey.calc80085

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.jakey.calc80085.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: CalculatorViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(CalculatorViewModel::class.java)

        viewModel.currentInputManager.inputLiveData.observe(this) {
            binding.textInput.text = it // number formatter
        }

        viewModel.currentInputManager.canPressDecimalLiveData.observe(this) {
            binding.buttonDecimal.isClickable = it
        }

        //All the button bindings to the LiveData's
        binding.apply {
            button0.setOnClickListener {
                viewModel.currentInputManager.inputReceived("0")
            }
            button1.setOnClickListener {
                viewModel.currentInputManager.inputReceived("1")
            }
            button2.setOnClickListener {
                viewModel.currentInputManager.inputReceived("2")
            }
            button3.setOnClickListener {
                viewModel.currentInputManager.inputReceived("3")
            }
            button4.setOnClickListener {
                viewModel.currentInputManager.inputReceived("4")
            }
            button5.setOnClickListener {
                viewModel.currentInputManager.inputReceived("5")
            }
            button6.setOnClickListener {
                viewModel.currentInputManager.inputReceived("6")
            }
            button7.setOnClickListener {
                viewModel.currentInputManager.inputReceived("7")
            }
            button8.setOnClickListener {
                viewModel.currentInputManager.inputReceived("8")
            }
            button9.setOnClickListener {
                viewModel.currentInputManager.inputReceived("9")
            }
            buttonDecimal.setOnClickListener {
                viewModel.currentInputManager.inputReceived(".")
            }
            buttonAdd.setOnClickListener {
                viewModel.saveOperator("+")
            }
            buttonSubtract.setOnClickListener {
                viewModel.saveOperator("-")
            }
            buttonMultiply.setOnClickListener {
                viewModel.saveOperator("*")
            }

            buttonDivide.setOnClickListener {
                viewModel.saveOperator("/")
            }
            buttonDeleteChar.setOnClickListener {
                viewModel.currentInputManager.backspace()
            }
            buttonClearAll.setOnClickListener {
                viewModel.clearAll()
            }
            buttonEqulas.setOnClickListener {
                viewModel.calculate()
            }
        }
    }
}