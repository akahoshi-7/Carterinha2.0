package com.senai.carterinha.app.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Badge
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.senai.carterinha.app.di.AppContainer
import com.senai.carterinha.app.session.SessionViewModel
import com.senai.carterinha.core.designsystem.component.AppDrawerItem
import com.senai.carterinha.core.designsystem.component.AppScaffold
import com.senai.carterinha.core.designsystem.component.TerminalNavItem
import com.senai.carterinha.feature.carterinha.presentation.screen.CarteirinhaScreen
import com.senai.carterinha.feature.home_aluno.presentation.screen.HomeScreen
import com.senai.carterinha.feature.login.presentation.screen.LoginScreen
import com.senai.carterinha.feature.unidadecurricular.presentation.UnidadeCurricularViewModel
import com.senai.carterinha.feature.unidadecurricular.presentation.factory.UnidadeCurricularViewModelFactory
import com.senai.carterinha.feature.unidadecurricular.presentation.screen.UnidadeCurricularScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    sessionViewModel: SessionViewModel = viewModel(),
    container: AppContainer,
) {
    val usuarioLogado by sessionViewModel.usuarioLogado.collectAsStateWithLifecycle()
    val usuario = usuarioLogado

    fun logout() {
        sessionViewModel.limparSession()
        container.authTokenStore.clearToken()
        navController.navigate(Routes.Login.route) {
            popUpTo(0) { inclusive = true }
        }
    }
    fun navItemsFor(currentRoute: String) = listOf(
        TerminalNavItem(
            label = "Home",
            selected = currentRoute == Routes.Home.route,
            onClick = {
                navController.navigate(Routes.Home.route) {
                    popUpTo(Routes.Home.route) { inclusive = true }
                }
            }
        ),
        TerminalNavItem(
            label = "Carteirinha",
            selected = currentRoute == Routes.Carteirinha.route,
            onClick = { navController.navigate(Routes.Carteirinha.route) }
        ),
        TerminalNavItem(
            label = "Materias",
            selected = currentRoute == Routes.UnidadesCurriculares.route,
            onClick = { navController.navigate(Routes.UnidadesCurriculares.route) }
        )
    )

    fun drawerItemsFor(currentRoute: String) = listOf(
        AppDrawerItem(
            label = "Home",
            icon = Icons.Default.Home,
            selected = currentRoute == Routes.Home.route,
            onClick = {
                navController.navigate(Routes.Home.route) {
                    popUpTo(Routes.Home.route) { inclusive = true }
                }
            }
        ),
        AppDrawerItem(
            label = "Carteirinha",
            icon = Icons.Default.Badge,
            selected = currentRoute == Routes.Carteirinha.route,
            onClick = { navController.navigate(Routes.Carteirinha.route) }
        ),
        AppDrawerItem(
            label = "Unidades curriculares",
            icon = Icons.Default.MenuBook,
            selected = currentRoute == Routes.UnidadesCurriculares.route,
            onClick = { navController.navigate(Routes.UnidadesCurriculares.route) }
        )
    )

    NavHost(
        navController = navController,
        startDestination = Routes.Login.route
    ) {
        composable(Routes.Login.route) {
            LoginScreen(
                navController = navController,
                onLoginSucesso = { usuarioLogadoResult ->
                    container.authTokenStore.setToken(usuarioLogadoResult.token)
                    sessionViewModel.setUsuarioLogado(usuarioLogadoResult)
                    navController.navigate(Routes.Home.route) {
                        popUpTo(Routes.Login.route) {
                            inclusive = true
                        }
                    }
                }
            )
        }

        composable(Routes.Home.route) {
            if (usuario == null) {
                LaunchedEffect(Unit) {
                    navController.navigate(Routes.Login.route)
                }
            } else {
                AppScaffold(
                    navItems = navItemsFor(Routes.Home.route),
                    usuarioNome = usuario.nome,
                    usuarioDescricao = "${usuario.curso} - ${usuario.turma}",
                    drawerItems = drawerItemsFor(Routes.Home.route),
                    onLogoutClick = { logout() },
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    HomeScreen(
                        navController = navController,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }

        composable(Routes.Carteirinha.route) {
            if (usuario == null) {
                LaunchedEffect(Unit) {
                    navController.navigate(Routes.Login.route)
                }
            } else {
                AppScaffold(
                    navItems = navItemsFor(Routes.Carteirinha.route),
                    usuarioNome = usuario.nome,
                    usuarioDescricao = "${usuario.curso} - ${usuario.turma}",
                    drawerItems = drawerItemsFor(Routes.Carteirinha.route),
                    onLogoutClick = { logout() },
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    CarteirinhaScreen(
                        nome = usuario.nome,
                        curso = usuario.curso,
                        turma = usuario.turma,
                        matricula = usuario.matricula,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }

        composable(Routes.UnidadesCurriculares.route) {
            if (usuario == null) {
                LaunchedEffect(Unit) {
                    navController.navigate(Routes.Login.route)
                }
            } else {
                val unidadeCurricularFactory = remember(container.unidadeCurricularRepository) {
                    UnidadeCurricularViewModelFactory(
                        repository = container.unidadeCurricularRepository
                    )
                }

                val unidadeCurricularViewModel: UnidadeCurricularViewModel = viewModel(
                    factory = unidadeCurricularFactory
                )

                AppScaffold(
                    navItems = navItemsFor(Routes.UnidadesCurriculares.route),
                    usuarioNome = usuario.nome,
                    usuarioDescricao = "${usuario.curso} - ${usuario.turma}",
                    drawerItems = drawerItemsFor(Routes.UnidadesCurriculares.route),
                    onLogoutClick = { logout() },
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    UnidadeCurricularScreen(
                        modifier = Modifier.padding(innerPadding),
                        viewModel = unidadeCurricularViewModel
                    )

                }
            }
        }
    }
}