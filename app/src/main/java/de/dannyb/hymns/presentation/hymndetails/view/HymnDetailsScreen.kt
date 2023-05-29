package de.dannyb.hymns.presentation.hymndetails.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import de.dannyb.hymns.presentation.hymndetails.model.HymnDetailsPresentationModel
import de.dannyb.hymns.presentation.hymndetails.model.HymnDetailsViewState
import de.dannyb.hymns.presentation.hymndetails.view.preview.HymnDetailsPreviewParameterProvider


@Composable
internal fun HymnDetailsRoute(
    onBackClicked: () -> Unit,
    viewModel: HymnDetailsViewModel = hiltViewModel()
) {
    val uiState by viewModel.viewState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.onEntered()
    }

    when (uiState) {
        is HymnDetailsViewState.Loading -> {}
        is HymnDetailsViewState.Success -> {
            val success = uiState as HymnDetailsViewState.Success
            HymnDetailsScreen(hymn = success.hymn, onBackClicked = onBackClicked)
        }
    }
}

@Composable
fun HymnDetailsScreen(hymn: HymnDetailsPresentationModel, onBackClicked: () -> Unit) {
    Surface(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxSize()

    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {

            val centerModifier by remember { mutableStateOf(Modifier.fillMaxWidth()) }

            // Category
            Text(
                modifier = centerModifier,
                text = hymn.category,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Medium,
                fontStyle = FontStyle.Italic,
            )

            // Number. Title
            Text(
                modifier = centerModifier
                    .padding(top = 24.dp),
                text = "${hymn.number}. ${hymn.title}",
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )

            // Key
            Text(
                modifier = centerModifier,
                text = "Gama: ${hymn.key}",
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Medium,
                fontStyle = FontStyle.Italic,
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Content
            Text(
                modifier = centerModifier,
                text = hymn.stanzas.joinToString("\n\n"),
                textAlign = TextAlign.Center,
                fontSize = 22.sp
            )

        }
    }

}

@Composable
@Preview
fun HymnDetailsScreenPreview(
    @PreviewParameter(HymnDetailsPreviewParameterProvider::class)
    hymn: HymnDetailsPresentationModel,
) {
    HymnDetailsScreen(hymn = hymn, onBackClicked = {})
}