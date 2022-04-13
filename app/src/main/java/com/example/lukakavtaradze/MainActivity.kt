package com.example.lukakavtaradze

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.*

class MainActivity : AppCompatActivity() {

    private lateinit var firstName: EditText
    private lateinit var lastName: EditText
    private lateinit var email: EditText
    private lateinit var review: EditText
    private lateinit var send: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firstName = findViewById(R.id.firstName)
        lastName = findViewById(R.id.lastName)
        email = findViewById(R.id.email)
        review = findViewById(R.id.review)
        send = findViewById(R.id.send)

        send.setOnClickListener{
            if(validateEmail(email) && validateName() && validateReview()){
                Toast.makeText(applicationContext, "Successfully sent", Toast.LENGTH_SHORT).show()
            }

        }
    }
    private fun validateEmail(editText: EditText):Boolean{
        if (!editText.text.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(editText.text).matches()){
            return true
        }else{
            return false
        }
    }
    private fun validateName():Boolean{
        if (firstName.text.length >2 && lastName.text.length >4){
            return true
        }else{
            return false
        }
    }
    private fun validateReview():Boolean{
        if (review.text.length >10){
            return true
        }else{
            return false
        }
    }
}