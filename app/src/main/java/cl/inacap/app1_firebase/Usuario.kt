package cl.inacap.app1_firebase

import java.io.Serializable

/**
 * data class: clase pensada para almacenar y transportar datos.
 * Serializable: permite enviar el objeto entre Activities (putExtra / getSerializableExtra).
 */
data class Usuario(
    val rut: String = "",
    val nombre: String = "",
    val apellido: String = "",
    val correo: String = "",
    val cargo: String = "",
    val contrasena: String = ""
) : Serializable
