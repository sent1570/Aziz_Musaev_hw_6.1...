package com.example.myapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.mbms.MbmsErrors.InitializationErrors
import android.widget.Toast
import com.example.myapplication.MainActivity.Companion.TEXT_1
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
        initClickers()
    }

    private fun initClickers() {
        with(binding){
            btnSecond.setOnClickListener{
                val data = etSecond.text
                if (data.isNullOrEmpty()){
                    Toast.makeText(this@SecondActivity,"Поле не может быть пустым", Toast.LENGTH_SHORT).show()
                }
                else{
                    val intent = Intent ()
                    intent.putExtra(TEXT_2,etSecond.text.toString())
                   setResult(Activity.RESULT_OK,intent)
                    finish()
                }

            }
        }

    }
    private fun initView(){
        val text = intent.getStringExtra(TEXT_1)
        binding.etSecond.setText(text)
    }
    companion object{
        const val TEXT_2 = "text_2"
    }

}