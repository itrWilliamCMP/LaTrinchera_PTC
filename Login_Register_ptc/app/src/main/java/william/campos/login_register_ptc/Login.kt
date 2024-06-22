package william.campos.login_register_ptc

import Modelo.ClaseConexion
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //Explicacion del profesor:
        //1- Mandamos a traer a todos los elementos de la vista
        val txtCorreoElectronico = findViewById<EditText>(R.id.txtCorreoElectronico)
        val txtContrasena = findViewById<EditText>(R.id.txtContrasena)
        val btnEntrar = findViewById<Button>(R.id.btnEntrar)
        val btnRegistrarse = findViewById<Button>(R.id.btnRegistrarse)

        //2- Se programa los botones
        btnEntrar.setOnClickListener {
            val correo = txtCorreoElectronico.text.toString()
            val contrasena = txtContrasena.text.toString()

            // Validación básica
            if (correo.isBlank() || contrasena.isBlank()) {
                Toast.makeText(this, "Por favor, llena todos los campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener // Sale del listener si los campos están vacíos
            }

            // Tu código original, ahora dentro de la validación
            val pantallaPrincipal = Intent(this, MainActivity::class.java)
            lifecycleScope.launch(Dispatchers.IO) { // Usamos lifecycleScope en lugar de GlobalScope
                val objConexion = ClaseConexion().cadenaConexion()
                val verificarUsuario = objConexion?.prepareStatement("SELECT * FROM USUARIOS3PTC WHERE correoElectronico = ? AND contrasena = ?")!!
                verificarUsuario.setString(1, correo)
                verificarUsuario.setString(2, contrasena)
                val resultado = verificarUsuario.executeQuery()

                withContext(Dispatchers.Main) { // Cambiamos al hilo principal para actualizar la UI
                    if (resultado.next()) {
                        startActivity(pantallaPrincipal)
                    } else {
                        Toast.makeText(this@Login, "Usuario no encontrado", Toast.LENGTH_SHORT).show() // Mostramos un Toast en lugar de println
                    }
                }
            }
        }



        btnRegistrarse.setOnClickListener {
            //Cambio de pantalla
            val pantallaRegistrarse = Intent(this, Register::class.java)
            startActivity(pantallaRegistrarse)
        }

    }
}