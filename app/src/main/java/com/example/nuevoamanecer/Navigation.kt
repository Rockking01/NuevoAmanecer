import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.nuevoamanecer.Pantallas.BalloonGameScreen
import com.example.nuevoamanecer.Pantallas.CupcakeScreen
import com.example.nuevoamanecer.Pantallas.DragGameScreen
import com.example.nuevoamanecer.Pantallas.InsertImage
import com.example.nuevoamanecer.Pantallas.Login
import com.example.nuevoamanecer.Pantallas.LoginAdmin
import com.example.nuevoamanecer.Pantallas.LoginUser
import com.example.nuevoamanecer.Pantallas.userPage
import com.example.nuevoamanecer.Pantallas.AdminPage
import com.example.nuevoamanecer.Pantallas.animalesPictoPage
import com.example.nuevoamanecer.Pantallas.computadoraPictoPage
import com.example.nuevoamanecer.Pantallas.juegosPage
import com.example.nuevoamanecer.Pantallas.oficinaPictoPage
import com.example.nuevoamanecer.Pantallas.tableroPage
import com.example.nuevoamanecer.Pantallas.transportePictoPage
import com.example.nuevoamanecer.viewModels.AlumnosViewModel

@Composable
fun Navigation() {

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

        composable("adminPage"+ "/{name}"){
            AdminPage(name = it.arguments?.getString("name"), navController)
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
        composable("Balloon"){
            BalloonGameScreen(navController)
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
        composable("Draw"){
            DrawScreen(navController)
        }
        composable("Drag"){
            DragGameScreen(navController)
        }
        composable("Cupcake"){
            CupcakeScreen(navController)
        }
    }
}