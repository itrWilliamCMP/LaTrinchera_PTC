package Modelo

import java.lang.Exception
import java.sql.Connection
import java.sql.DriverManager

class ClaseConexion {
    fun cadenaConexion(): Connection?{
        try {
<<<<<<< HEAD:Dany_La_Trinche/app/src/main/java/Modelo/ClaseConexion.kt
            val url="jdbc:oracle:thin:@192.168.0.23:1521:xe"
            val user="DBRIZZ"
=======
            val url="jdbc:oracle:thin:@192.168.1.24:1521:xe"
            val user="WILLIAM_DEVELOPER"
>>>>>>> master:Login_Register_ptc/app/src/main/java/Modelo/ClaseConexion.kt
            val password="123456"


            val connection= DriverManager.getConnection(url, user, password)

            return connection
        }catch (e: Exception){
            println("este es el error:$e")
            return null
        }
    }
}