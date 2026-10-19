package cl.inacap.app1_firebase

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity

class Principal : AppCompatActivity() {

    private lateinit var txtrut: EditText
    private lateinit var txtcon: EditText
    private lateinit var btnini: Button
    private lateinit var btncrear: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)

        txtrut = findViewById(R.id.txtrut)
        txtcon = findViewById(R.id.txtcon)
        btnini = findViewById(R.id.btnini)
        btncrear = findViewById(R.id.btncrear)

        botonLogin()
        botonCrear()
        desactivarFlecha()
    } // Cierra el "onCreate".

    private fun botonLogin() {
        btnini.setOnClickListener {

            val rut = txtrut.text.toString().trim()
            val con = txtcon.text.toString().trim()

            if (rut.isEmpty() || con.isEmpty()) {

                Toast.makeText(
                    this@Principal,
                    "¡ Complete Los Campos Faltantes !",
                    Toast.LENGTH_LONG
                ).show()

            } else {
                // Versión de interfaz: cualquier usuario y contraseña ingresan al menú.
                val usu = Usuario(
                    rut = Utils.claveRut(rut),
                    nombre = "Usuario",
                    apellido = "Demo",
                    correo = "usuario@correo.cl",
                    cargo = "Operador",
                    contrasena = con
                )

                ocultarTeclado()
                val intent = Intent(this@Principal, Menu::class.java)
                intent.putExtra("usu", usu)
                startActivity(intent)
            } // Cierra if/else.
        } // Cierra el evento onClick.
    } // Cierra la función "botonLogin".

    private fun botonCrear() {
        btncrear.setOnClickListener {
            startActivity(Intent(this@Principal, CrearCuenta::class.java))
        }
    }

    private fun ocultarTeclado() {
        val view = currentFocus
        if (view != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    private fun desactivarFlecha() {
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                // Si dejas vacío, NO hace nada
            }
        })
    }
} // Cierra la clase "Principal".
