package de.dannyb.hymns.presentation.hymndetails.navigation

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import de.dannyb.hymns.presentation.hymndetails.view.HymnDetailsRoute


@VisibleForTesting
internal const val topicIdArg = "topicId"
const val hymnDetailsNavigationRoute = "hymns/{$topicIdArg}"

internal class TopicArgs(savedStateHandle: SavedStateHandle) {
    val hymnNumber: Int = checkNotNull(savedStateHandle[topicIdArg])
}

fun NavController.navigateToHymnDetails(hymnNumber: Int) {
    navigate("hymns/$hymnNumber") {
        launchSingleTop = true
    }
}

fun NavGraphBuilder.hymnDetailsScreen(onBackClicked: () -> Unit) {
    composable(
        route = hymnDetailsNavigationRoute,
        arguments = listOf(
            navArgument(topicIdArg) { type = NavType.IntType },
        ),
    ) {
        HymnDetailsRoute(onBackClicked)
    }
}