package com.example.wikicalculator.ui

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

/**
 * Usage
 * ExpandableText(
 *  modifier = Modifier.align(Alignment.End).padding(xxx),
 *  content = content,
 *  onClickListener = onClickListener,
 * )
 * */
@Composable
fun ExpandableText(
    modifier: Modifier = Modifier,
    content: String,
    onClickListener: () -> Unit,
) {
    var isExpanded by remember { mutableStateOf(false) }

    Column(
        modifier = modifier,
    ) {
        if (isExpanded && content.isNotBlank()) {
            Text(
                modifier = Modifier
                    .clickable { isExpanded = !isExpanded }
                    .animateContentSize(),
                text = content,
            )
        }

        TextButton(
            modifier = Modifier.align(Alignment.End),
            onClick = {
                onClickListener()
                isExpanded = !isExpanded
            }
        ) {
            Text(if(isExpanded) "Collapse" else "Expand")
        }
    }
}