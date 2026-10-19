package cl.inacap.app1_firebase

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity

class Acciones : AppCompatActivity() {

    private lateinit var tvusuacciones: TextView
    private lateinit var btnvolacc: Button

    private var usu: Usuario? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_acciones)

        tvusuacciones = findViewById(R.id.tvusuacciones)
        btnvolacc = findViewById(R.id.btnvolacc)

        usu = intent.getSerializableExtra("usu", Usuario::class.java)
        tvusuacciones.text = "${usu?.nombre} ${usu?.apellido}"

        volver()
        desactivarFlecha()
    } // Cierra el "onCreate".

    private fun volver() {
        btnvolacc.setOnClickListener {
            val intent = Intent(this@Acciones, Menu::class.java)
            intent.putExtra("usu", usu)
            startActivity(intent)
            finish()
        }
    }

    private fun desactivarFlecha() {
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                // Si dejas vacío, NO hace nada
            }
        })
    }
} // Cierra la clase "Acciones".
