package william.campos.login_register_ptc

import Modelo.ClaseConexion
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.UUID

class Register: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.btnEntrar)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //Explicacion del profesor:
        //1- Mando a llamar a todos los elementos de la vista
        val imgAtras = findViewById<ImageView>(R.id.imgAtras)
        val txtRegistrarCorreo = findViewById<EditText>(R.id.txtRegistrarCorreo)
        val txtRegistrarContrasena = findViewById<EditText>(R.id.txtRegistrarContrasena)
        val txtConfirmacionContrasena = findViewById<EditText>(R.id.txtConfimacionContrasena)
        val btnRegistrar = findViewById<Button>(R.id.btnRegistrar)
        val btnRegresar = findViewById<Button>(R.id.btnRegresar)

        //2- Programar los botones
        //Al darle clic al boton se hace un insert a la base con los valores que escribe el usuario
        btnRegistrar.setOnClickListener {
            // Obtiene los valores ingresados por el usuario.
            val correo = txtRegistrarCorreo.text.toString()
            val contrasena = txtRegistrarContrasena.text.toString()
            val confirmacionContrasena = txtConfirmacionContrasena.text.toString()

            // Valida que ningún campo esté vacío.
            if (correo.isEmpty() || contrasena.isEmpty() || confirmacionContrasena.isEmpty()) {
                Toast.makeText(this, "Campo Vacio", Toast.LENGTH_SHORT).show()
                return@setOnClickListener // Sale del listener si hay algún campo vacío.
            }
            // Valida que el correo electrónico tenga un formato válido.
            if (!correo.matches(".*@.*".toRegex())) {
                Toast.makeText(this, "Ingrese correo valido", Toast.LENGTH_SHORT).show()
                return@setOnClickListener // Sale del listener si el correo no es válido.
            }
            // Valida que la contraseña tenga unalongitud entre 6 y 24 caracteres.
            if (contrasena.length < 6 || contrasena.length > 24) {
                Toast.makeText(this, "Ingrese una clave entre 6 y 24 caracteres", Toast.LENGTH_SHORT).show()
                return@setOnClickListener // Sale del listener si la contraseña no cumple con la longitud requerida.
            }
            // Valida que la contraseña y su confirmación coincidan.
            if (contrasena != confirmacionContrasena) {
                Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
                return@setOnClickListener // Sale del listener si las contraseñas no coinciden.
            }


            // Si todas las validaciones pasan, procede con el registro
            GlobalScope.launch(Dispatchers.IO) {
                //Creo un objeto de la clase conexion
                val objConexion = ClaseConexion().cadenaConexion()

                //Creo una variable que contenga un PrepareStatement
                val CreacionDelUsuario =
                    objConexion?.prepareStatement("INSERT INTO USUARIOS3PTC (UUID_usuario, correoElectronico, contrasena) VALUES (?, ?, ?)")!!
                CreacionDelUsuario.setString(1, UUID.randomUUID().toString())
                CreacionDelUsuario.setString(2, txtRegistrarCorreo.text.toString())
                CreacionDelUsuario.setString(3, txtRegistrarContrasena.text.toString())
                CreacionDelUsuario.executeUpdate()
                withContext(Dispatchers.Main) {
                    //Se Abre otra corrutina para mostrar un mensaje y limpiar los campos


                    //Se hace en el Hilo Main por que el hilo IO no permite mostrar nada en pantalla
                    Toast.makeText(this@Register, "Usuario creado", Toast.LENGTH_SHORT).show()
                    txtRegistrarCorreo.setText("")
                    txtRegistrarContrasena.setText("")
                    txtConfirmacionContrasena.setText("")
                }
            }
        }
        //Al darle clic a la flechta de arriba - Regresar al Login
        imgAtras.setOnClickListener {
            val pantallaLogin = Intent(this, Login::class.java)
            startActivity(pantallaLogin)
        }
        //Al darle clic a al boton que ya tengo una cuenta - Regresar al Login
        btnRegresar.setOnClickListener {
            val pantallaLogin = Intent(this, Login::class.java)
            startActivity(pantallaLogin)
        }
    }
}