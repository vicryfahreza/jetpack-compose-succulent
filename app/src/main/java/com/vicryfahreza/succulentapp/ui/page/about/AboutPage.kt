package com.vicryfahreza.succulentapp.ui.page.about

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.vicryfahreza.succulentapp.ui.theme.SucculentAppTheme

@Composable
fun AboutPage(
    modifier: Modifier = Modifier,
    image: String,
    about: String,
    description: String
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = image,
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = modifier
                    .padding(10.dp)
                    .size(200.dp)
            )

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = about,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    color = Color.Black,
                    textAlign = TextAlign.Center,
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
                    text = "vfahreza49@gmail.com",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    color = Color.Black,
                    textAlign = TextAlign.Center,
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
                    textAlign = TextAlign.Justify,
                    fontWeight = FontWeight.Normal,
                    fontSize = 18.sp,
                    color = Color.Black,
                    modifier = modifier
                        .padding(10.dp)
                        .fillMaxWidth()
                        .weight(1f)
                        .padding(start = 8.dp)
                        .fillMaxSize()
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun DetailPreview() {
    SucculentAppTheme {
        AboutPage(
            image = "",
            about = "About Me",
            description = "This Is Lorem Ipsum"
        )
    }
}