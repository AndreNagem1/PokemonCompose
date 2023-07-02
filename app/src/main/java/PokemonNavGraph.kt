import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nagem.pokemoncompose.PokemonDestinations
import com.nagem.pokemoncompose.PokemonListScreen
import com.nagem.pokemoncompose.PokemonNavigationActions
import com.nagem.pokemoncompose.PokemonSearchScreen
import com.nagem.pokemoncompose.search.PokemonSearchViewModel
import org.koin.compose.koinInject

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
            val viewModel = koinInject<PokemonSearchViewModel>()
            val state = viewModel.uiState.collectAsStateWithLifecycle()

            PokemonSearchScreen(
                uiState = state.value,
                searchPokemon = viewModel::searchPokemon
            )
        }
    }
}