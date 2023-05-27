package com.osmanavsar.recipe

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.osmanavsar.recipe.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Initialize Firebase Auth
        auth = Firebase.auth

        val currentUser = auth.currentUser

        if(currentUser != null){
            val intent = Intent(this, FeedActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
    fun signInClicked(view: View){

        val email = binding.emailText.text.toString()
        val password = binding.passwordText.text.toString()

        if(email.equals("") || password.equals("")) {
            Toast.makeText(this,"Enter valid email and password!", Toast.LENGTH_LONG).show()
        }else{
            auth.signInWithEmailAndPassword(email, password).addOnSuccessListener {
                val intent = Intent(this@MainActivity,FeedActivity::class.java)
                startActivity(intent)
                finish()
            }.addOnFailureListener {
                Toast.makeText(this@MainActivity,it.localizedMessage, Toast.LENGTH_LONG).show()
            }
        }
    }

    fun signUpClicked(view: View){

        val email = binding.emailText.text.toString()
        val password = binding.passwordText.text.toString()

        if(email.equals("") || password.equals("")) {
            Toast.makeText(this,"Enter valid email and password!", Toast.LENGTH_LONG).show()
        }else{
            auth.createUserWithEmailAndPassword(email, password).addOnSuccessListener {
                val intent = Intent(this@MainActivity,FeedActivity::class.java)
                startActivity(intent)
                finish()
            }.addOnFailureListener {
                Toast.makeText(this@MainActivity,it.localizedMessage, Toast.LENGTH_LONG).show()
            }
        }
    }
}