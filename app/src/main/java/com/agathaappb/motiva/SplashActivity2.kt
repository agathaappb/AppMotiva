package com.agathaappb.motiva

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.agathaappb.motiva.infra.MotivaConstantes
import com.agathaappb.motiva.infra.SecurityPreferences
import kotlinx.android.synthetic.main.activity_splash2.*

class SplashActivity2 : AppCompatActivity(), View.OnClickListener {

    private lateinit var mSecurityPreferences : SecurityPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash2)

        mSecurityPreferences = SecurityPreferences(this)

        if(supportActionBar != null ){
            supportActionBar!!.hide()
        }

        btn_save.setOnClickListener(this)

        verificaNome()



    }

    private fun verificaNome(){
        val name = mSecurityPreferences.getString(MotivaConstantes.KEY.PERSON_NAME)

        if(name != ""){
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onClick(view: View) {
        val id  = view.id
        if (id == R.id.btn_save){
            handleSave()
        }
    }

    private fun handleSave(){
        val name = edit_Name.text.toString()

        if(name != ""){
            mSecurityPreferences.storeString(MotivaConstantes.KEY.PERSON_NAME, name)
            val intent = Intent(this, MainActivity :: class.java)
            startActivity(intent)

        }else{
            Toast.makeText(this, "Informe seu nome!", Toast.LENGTH_SHORT).show()
        }
    }
}