package com.example.tipcalculatorapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tipcalculatorapp.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculateButton.setOnClickListener { calculateTip() }



    }
    private fun calculateTip(){
        val stringCost = binding.costOfService.text.toString()
        val cost = stringCost.toDoubleOrNull()
        if(cost==null){
            binding.tipResult.text=""
            return
        }
        val tipPercentage = when(binding.tipOptions.checkedRadioButtonId){
            R.id.option_20 -> 0.20
            R.id.option_18 -> 0.18
            else -> 0.15
        }
        var tip =  cost * tipPercentage
        if(binding.roundUpSwitch.isChecked) tip= kotlin.math.ceil(tip)
        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        binding.tipResult.text = getString(R.string.tip_amount,formattedTip)



    }
}