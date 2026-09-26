package com.senai.carterinha.feature.login.data.repository

import com.senai.carterinha.feature.login.domain.model.UsuarioLogado

interface LoginRepository {
    suspend fun login( usuario:String, senha:String): Result<UsuarioLogado>
}