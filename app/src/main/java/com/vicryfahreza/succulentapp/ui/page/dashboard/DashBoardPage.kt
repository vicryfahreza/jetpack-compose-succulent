
package com.vicryfahreza.succulentapp.ui.page.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.vicryfahreza.succulentapp.model.BookMarkSucculent
import com.vicryfahreza.succulentapp.model.di.SucculentInjection
import com.vicryfahreza.succulentapp.ui.factory.ViewModelFactory
import com.vicryfahreza.succulentapp.ui.itemlayout.SearchSucculent
import com.vicryfahreza.succulentapp.ui.itemlayout.SucculentRow
import com.vicryfahreza.succulentapp.ui.page.state.UIStatus

@Composable
fun DashBoardPage(
    modifier: Modifier = Modifier,
    viewModel: DashBoardViewModel = viewModel(
        factory =  ViewModelFactory(SucculentInjection.provideRepository())
    ),
    navigateToDetail: (Long) -> Unit,
) {
    viewModel.uistatus.collectAsState(initial = UIStatus.Loading).value.let { uistatus ->
        when (uistatus) {
            is UIStatus.Loading -> {
                viewModel.getAllSucculents()
            }
            is UIStatus.Success -> {
                DashBoardContent(
                    bookMark = uistatus.data,
                    modifier = modifier,
                    navigateToDetail = navigateToDetail,
                    viewModel = viewModel,
                )
            }
            is UIStatus.Error -> {}
        }
    }
}

@Composable
fun DashBoardContent(
    bookMark: List<BookMarkSucculent>,
    navigateToDetail: (Long) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: DashBoardViewModel
) {
    Box {
        Column {
            val query by viewModel.query

            SearchSucculent(
                query = query,
                onQueryChange = viewModel::search,
                modifier = Modifier.background(MaterialTheme.colorScheme.primary)
            )

            LazyVerticalGrid(
                columns = GridCells.Adaptive(160.dp),
                contentPadding = PaddingValues(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = modifier
            )
            {
                items(bookMark) { data ->
                    SucculentRow(
                        image = data.succulent.image,
                        name = data.succulent.name,
                        modifier = Modifier.clickable {
                            navigateToDetail(data.succulent.id)
                        }
                    )
                }
            }
        }
    }
}