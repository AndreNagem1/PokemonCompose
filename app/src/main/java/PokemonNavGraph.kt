import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nagem.pokemoncompose.PokemonDestinations
import com.nagem.pokemoncompose.PokemonListScreen
import com.nagem.pokemoncompose.PokemonNavigationActions
import com.nagem.pokemoncompose.PokemonSearchScreen

@Composable
fun PokemonNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = PokemonDestinations.POKEMON_LIST_ROUTE,
    navActions: PokemonNavigationActions = remember(navController) {
        PokemonNavigationActions(navController)
    }
) {

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        composable(
            PokemonDestinations.POKEMON_LIST_ROUTE,
        ) {
            PokemonListScreen { navActions.navigateToSearch() }
        }

        composable(
            PokemonDestinations.POKEMON_SEARCH_ROUTE,
        ) {
            PokemonSearchScreen()
        }
    }
}