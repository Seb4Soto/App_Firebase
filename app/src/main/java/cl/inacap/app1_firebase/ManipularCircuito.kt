package cl.inacap.app1_firebase

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity

class ManipularCircuito : AppCompatActivity() {

    private lateinit var tvusumanipular: TextView
    private lateinit var btnon: Button
    private lateinit var btnoff: Button
    private lateinit var btnvolman: Button

    private var usu: Usuario? = null
    private var activo = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manipular_circuito)

        tvusumanipular = findViewById(R.id.tvusumanipular)
        btnon = findViewById(R.id.btnon)
        btnoff = findViewById(R.id.btnoff)
        btnvolman = findViewById(R.id.btnvolman)

        usu = intent.getSerializableExtra("usu", Usuario::class.java)
        tvusumanipular.text = "${usu?.nombre} ${usu?.apellido}"

        botonOn()
        botonOff()
        volver()
        desactivarFlecha()
    } // Cierra el "onCreate".

    private fun botonOn() {
        btnon.setOnClickListener {
            activo = true
            mensaje("Circuito activado")
        }
    }

    private fun botonOff() {
        btnoff.setOnClickListener {
            activo = false
            mensaje("Circuito desactivado")
        }
    }

    private fun volver() {
        btnvolman.setOnClickListener {
            val intent = Intent(this@ManipularCircuito, Menu::class.java)
            intent.putExtra("usu", usu)
            startActivity(intent)
            finish()
        }
    }

    private fun mensaje(texto: String) {
        Toast.makeText(this@ManipularCircuito, texto, Toast.LENGTH_SHORT).show()
    }

    private fun desactivarFlecha() {
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                // Si dejas vacío, NO hace nada
            }
        })
    }
} // Cierra la clase "ManipularCircuito".