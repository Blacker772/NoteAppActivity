package com.example.homework17

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.homework17.databinding.ActivityEditBinding

class CreateActivity : AppCompatActivity() {

    private var binding: ActivityEditBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.ibBack?.setOnClickListener {
            back()
        }
        binding?.ibSave?.setOnClickListener {
            if (binding?.etTitle?.text.isNullOrEmpty() || binding?.etContent?.text.isNullOrEmpty()){
                Toast.makeText(this, "Пожалуйста заполните заметку", Toast.LENGTH_SHORT).show()
            }else{
                save()
            }

        }
    }

    private fun back() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun save() {
        val intent = Intent()
        intent.putExtra("title", binding?.etTitle?.text.toString())
        intent.putExtra("content", binding?.etContent?.text.toString())
        setResult(RESULT_OK, intent)
        finish()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

}