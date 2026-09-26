package com.senai.carterinha.core.designsystem.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import kotlinx.coroutines.launch

/**
 * Scaffold padrão do app: barra de navegação estilo "terminal" no topo
 * ([TerminalNavBar]) + menu lateral (drawer) para as opções secundárias e sair.
 */
@Composable
fun AppScaffold(
    navItems: List<TerminalNavItem>,
    usuarioNome: String,
    usuarioDescricao: String,
    drawerItems: List<AppDrawerItem>,
    onLogoutClick: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable (PaddingValues) -> Unit
) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        modifier = modifier,
        drawerState = drawerState,
        drawerContent = {
            AppDrawerContent(
                usuarioNome = usuarioNome,
                usuarioDescricao = usuarioDescricao,
                items = drawerItems.map { item ->
                    item.copy(
                        onClick = {
                            scope.launch { drawerState.close() }
                            item.onClick()
                        }
                    )
                },
                onLogoutClick = {
                    scope.launch { drawerState.close() }
                    onLogoutClick()
                }
            )
        }
    ) {
        Scaffold(
            topBar = {
                TerminalNavBar(
                    items = navItems,
                    onMoreClick = { scope.launch { drawerState.open() } }
                )
            },
            content = content
        )
    }
}
