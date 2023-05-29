package de.dannyb.hymns

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dagger.hilt.android.AndroidEntryPoint
import de.dannyb.hymns.app.navigation.HymnsAppNavHost
import de.dannyb.hymns.ui.theme.ImnuriAZSMRTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ImnuriAZSMRTheme {
                // A surface container using the 'background' color from the theme

                MainAppContent()
            }
        }
    }

}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun MainAppContent() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Imnuri AZS-MR",
                        modifier = Modifier.padding(12.dp),
                        fontWeight = FontWeight.Bold
                    )
                },
                modifier = Modifier.background(MaterialTheme.colorScheme.primary)
            )
        }
    ) { padding ->
        HymnsAppNavHost(Modifier.padding(padding))
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ImnuriAZSMRTheme {
        MainAppContent()
    }
}