package de.dannyb.hymns.presentation.hymnslist.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import de.dannyb.hymns.presentation.hymnslist.model.HymnPresentationModel
import de.dannyb.hymns.presentation.hymnslist.model.HymnsListViewState
import de.dannyb.hymns.presentation.hymnslist.viewmodel.HymnsListViewModel

@Composable
internal fun HymnsListRoute(
    onHymnClicked: (Int) -> Unit,
    viewModel: HymnsListViewModel = hiltViewModel(),
) {

    val uiState by viewModel.viewState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.onEntered()
    }

    when (uiState) {
        is HymnsListViewState.Loading -> {}
        is HymnsListViewState.Success -> {
            val success = uiState as HymnsListViewState.Success
            HymnsListScreen(hymns = success.hymns, onHymnClicked = onHymnClicked)
        }
    }
}

@Composable
private fun HymnsListScreen(
    hymns: List<HymnPresentationModel>,
    onHymnClicked: (Int) -> Unit,
) {
    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        items(hymns) {
            ImnElement(it, onHymnClicked)
        }
    }
}

@Composable
private fun ImnElement(
    item: HymnPresentationModel,
    onHymnClicked: (Int) -> Unit,
) {
    val content = "${item.number}. ${item.title}"

    Divider(
        modifier = Modifier
            .fillMaxWidth()
            .height(1.dp),
        color = Color.LightGray
    )

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .clickable { onHymnClicked.invoke(item.number) },
        shape = RectangleShape
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Text(modifier = Modifier.padding(start = 48.dp), text = content)
        }
    }
}
