package com.example.homework17

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.example.homework17.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null
    private val adapter = NoteAdapter()
    private var colorPosition: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        binding?.rvRecyclerView?.adapter = adapter
        adapter.updateList(list)
        adapter.setNote(object : Clicking{
            override fun clickNote(note: NoteModel) {
                noteInfo(note)
            }

        })
        val result = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
            if (result.resultCode == RESULT_OK){

                val title = result.data?.getStringExtra("title")
                val content = result.data?.getStringExtra("content")

                if (colorPosition > (listOfColors.size - 1)){
                    colorPosition  = 0
                    val positionColor = listOfColors[colorPosition]
                    colorPosition++
                    list.add(NoteModel(title.toString(), content.toString(), positionColor))
                    adapter.updateList(list)
                }else {
                    val positionColor = listOfColors[colorPosition]
                    colorPosition++
                    list.add(NoteModel(title.toString(), content.toString(), positionColor))
                    adapter.updateList(list)
                }

            }
        }

        binding?.btAdd?.setOnClickListener {
            val intent = Intent(this, CreateActivity::class.java)
            result.launch(intent)
        }
    }

    private fun noteInfo(note: NoteModel){
        val intent = Intent(this, NoteInfoActivity::class.java)
        intent.putExtra("title", note.title)
        intent.putExtra("content", note.content)
        startActivity(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}

private val list = mutableListOf<NoteModel>()

private val listOfColors = mutableListOf<Int>(
    R.color.blue,
    R.color.green,
    R.color.red,
    R.color.gray,
    R.color.yellow,
    R.color.purple,
    R.color.pink,
    R.color.orange,
    R.color.blue,
    R.color.green,
    R.color.red,
    R.color.gray,
    R.color.yellow,
    R.color.purple,
    R.color.pink,
    R.color.orange,
    R.color.blue,
    R.color.green,
    R.color.red,
    R.color.gray,
    R.color.yellow,
    R.color.purple,
    R.color.pink,
    R.color.orange,
)