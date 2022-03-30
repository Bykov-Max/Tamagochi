package com.example.severalactivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.severalactivities.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val bt_toact2 = binding.buttonToact2
        bt_toact2.setOnClickListener {
//           Intent - намерение, механизм описания операции
            //создать намерение вызвать вторую активити
            val act2_start = Intent(this, activ2::class.java)
            val name = binding.editName.text.toString()
            val surname = binding.editSurname.text.toString()
            val age = binding.editAge.text
            //метод putExtra класса Intent позволяет отдавать данные в связке ключ+значение
            act2_start.putExtra("name", name)
            act2_start.putExtra("surname", surname)
            act2_start.putExtra("age", age)
            //запуск второго активити
            startActivity(act2_start)
        }
    }
}