package com.vicryfahreza.succulentapp.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.vicryfahreza.succulentapp.R
import com.vicryfahreza.succulentapp.ui.itemlayout.BottomNav
import com.vicryfahreza.succulentapp.ui.navigation.Page
import com.vicryfahreza.succulentapp.ui.page.about.AboutPage
import com.vicryfahreza.succulentapp.ui.page.dashboard.DashBoardPage
import com.vicryfahreza.succulentapp.ui.page.detail.DetailPage
import com.vicryfahreza.succulentapp.ui.page.info.InfoPage
import com.vicryfahreza.succulentapp.ui.theme.SucculentAppTheme

@Composable
fun JetSucculentsApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            if (currentRoute != Page.DetailSucculent.route) {
                BottomNav(navController)
            }
        },
        modifier = modifier
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Page.Dashboard.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Page.Dashboard.route) {
                DashBoardPage(
                    navigateToDetail = { succulentId ->
                        navController.navigate(Page.DetailSucculent.createRoute(succulentId))
                    }
                )
            }
            composable(Page.Info.route) {
                InfoPage(
                    imageSucculents = stringResource(R.string.info_succulent),
                    labelSucculent = stringResource(R.string.info_label),
                    descSucculent1 = stringResource(R.string.info_desc_1),
                    labelSoil = stringResource(R.string.info_label_soil),
                    imageSoil1 = stringResource(R.string.info_soil1),
                    imageSoil2 = stringResource(R.string.info_soil2),
                    imageSoil3 = stringResource(R.string.info_soil3),
                )
            }
            composable(Page.About.route) {
                AboutPage(
                    image = stringResource(R.string.about_user_image),
                    about = stringResource(R.string.about),
                    description = stringResource(R.string.about_description)
                )
            }
            composable(
                route = Page.DetailSucculent.route,
                arguments = listOf(navArgument("succulentId") { type = NavType.LongType } )
            ) {
                val id = it.arguments?.getLong("succulentId") ?: -1L
                DetailPage(
                    succulentId = id,
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun JetSucculentsAppPreview() {
    SucculentAppTheme {
        JetSucculentsApp()
    }
}



