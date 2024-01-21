package com.example.homework17

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.homework17.databinding.ActivityNoteInfoBinding

class NoteInfoActivity : AppCompatActivity() {

    private var binding: ActivityNoteInfoBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoteInfoBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setData()

        binding?.ibBack?.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setData(){
        val title = intent.getStringExtra("title")
        val content = intent.getStringExtra("content")

        binding?.tvTitle?.text = title
        binding?.tvContent?.text = content
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}