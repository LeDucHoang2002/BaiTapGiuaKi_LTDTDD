package com.malkinfo.loginpageui

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.text.InputType
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var editText: TextView? = null;
    var editText2:TextView? = null;
    var Tv_Sginup:TextView? = null
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editText = findViewById<View>(R.id.eMail) as TextView
        editText!!.inputType = InputType.TYPE_CLASS_NUMBER or InputType.TYPE_NUMBER_FLAG_SIGNED
        editText2 = findViewById<View>(R.id.passwords) as TextView
        singUp.setOnClickListener {
            singUp.background = resources.getDrawable(R.drawable.switch_trcks,null)
            singUp.setTextColor(resources.getColor(R.color.textColor,null))
            logIn.background = null
            singUpLayout.visibility = View.VISIBLE
            logInLayout.visibility = View.GONE
            logIn.setTextColor(resources.getColor(R.color.pinkColor,null))
        }
        logIn.setOnClickListener {
            singUp.background = null
            singUp.setTextColor(resources.getColor(R.color.pinkColor,null))
            logIn.background = resources.getDrawable(R.drawable.switch_trcks,null)
            singUpLayout.visibility = View.GONE
            logInLayout.visibility = View.VISIBLE
            logIn.setTextColor(resources.getColor(R.color.textColor,null))
        }
        singIn.setOnClickListener {
            val maSV = editText!!.text.toString()
            val pass = editText2!!.text.toString()
            if (pass == "" == true || maSV == "" == true) {
                Toast.makeText(this@MainActivity, "Nhập MaSV và Password", Toast.LENGTH_SHORT)
                    .show()
            } else {
                if (maSV == "2050531200150" == true) {
                    val intent = Intent(applicationContext, NewActivity::class.java)
                    intent.putExtra("MaSV", maSV)
                    startActivity(intent)
                } else {
                    Toast.makeText(this@MainActivity, "Tài Khoản Sai", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}