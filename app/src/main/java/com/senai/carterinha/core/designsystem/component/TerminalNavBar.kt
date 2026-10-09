package com.senai.carterinha.core.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.clickable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

data class TerminalNavItem(
    val label: String,
    val selected: Boolean = false,
    val onClick: () -> Unit
)


@Composable
fun TerminalNavBar(
    items: List<TerminalNavItem>,
    onMoreClick: () -> Unit,
    modifier: Modifier = Modifier,
    moreLabel: String = ""
) {
    val scrollState = rememberScrollState()

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 10.dp)
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.outline
            )
            .background(MaterialTheme.colorScheme.background)
            .horizontalScroll(scrollState)
            .padding(horizontal = 16.dp, vertical = 14.dp),
    ) {
        items.forEachIndexed { index, item ->
            TerminalNavLabel(
                text = item.label,
                selected = item.selected,
                onClick = item.onClick
            )
            if (index != items.lastIndex) {
                Row(modifier = Modifier.padding(horizontal = 10.dp)) {}
            }
        }
        Row(modifier = Modifier.padding(horizontal = 10.dp)) {}
        TerminalNavLabel(
            text = moreLabel,
            selected = false,
            onClick = onMoreClick
        )
    }
}

@Composable
private fun TerminalNavLabel(
    text: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    Text(
        text = text.uppercase(),
        style = MaterialTheme.typography.titleMedium,
        fontWeight = if (selected) FontWeight.Bold else FontWeight.Normal,
        color = MaterialTheme.colorScheme.primary.copy(alpha = if (selected) 1f else 0.75f),
        modifier = Modifier.clickable(onClick = onClick)
    )
}
