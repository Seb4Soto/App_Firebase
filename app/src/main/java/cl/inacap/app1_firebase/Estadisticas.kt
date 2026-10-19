package cl.inacap.app1_firebase

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity

class Estadisticas : AppCompatActivity() {

    private lateinit var tvusuestadisticas: TextView
    private lateinit var tvact: TextView
    private lateinit var tvdes: TextView
    private lateinit var tvobs: TextView
    private lateinit var tvdisttotal: TextView
    private lateinit var btnvolest: Button

    private var usu: Usuario? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_estadisticas)

        tvusuestadisticas = findViewById(R.id.tvusuestadisticas)
        tvact = findViewById(R.id.tvact)
        tvdes = findViewById(R.id.tvdes)
        tvobs = findViewById(R.id.tvobs)
        tvdisttotal = findViewById(R.id.tvdisttotal)
        btnvolest = findViewById(R.id.btnvolest)

        usu = intent.getSerializableExtra("usu", Usuario::class.java)
        tvusuestadisticas.text = "${usu?.nombre} ${usu?.apellido}"

        // Valores de ejemplo (más adelante vendrán desde la base de datos)
        tvact.text = "9"
        tvdes.text = "8"
        tvobs.text = "17"
        tvdisttotal.text = "46 cm"

        volver()
        desactivarFlecha()
    } // Cierra el "onCreate".

    private fun volver() {
        btnvolest.setOnClickListener {
            val intent = Intent(this@Estadisticas, Menu::class.java)
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
} // Cierra la clase "Estadisticas".
