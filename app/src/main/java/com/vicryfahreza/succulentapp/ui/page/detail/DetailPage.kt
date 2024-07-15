package com.vicryfahreza.succulentapp.ui.page.detail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.vicryfahreza.succulentapp.model.di.SucculentInjection
import com.vicryfahreza.succulentapp.ui.factory.ViewModelFactory
import com.vicryfahreza.succulentapp.ui.page.state.UIStatus
import com.vicryfahreza.succulentapp.ui.theme.SucculentAppTheme

@Composable
fun DetailPage(
    succulentId: Long,
    modifier: Modifier = Modifier,
    viewModel: DetailViewModel = viewModel(
        factory = ViewModelFactory(
            SucculentInjection.provideRepository()
        )
    )
) {
    Scaffold { padding ->
        Box(modifier = modifier.padding(padding)) {
            viewModel.uiStatus.collectAsState(initial = UIStatus.Loading).value.let { uiStatus ->
                when (uiStatus) {
                    is UIStatus.Loading -> {
                        viewModel.getSucculentById(succulentId)
                    }
                    is UIStatus.Success -> {
                        val detail = uiStatus.data
                        DetailContent(
                            detail.succulent.image,
                            detail.succulent.name,
                            detail.succulent.description,
                            detail.succulent.tips
                        )
                    }
                    is UIStatus.Error -> {}
                }
            }
        }
    }
}

@Composable
fun DetailContent(
    image: String,
    name: String,
    description: String,
    tips: String,
    modifier: Modifier = Modifier,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(model = image,
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = modifier
                .padding(10.dp)
                .size(200.dp)
                .clip(CircleShape)
        )

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = name,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = Color.Black,
                modifier = modifier
                    .padding(10.dp)
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(start = 8.dp)
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = description,
                fontWeight = FontWeight.Normal,
                fontSize = 18.sp,
                textAlign = TextAlign.Justify,
                color = Color.Black,
                modifier = modifier
                    .padding(10.dp)
                    .weight(1f)
                    .padding(start = 8.dp)
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Tips",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = Color.Black,
                modifier = modifier
                    .padding(10.dp)
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(start = 8.dp)
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = tips,
                fontWeight = FontWeight.Normal,
                fontSize = 18.sp,
                textAlign = TextAlign.Justify,
                color = Color.Black,
                modifier = modifier
                    .padding(10.dp)
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(start = 8.dp)
            )
        }

    }



}

@Composable
@Preview(showBackground = true)
fun DetailPreview() {
    SucculentAppTheme {
        DetailContent(
            image = "",
            name = "Echeveria",
            description = "lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum",
            tips = "lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum",
        )
    }
}