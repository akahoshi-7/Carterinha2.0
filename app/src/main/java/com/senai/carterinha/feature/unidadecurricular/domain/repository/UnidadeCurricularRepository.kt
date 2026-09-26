package com.senai.carterinha.feature.unidadecurricular.domain.repository

import com.senai.carterinha.feature.unidadecurricular.domain.model.UnidadeCurricular

interface UnidadeCurricularRepository {
    suspend fun listarUnidadesCurriculares(): Result<List<UnidadeCurricular>>
}