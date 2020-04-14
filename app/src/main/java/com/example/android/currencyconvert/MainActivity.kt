package com.example.android.currencyconvert

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.view.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getSupportActionBar()?.setDisplayShowHomeEnabled(true)
        getSupportActionBar()?.setLogo(R.mipmap.ic_launcher)
        getSupportActionBar()?.setDisplayUseLogoEnabled(true)

        val convertNum = findViewById<EditText>(R.id.idConvertNumber)
        val rbBolivarsToDollars = findViewById<RadioButton>(R.id.idRBBolivarsToDollars)
        val rbDollarsToBolivars = findViewById<RadioButton>(R.id.idRBDollarsToBolivars)
        val txtResult = findViewById<TextView>(R.id.idResult)
        val convertIt = findViewById<Button>(R.id.idBtnConvert)

        convertIt.setOnClickListener{
            var dblMeasure = convertNum.text.toString().toDouble()
            val conversionRate = 77798
            var convertMeasureNum:Double

            if (rbBolivarsToDollars.isChecked)
            {
                if(dblMeasure <= 72)
                {
                    convertMeasureNum = dblMeasure / conversionRate
                    txtResult.text = "$ $convertMeasureNum"
                }
                else{
                    Toast.makeText(this@MainActivity, "Value must be less than 72", Toast.LENGTH_LONG).show()
                }
            }
            if (rbDollarsToBolivars.isChecked)
            {
                if(dblMeasure <= 72)
                {
                    convertMeasureNum = dblMeasure * conversionRate
                    txtResult.text = "$convertMeasureNum Bolivars"
                }
                else{
                    Toast.makeText(this@MainActivity, "Value must be less than 72", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}
