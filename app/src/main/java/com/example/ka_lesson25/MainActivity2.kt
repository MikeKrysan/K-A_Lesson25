package com.example.ka_lesson25

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
    }

    fun onClick(view:View) {
        val i = Intent()
        i.putExtra("key1", "done")
        setResult(RESULT_OK, i)     //перед закрытием activity вызваем setResult() и туда передаем новый Intent, который несет в себе информацию на первое activity
        finish()    //и все, закрываем наш второй activity
    }
}