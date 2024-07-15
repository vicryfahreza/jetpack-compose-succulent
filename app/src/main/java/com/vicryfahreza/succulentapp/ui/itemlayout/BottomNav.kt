package com.vicryfahreza.succulentapp.ui.itemlayout

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.vicryfahreza.succulentapp.R
import com.vicryfahreza.succulentapp.ui.navigation.NavigationItem
import com.vicryfahreza.succulentapp.ui.navigation.Page

@Composable
fun BottomNav(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {

    NavigationBar(
        modifier = modifier
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        val navigationItems = listOf(
            NavigationItem(
                title = stringResource(R.string.dashboard_page),
                icon = Icons.Default.Home,
                page = Page.Dashboard
            ),
            NavigationItem(
                title = stringResource(R.string.info_page),
                icon = Icons.Default.Info,
                page = Page.Info
            ),
            NavigationItem(
                title = stringResource(R.string.about_page),
                icon = Icons.Default.AccountCircle,
                page = Page.About
            ),
        )

    navigationItems.map { item ->
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = item.icon,
                    contentDescription = item.title
                )
            },
            label = { Text(item.title) },
            selected = currentRoute == item.page.route,
            onClick = {
                    navController.navigate(item.page.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        restoreState = true
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}
