package com.senai.carterinha.feature.unidadecurricular.presentation

import com.senai.carterinha.feature.unidadecurricular.domain.model.UnidadeCurricular

data class UnidadeCurricularUiState(
    val isLoading: Boolean = false,
    val listaUnidadesCurriculares: List<UnidadeCurricular> = emptyList(),
    val errorMessage: String? = null
)