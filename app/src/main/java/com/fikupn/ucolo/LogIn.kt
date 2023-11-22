package com.fikupn.ucolo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.fikupn.ucolo.databinding.ActivityLogInBinding

class LogIn : AppCompatActivity(), View.OnClickListener {

    private lateinit var bindingLogIn: ActivityLogInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingLogIn = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(bindingLogIn.root)

        // CHANGE COLOR BUTTON
        val button = findViewById<Button>(R.id.btn_login)
        bindingLogIn.run {
            button.isSelected = !button.isSelected
            btnLogin.setOnClickListener(this@LogIn)
        }
    }

    override fun onClick(v: View) {
        val username = bindingLogIn.editTxtUsername.text.toString().isNotEmpty()
        val password = bindingLogIn.editTxtPassword.text.toString().isNotEmpty()
        when(v.id)
        {
            R.id.btn_login ->
            {
                val statusName = bindingLogIn.editTxtUsername.text.toString().isEmpty();
                val statusPass = bindingLogIn.editTxtPassword.text.toString().isEmpty();
                // Tinggal validasi jumlah NIM dan password yang bener

                if(statusName && statusPass) {
                    Toast.makeText(this, "Sorry the form has not been filled", Toast.LENGTH_LONG).show()
                } else if(statusName){
                    Toast.makeText(this, "Sorry NIM Can't Be Empty", Toast.LENGTH_LONG).show()
                } else if(statusPass){
                    Toast.makeText(this, "Sorry Password Can't Be Empty", Toast.LENGTH_LONG).show()
                } else{
                    val intentSignIn = Intent(this@LogIn, MainActivity :: class.java)
                    startActivity(intentSignIn)
                }
            }
        }
    }
}