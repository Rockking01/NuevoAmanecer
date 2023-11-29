import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.nuevoamanecer.Pantallas.InsertImage
import com.example.nuevoamanecer.Pantallas.Login
import com.example.nuevoamanecer.Pantallas.LoginAdmin
import com.example.nuevoamanecer.Pantallas.LoginUser
import com.example.nuevoamanecer.Pantallas.userPage
import com.example.nuevoamanecer.Pantallas.adminPage
import com.example.nuevoamanecer.Pantallas.animalesPictoPage
import com.example.nuevoamanecer.Pantallas.computadoraPictoPage
import com.example.nuevoamanecer.Pantallas.juegosPage
import com.example.nuevoamanecer.Pantallas.oficinaPictoPage
import com.example.nuevoamanecer.Pantallas.tableroPage
import com.example.nuevoamanecer.Pantallas.transportePictoPage


@Composable
fun Navigation (){

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "Login"){
        composable("Login"){
            Login(navController)
        }
        composable("LoginUser"){
            LoginUser(navController)
        }
        composable("LoginAdmin"){
            LoginAdmin(navController)
        }

        composable("adminPage"){
            adminPage(navController)
        }
        composable("userPage"){
            userPage(navController)
        }
        composable("Tablero"){
            tableroPage(navController)
        }
        composable("Juegos"){
            juegosPage(navController)
        }
        composable("Animales"){
            animalesPictoPage(navController)
        }
        composable("Transporte"){
            transportePictoPage(navController)
        }
        composable("Computadora"){
            computadoraPictoPage(navController)
        }
        composable("InsertImage"){
            InsertImage(navController)
        }
        composable("Oficina"){
            oficinaPictoPage(navController)
        }
    }
}