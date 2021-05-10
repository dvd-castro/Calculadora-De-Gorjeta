package br.com.davidcastro.gorjeta

import android.os.Bundle
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.google.android.material.textfield.TextInputEditText
import kotlin.math.roundToInt
import kotlin.math.roundToLong

class MainActivity : AppCompatActivity() {
    private lateinit var myEditText : TextInputEditText
    private lateinit var percentValueSeekBarText : TextView
    private lateinit var seekBar : SeekBar
    private lateinit var gorjeta : TextView
    private lateinit var total : TextView
    private var percent : Int = 0
    private var gorjetaValur : Double = 0.0
    private var result : Double = 0.0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fun calcular(){
            if (!myEditText.text.toString().isBlank()){
                result = myEditText.text.toString().toDouble()
                result *= percent.toDouble()/100
                total.text= "Total: R$ ${result}"
            }
        }

        myEditText  = this.findViewById(R.id.inputText)
        percentValueSeekBarText = this.findViewById(R.id.seekbarProgress)
        seekBar = this.findViewById(R.id.seekBar)
        gorjeta = this.findViewById(R.id.gorjeta)
        total = this.findViewById(R.id.total)

        myEditText.addTextChangedListener {
            if (myEditText.text.toString().isBlank()){
                total.text= "Total: R$ 0"
            }else{
                calcular()
                total.text= "Total: R$ ${result}"
            }
        }

        //Adicionar listener SeekBar
        seekBar.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                percent = progress
                percentValueSeekBarText.setText(percent.toString() + " %")
                calcular()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })


    }

}

