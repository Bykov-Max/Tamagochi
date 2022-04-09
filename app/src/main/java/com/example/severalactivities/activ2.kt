package com.example.severalactivities

import android.content.Intent
import android.graphics.drawable.DrawableContainer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.severalactivities.databinding.ActivityActiv2Binding
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ListView
import androidx.cardview.widget.CardView


class activ2 : AppCompatActivity() {
    private lateinit var binding: ActivityActiv2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityActiv2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val arguments = intent.extras
        var name: String = "default"
        var surname: String = "def"
        var age: Int = 20
        if(arguments!=null) {
            name = arguments.get("name").toString()
            surname = arguments.get("surname").toString()
            age = arguments.get("age").toString().toInt()
        }
        binding.textView2.text = binding.textView2.text.toString()+", "+name+" "+surname+", "+age

        val btn_toact1 = binding.buttonToact1
        btn_toact1.setOnClickListener{
            val act1_start = Intent(this, MainActivity::class.java)
            startActivity(act1_start)
        }

        val human: ImageView = binding.human
        val humanAnimation: Animation = AnimationUtils.loadAnimation(this, R.anim.move_avatar)

        human.startAnimation(humanAnimation)
        human.animate().rotation(360F)
        human.animate().duration = 5000

        binding.textView2.startAnimation(humanAnimation)
        binding.textView2.animate().rotation(360F)
        binding.textView2.animate().duration = 5000

        var flag = false

        val addAge = binding.addAge
        addAge.setOnClickListener{
            age=age+1
            binding.textView2.text = "Hello, "+name+" "+surname+", "+(age).toString()
            flag = true
        }

        val reset = binding.resetAge
        reset.setOnClickListener{
            if(flag and (arguments!=null)){
                age= arguments?.get("age").toString().toInt()
                binding.textView2.text = "Hello, "+name+" "+surname+", "+age
            }
            flag = false
        }
    }
}
