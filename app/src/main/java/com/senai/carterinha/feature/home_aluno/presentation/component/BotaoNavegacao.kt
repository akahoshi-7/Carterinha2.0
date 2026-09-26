package com.senai.carterinha.feature.home_aluno.presentation.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun BotaoNavegacao (
    text : String,
    onClick : () -> Unit,
    modifier: Modifier = Modifier
){
    Button(
        modifier = modifier,
        onClick = onClick,
        shape = RectangleShape,
        border = BorderStroke(
            width = 1.dp,
            color = MaterialTheme.colorScheme.outline
        ),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.background,
            contentColor = MaterialTheme.colorScheme.primary
        )
    ) {
        Text(
            text = text.uppercase()
        )
    }
}
@Preview(showBackground = true)
@Composable
fun BotaoNavegacaoPreview(){
    BotaoNavegacao(
        text = "Carteirinha",
        onClick = {}
    )
}
