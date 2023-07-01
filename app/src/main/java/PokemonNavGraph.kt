import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.nagem.pokemoncompose.PokemonNavigationActions

@Composable
fun PokemonNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    navActions: PokemonNavigationActions = remember(navController) {
        PokemonNavigationActions(navController)
    }
) {
}