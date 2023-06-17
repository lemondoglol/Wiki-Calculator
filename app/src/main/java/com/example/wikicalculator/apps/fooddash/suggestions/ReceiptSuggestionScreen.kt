package com.example.wikicalculator.apps.fooddash.suggestions

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.viewinterop.AndroidView
import com.example.wikicalculator.R
import com.example.wikicalculator.apps.fooddash.model.Ingredient
import com.example.wikicalculator.apps.fooddash.model.Veggies
import com.example.wikicalculator.core.model.FontSize
import com.example.wikicalculator.core.ui.ClickableLink
import com.example.wikicalculator.core.ui.VerticalSpacer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerCallback
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        YoutubePlayerContainer(
            modifier = Modifier.fillMaxWidth(),
        )

        VerticalSpacer()

        Text(
            text = "What you would need:",
            fontSize = FontSize.fontSizeM,
        )

        // TODO, Build the ingredients map in VM
        IngredientsSection(
            modifier = Modifier.fillMaxSize(),
            ingredients = mapOf(
                Veggies.Tomato to "5 Tomatoes",
                Veggies.GreenOnion to "2 Green Onions",
            ),
        )
    }
}

@Composable
fun YoutubePlayerContainer(
    modifier: Modifier = Modifier,
    videoId: String = "k_YkQSTvjLk",
) {
    AndroidView(
        modifier = modifier,
        factory = { context ->
            YouTubePlayerView(context = context).apply {
                this.getYouTubePlayerWhenReady(
                    object : YouTubePlayerCallback {
                        override fun onYouTubePlayer(youTubePlayer: YouTubePlayer) {
                            youTubePlayer.loadVideo(videoId, 0f)
                            youTubePlayer.play()
                        }
                    }
                )
            }
        }
    )
}

@Composable
private fun IngredientsSection(
    modifier: Modifier = Modifier,
    ingredients: Map<Ingredient, String>,
) {
    LazyColumn(
        modifier = modifier,
    ) {
        items(items = ingredients.keys.toList()) { item ->
            IngredientRow(
                modifier = Modifier.fillMaxWidth(),
                ingredient = item,
                content = ingredients[item] ?: "",
            )
        }
    }
}

@Composable
private fun IngredientRow(
    modifier: Modifier = Modifier,
    ingredient: Ingredient,
    content: String,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            modifier = Modifier.weight(1f),
            imageVector = Icons.Default.Favorite,
            contentDescription = "",
        )

        Text(
            text = content,
            modifier = Modifier.weight(1f),
        )

        val context = LocalContext.current
        ClickableLink(
            modifier = Modifier.weight(1f),
            url = ingredient.itemLink,
            text = stringResource(R.string.purchase_link),
            onClick = {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(ingredient.itemLink))
                context.startActivity(intent)
            },
        )
    }
}