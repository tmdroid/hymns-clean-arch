package de.dannyb.hymns.presentation.hymnslist.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import de.dannyb.hymns.presentation.hymnslist.view.HymnsListRoute


const val hymnsListNavigationRoute = "hymnsList"

fun NavController.navigateToHymnsList(navOptions: NavOptions? = null) {
    this.navigate(hymnsListNavigationRoute, navOptions)
}

fun NavGraphBuilder.hymnsListScreen(onHymnClicked: (Int) -> Unit) {
    composable(
        route = hymnsListNavigationRoute,
    ) {
        HymnsListRoute(onHymnClicked)
    }
}
