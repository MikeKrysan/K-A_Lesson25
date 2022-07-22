package com.example.ka_lesson25

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {

    private var launcher: ActivityResultLauncher<Intent>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //создаем калбек. Это что-то вроде слушателя. Он запускается тогда, когда приходит ответ от activity, который мы с помощью него запустили.
        //Как с помощью калбека можно запустить какое-нибудь activity? - когда мы создаем калбек, то ссылку на него мы записываем в переменную, это и будет наш ланчер

        //как только наш второй activity закрывается, открывается наш callback:
        launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {    //мы не знаем, что за тип данных мы получим, котлин сам определит тип данных, поэтому мы можем не указывать его
            result: ActivityResult ->
            if(result.resultCode == RESULT_OK) {    // и здесь мы как и раньше, принимаем наш Intent, только теперь мы не проверяем его на reqest code, потому как знаем, что наш колбак(ActivityResultLauncher in Java) запустил то activity, на колбак прийдет только результат из activity, с которого мы запустили. То-есть это всегда конретный ответ на конкретный запрос
                val text = result.data?.getStringExtra("key1")
                Log.d("MyLog", "Result from MainActivity2 $text")
            }
        }

    }

    fun onClick(view:View) {
        launcher?.launch(Intent(this, MainActivity2::class.java))   //создаем Intent, указываем контекст (this) и после activity, который мы хотим запустить
    }

}