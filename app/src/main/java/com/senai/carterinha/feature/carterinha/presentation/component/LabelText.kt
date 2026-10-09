package com.senai.carterinha.feature.carterinha.presentation.component

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp

@Composable
fun LabelText(
    label: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = label.uppercase(),
        textAlign = TextAlign.Right,
        style = MaterialTheme.typography.bodyMedium,
        fontFamily = MaterialTheme.typography.bodyMedium.fontFamily,
        modifier = modifier,
        color = MaterialTheme.colorScheme.onSurfaceVariant
    )
}
