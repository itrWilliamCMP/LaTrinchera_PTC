package Modelo

import java.lang.Exception
import java.sql.Connection
import java.sql.DriverManager

class ClaseConexion {
    fun cadenaConexion(): Connection?{
        try {
            val url="jdbc:oracle:thin:@192.168.0.23:1521:xe"
            val user="DBRIZZ"
            val password="123456"

            val connection= DriverManager.getConnection(url, user, password)

            return connection
        }catch (e: Exception){
            println("este es el error:$e")
            return null
        }
    }
}