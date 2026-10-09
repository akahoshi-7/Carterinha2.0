package com.senai.carterinha.feature.carterinha.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.senai.carterinha.core.designsystem.theme.CarterinhaTheme
import com.senai.carterinha.feature.carterinha.presentation.component.InfoAluno
import com.senai.carterinha.feature.carterinha.presentation.component.PerfilAluno
import com.senai.carterinha.feature.carterinha.presentation.component.QrCode

@Composable
fun CarteirinhaScreen(
    modifier: Modifier = Modifier,
    nome: String = "Kaikai",
    matricula: String = "25162248",
    curso: String = "Desenvolvimento de Sistemas",
    turma: String = "2DEVEST-B"
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        QrCode(
            conteudo = matricula,
            modifier = Modifier.padding(bottom = 12.dp)
                .size(160.dp)
        )
        Text(
            text = "CARTEIRINHA DIGITAL",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .border(width = 1.dp, color = MaterialTheme.colorScheme.outline)
                .padding(16.dp)
        ) {
            PerfilAluno(
                nome = nome,
                curso = curso,
                turma = turma,
                matricula = matricula
            )
        }
    }
}




@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CarteirinhaScreenPreview() {
    CarterinhaTheme {
        CarteirinhaScreen()
    }
}
