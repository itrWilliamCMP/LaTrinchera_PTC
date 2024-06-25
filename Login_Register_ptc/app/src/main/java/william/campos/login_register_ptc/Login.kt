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
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.btnEntrar)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val txtCorreoElectronico = findViewById<EditText>(R.id.txtCorreoElectronico)
        val txtContrasena = findViewById<EditText>(R.id.txtContrasena)
        val btnEntrar = findViewById<Button>(R.id.btnEntrar)
        val btnRegistrarse = findViewById<Button>(R.id.btnRegistrarse)

        btnEntrar.setOnClickListener {
            val correo = txtCorreoElectronico.text.toString()
            val contrasena = txtContrasena.text.toString()

            // Se ha eliminado la validación de campos vacíos

            val pantallaPrincipal = Intent(this, MainActivity::class.java)
            lifecycleScope.launch(Dispatchers.IO) {
                val objConexion = ClaseConexion().cadenaConexion()
                val verificarUsuario = objConexion?.prepareStatement("SELECT * FROM USUARIOS3PTC WHERE correoElectronico = ? AND contrasena = ?")!!
                verificarUsuario.setString(1, correo)
                verificarUsuario.setString(2, contrasena)
                val resultado = verificarUsuario.executeQuery()

                withContext(Dispatchers.Main) {
                    if (resultado.next()) {
                        startActivity(pantallaPrincipal)
                    } else {
                        Toast.makeText(this@Login, "Usuario no encontrado", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

        btnRegistrarse.setOnClickListener{
            val pantallaRegistrarse = Intent(this, Register::class.java)
            startActivity(pantallaRegistrarse)
        }
    }
}