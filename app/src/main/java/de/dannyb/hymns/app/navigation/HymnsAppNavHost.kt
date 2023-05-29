package de.dannyb.hymns.app.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import de.dannyb.hymns.presentation.hymnslist.navigation.hymnsListNavigationRoute
import de.dannyb.hymns.presentation.hymnslist.navigation.hymnsListScreen


@Composable
fun NiaNavHost(
//    appState: NiaAppState,
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = hymnsListNavigationRoute,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        // TODO: handle topic clicks from each top level destination
        hymnsListScreen(onHymnClicked = {

        })

//        bookmarksScreen(onTopicClick = {})
//        searchScreen(
//            onBackClick = navController::popBackStack,
//            onInterestsClick = { appState.navigateToTopLevelDestination(INTERESTS) },
//            onTopicClick = navController::navigateToTopic,
//        )
//        interestsGraph(
//            onTopicClick = { topicId ->
//                navController.navigateToTopic(topicId)
//            },
//            nestedGraphs = {
//                topicScreen(
//                    onBackClick = navController::popBackStack,
//                    onTopicClick = {},
//                )
//            },
//        )
    }
}