package com.example.aluvery2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aluvery2.extensions.toBrazilianCurrency
import com.example.aluvery2.model.Product
import com.example.aluvery2.ui.theme.Green10
import com.example.aluvery2.ui.theme.Purple40
import java.math.BigDecimal

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(modifier = Modifier.verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(16.dp)) {
                ProductSetion()
                ProductSetion()
                ProductSetion()
                ProductSetion()
                ProductSetion()
                ProductSetion()
                ProductSetion()
                ProductSetion()
            }
        }
    }
}

@Composable
fun ProductItem(product: Product) {
    Surface(
        shape = RoundedCornerShape(15.dp),
        shadowElevation = 4.dp,
    ) {
        Column(
            modifier = Modifier
                .heightIn(240.dp, 260.dp)
                .width(200.dp)
        ) {
            val imageSize = 100.dp
            Box(
                modifier = Modifier
                    .height(imageSize)
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                Purple40,
                                Color(0xBB6200EE),
                                Green10,
                            )
                        )
                    )
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(product.image),
                    contentDescription = null,
                    modifier = Modifier
                        .size(imageSize)
                        .offset(y = imageSize / 2)
                        .clip(shape = CircleShape)
                        .align(BottomCenter),
                        contentScale = ContentScale.Crop

                )
            }
            Spacer(
                modifier = Modifier
                    .height(50.dp)
            )

            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .horizontalScroll(rememberScrollState())
            ) {
                Text(
                    text = product.name,
                    fontSize = 18.sp,
                    fontWeight = FontWeight(700),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = product.price.toBrazilianCurrency(),
                    fontSize = 14.sp,
                    fontWeight = FontWeight(700),
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable

fun Atividade() {
    Surface(
        shadowElevation = 10.dp,
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier.padding(16.dp)

    ) {
        Row(
            modifier = Modifier
                .height(150.dp)
                .width(250.dp)
        ) {
            Box(
                modifier = Modifier
                    .width(80.dp)
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                Purple40,
                                Color(0xBB6200EE),
                                Green10,
                            )
                        )
                    )
                    .fillMaxHeight()
            ) {
                val rainbowColorsBrush = remember {
                    Brush.sweepGradient(
                        listOf(
                            Purple40,
                            Color(0xBB6200EE),
                            Green10,
                        )
                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = null,
                    modifier = Modifier
                        .offset(x = 40.dp)
                        .border(
                            BorderStroke(width = 2.dp, rainbowColorsBrush),
                            CircleShape
                        )
                        .align(Center)
                        .clip(shape = CircleShape)

                )
            }
            Column(
                modifier = Modifier
                    .padding(start = 50.dp, end = 10.dp, top = 16.dp, bottom = 16.dp)

            ) {
                Text(
                    text = LoremIpsum(50).values.first(),
                    fontSize = 12.sp,
                    fontWeight = FontWeight(500),
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}

@Composable
fun ProductSetion() {
    Column {
        Text(
            text = "Promoções",
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            fontWeight = FontWeight(400),
            fontSize = 20.sp
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
                .padding(top = 8.dp)
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)

        ) {
            ProductItem(
                product = Product(
                    name = "Hamburguer",
                    price = BigDecimal("13.85"),
                    image = R.drawable.hamburguer
                )
            )
            ProductItem(
                product = Product(
                    name = "Pizza",
                    price = BigDecimal("50.87"),
                    image = R.drawable.pizza
                )
            )
            ProductItem(
                product = Product(
                    name = "Cs Go",
                    price = BigDecimal("13.85"),
                    image = R.drawable.cs
                )
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ProductSetionPreview() {
    ProductSetion()
}

@Preview(showBackground = true , )
@Composable
fun ProdutItemPreview() {
    ProductItem(product = Product(
            name = LoremIpsum(50).values.first(),
            price = BigDecimal("13.85"),
            image = R.drawable.cs
        ))
}