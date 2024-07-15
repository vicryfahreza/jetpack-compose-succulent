package com.vicryfahreza.succulentapp.ui.itemlayout

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
fun SucculentRow(
    image: String,
    name: String,
    modifier: Modifier = Modifier,
){

    Column(
        modifier = modifier
    ) {
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp),
        elevation = 2.dp,
        backgroundColor = Color.White,
        shape = RoundedCornerShape(corner = CornerSize(16.dp))
    ) {
        AsyncImage(model = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(8.dp)
                .size(150.dp)
                .clip(CircleShape)
        )
    }
        Row {
            Text(
                text = name,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Medium,
                fontSize = 18.sp,
                color = Color.Black,
                modifier = Modifier
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
        SucculentRow(
            image = "",
            name = "Echeveria")
    }
}


