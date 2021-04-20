package com.agathaappb.motiva

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.agathaappb.motiva.infra.MotivaConstantes
import com.agathaappb.motiva.infra.SecurityPreferences
import com.agathaappb.motiva.repository.Mock
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , View.OnClickListener {

    private lateinit var mSecurityPreferences: SecurityPreferences
    private var fraseFiltro : Int = MotivaConstantes.FILTROFRASE.ALL

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }


        mSecurityPreferences = SecurityPreferences(this)
        val name = mSecurityPreferences.getString(MotivaConstantes.KEY.PERSON_NAME)
        textName.text = "Olá, $name!"
        btn_all.setColorFilter(resources.getColor(R.color.fonte1))



        btn_frase.setOnClickListener(this)
        btn_all.setOnClickListener(this)
        btn_smile.setOnClickListener(this)
        btn_sun.setOnClickListener(this)


    }

    override fun onClick(view: View) {
        val id = view.id

        val listFilter = listOf(R.id.btn_all, R.id.btn_smile, R.id.btn_sun)

        if (id == R.id.btn_frase) {
            handleNovaFrase()

        } else if (id in listFilter) {
            handleFiltro(id)
        }
    }

    private fun handleFiltro(id: Int) {

        btn_all.setColorFilter(resources.getColor((R.color.fundo4)))
        btn_smile.setColorFilter(resources.getColor(R.color.fundo4))
        btn_sun.setColorFilter(resources.getColor(R.color.fundo4))

        when (id) {
            R.id.btn_all -> {
                btn_all.setColorFilter(resources.getColor(R.color.fonte1))
                fraseFiltro = MotivaConstantes.FILTROFRASE.ALL
            }
            R.id.btn_smile -> {
                btn_smile.setColorFilter(resources.getColor(R.color.fonte1))
                fraseFiltro = MotivaConstantes.FILTROFRASE.SMILE
            }
            R.id.btn_sun -> {
                btn_sun.setColorFilter(resources.getColor(R.color.fonte1))
                fraseFiltro = MotivaConstantes.FILTROFRASE.SUN
            }

        }
    }
    private fun handleNovaFrase(){
        textFrases.text = Mock().getFrases(fraseFiltro)
    }
}



