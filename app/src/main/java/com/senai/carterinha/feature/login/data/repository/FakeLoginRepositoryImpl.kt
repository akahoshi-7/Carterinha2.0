package com.senai.carterinha.feature.login.data.repository

import com.senai.carterinha.feature.login.domain.model.UsuarioLogado
import kotlinx.coroutines.delay

class FakeLoginRepositoryImpl : LoginRepository {

    override suspend fun login(usuario: String, senha: String)
            : Result<UsuarioLogado> {
        delay(1500)
        return if(usuario.equals("maria") && senha.equals("123")){
            Result.success(
                UsuarioLogado(
                    id="1",
                    nome = "Maria",
                    matricula = "25162248",
                    curso = "Desenvolvimento de Sistema",
                    turma = "2DEVEST-B",
                    token = "token-fake-para-aula"
                )
            )
        }else{
            Result.failure(
                IllegalArgumentException(
                    "Login ou senha inválidos"
                )
            )
        }
    }
}