package com.senai.carterinha.feature.carterinha.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.senai.carterinha.R

@Composable
fun PerfilAluno(
    nome: String,
    curso: String,
    turma: String = "",
    matricula: String = "",
    idFoto: Int = R.drawable.angrybird
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(id = idFoto),
            contentDescription = "Foto do aluno",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(160.dp)
                .padding(16.dp)
                .clip(RectangleShape)
                .border(
                    width = 1.dp,
                    MaterialTheme.colorScheme.primary,
                    RectangleShape
                )
        )
        InfoAluno(
            labelText = "Nome",
            valueText = nome,
            fontSize = 18.sp
        )
        InfoAluno(
            labelText = "Curso",
            valueText = curso,
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal
        )
        if (turma.isNotBlank()) {
            InfoAluno(
                labelText = "Turma",
                valueText = turma,
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal
            )
        }
        if (matricula.isNotBlank()) {
            InfoAluno(
                labelText = "Matricula",
                valueText = matricula,
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal
            )
        }
    }
}
