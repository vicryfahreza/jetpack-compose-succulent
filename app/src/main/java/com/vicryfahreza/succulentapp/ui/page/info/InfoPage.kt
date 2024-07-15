package com.vicryfahreza.succulentapp.ui.page.info

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import coil.compose.AsyncImage
import com.vicryfahreza.succulentapp.ui.theme.SucculentAppTheme

@Composable
fun InfoPage(
    imageSucculents: String,
    labelSucculent: String,
    descSucculent1: String,
    labelSoil: String,
    imageSoil1: String,
    imageSoil2: String,
    imageSoil3: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = imageSucculents,
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .size(200.dp)
            )

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = labelSucculent,
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
                    text = descSucculent1,
                    textAlign = TextAlign.Justify,
                    fontWeight = FontWeight.Normal,
                    fontSize = 18.sp,
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
                    text = labelSoil,
                    textAlign = TextAlign.Justify,
                    fontWeight = FontWeight.Normal,
                    fontSize = 18.sp,
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
                AsyncImage(
                    model = imageSoil1,
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = modifier
                        .padding(10.dp)
                        .size(100.dp)
                        .height(100.dp)
                        .clip(CircleShape)
                )

                AsyncImage(
                    model = imageSoil2,
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = modifier
                        .padding(10.dp)
                        .size(100.dp)
                        .height(100.dp)
                        .clip(CircleShape)
                )

                AsyncImage(
                    model = imageSoil3,
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = modifier
                        .padding(10.dp)
                        .size(100.dp)
                        .height(100.dp)
                        .clip(CircleShape)
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Lava Rock",
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Medium,
                    fontSize = 18.sp,
                    color = Color.Black,
                    modifier = modifier
                        .padding(10.dp)
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .width(100.dp)
                        .weight(1f)
                        .padding(start = 8.dp)
                )

                Text(
                    text = "Pumis",
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Medium,
                    fontSize = 18.sp,
                    color = Color.Black,
                    modifier = modifier
                        .padding(10.dp)
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .width(100.dp)
                        .weight(1f)
                        .padding(start = 8.dp)
                )

                Text(
                    text = "Akadama",
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Medium,
                    fontSize = 18.sp,
                    color = Color.Black,
                    modifier = modifier
                        .padding(10.dp)
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .width(100.dp)
                        .weight(1f)
                        .padding(start = 8.dp)
                )
            }


        }
    }
}

@Composable
@Preview(showBackground = true)
fun DetailPreview() {
    SucculentAppTheme {
        InfoPage(
            imageSucculents = "",
            labelSucculent = "What is Succulent?",
            descSucculent1 = "Lorem Lorem Lorem Lorem Lorem Lorem Lorem Lorem Lorem Lorem Lorem Lorem Lorem Lorem Lorem Lorem Lorem Lorem ",
            labelSoil = "This is soil recommendation for Succulent",
            imageSoil1 = "",
            imageSoil2 = "",
            imageSoil3 = "",
        )
    }
}