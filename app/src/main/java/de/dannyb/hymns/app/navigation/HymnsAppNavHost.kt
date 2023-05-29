package de.dannyb.hymns.app.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import de.dannyb.hymns.presentation.hymndetails.navigation.hymnDetailsScreen
import de.dannyb.hymns.presentation.hymndetails.navigation.navigateToHymnDetails
import de.dannyb.hymns.presentation.hymnslist.navigation.hymnsListNavigationRoute
import de.dannyb.hymns.presentation.hymnslist.navigation.hymnsListScreen


@Composable
fun HymnsAppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = hymnsListNavigationRoute,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        hymnsListScreen(
            onHymnClicked = { navController.navigateToHymnDetails(it) }
        )

        hymnDetailsScreen(
            onBackClicked = { navController.popBackStack() }
        )
    }
}