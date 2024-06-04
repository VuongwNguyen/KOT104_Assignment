package com.example.kot104_assignmentfinal.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.kot104_assignmentfinal.R
import com.example.kot104_assignmentfinal.ui.theme.MakeYourColor40
import com.example.kot104_assignmentfinal.ui.theme.WhiteColor


data class ProductInCart(
    val img: Int,
    val name: String,
    val price: Int,
    var quantity: Int
)

class CartScreen {
    val listProductInCart = mutableListOf(
        ProductInCart(R.drawable.product_image, "Product 1", 200, 1),
        ProductInCart(R.drawable.product_image, "Product 2", 200, 1),
        ProductInCart(R.drawable.product_image, "Product 3", 300, 1),
        ProductInCart(R.drawable.product_image, "Product 4", 400, 1),
        ProductInCart(R.drawable.product_image, "Product 5", 500, 1),
        ProductInCart(R.drawable.product_image, "Product 6", 600, 1),
        ProductInCart(R.drawable.product_image, "Product 7", 700, 1),
        ProductInCart(R.drawable.product_image, "Product 8", 800, 1),
        ProductInCart(R.drawable.product_image, "Product 9", 900, 1),
        ProductInCart(R.drawable.product_image, "Product 10", 1000, 1),
    )

    var total = listProductInCart.sumOf { it.price * it.quantity }

    @Composable
    fun Container() {
        Column(

        ) {
            Spacer(modifier = Modifier.size(30.dp))
            ToolBarCP(
                leftIcon = R.drawable.ic_back,
                rightIcon = R.drawable.ic_cart,
                simpleText = "My cart"
            )
            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .padding(top = 20.dp, start = 20.dp, end = 20.dp)
            ) {
                items(listProductInCart) { item ->
                    RenderItemCate(item, {}, {})
                }
            }
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .zIndex(1f)
//                    .align(Alignment.BottomCenter)
                    .background(Color.White),
                shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
            ) {
                Column(
                    modifier = Modifier
                        .background(color = Color.White)
                        .padding(horizontal = 20.dp)
                ) {
                    Spacer(modifier = Modifier.height(20.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        TextField(
                            value = "",
                            onValueChange = { },
                            placeholder = {
                                Text(
                                    "Enter your promo code", style = TextStyle(
                                        color = MakeYourColor40,
                                        fontFamily = FontFamily(Font(R.font.nunito_sans_semi_bold))
                                    )
                                )
                            },
                            modifier = Modifier
                                .weight(1f)
                                .background(Color.Transparent),
                            colors = TextFieldDefaults.colors(
                                focusedContainerColor = WhiteColor,
                                unfocusedContainerColor = WhiteColor,
                                focusedIndicatorColor = WhiteColor,
                                unfocusedIndicatorColor = WhiteColor
                            )
                        )
                        Image(
                            painter = painterResource(id = R.drawable.icon_back_black),
                            contentDescription = null,
                            modifier = Modifier.size(48.dp)
                        )
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Total:",
                            fontSize = 20.sp,
                            fontFamily = FontFamily(Font(R.font.nunito_sans_bold)),
                            color = Color(0xff808080)
                        )

                        Text(
                            text = "$ ${total}.00",
                            fontSize = 20.sp,
                            fontFamily = FontFamily(Font(R.font.nunito_sans_bold)),
                            color = Color(0xff303030)
                        )
                    }

                    ElevatedButton(
                        onClick = { },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(60.dp),
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xff242424),
                            disabledContainerColor = Color(0xff242424),
                            contentColor = Color(0xff242424),
                            disabledContentColor = Color(0xff242424),
                        )
                    ) {
                        Text(
                            text = "Check out",
                            fontSize = 20.sp,
                            fontFamily = FontFamily(Font(R.font.nunito_sans_semi_bold)),
                            color = Color.White,
                            textAlign = TextAlign.Center
                        )
                    }

                    Spacer(modifier = Modifier.height(20.dp))
                }
            }
        }

    }

    //    @Preview(showSystemUi = true, showBackground = true)
    @Composable
    fun RenderItemCate(item: ProductInCart, plusFunction: () -> Unit, minusFunction: () -> Unit) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp)
        ) {
            Image(
                painter = painterResource(id = item.img),
                contentDescription = null,
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
                    .clip(RoundedCornerShape(10.dp)),
                contentScale = ContentScale.FillBounds
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(start = 10.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Text(
                            text = "${item.name}",
                            fontSize = 14.sp,
                            fontFamily = FontFamily(Font(R.font.nunito_sans_semi_bold)),
                            color = Color(0xff999999)
                        )

                        Text(
                            text = "$ ${item.price}.00",
                            fontSize = 16.sp,
                            fontFamily = FontFamily(Font(R.font.nunito_sans_bold)),
                            color = Color(0xff242424),
                            modifier = Modifier.padding(top = 5.dp)
                        )
                    }
                    Image(
                        painter = painterResource(id = R.drawable.icon_delete_favorite),
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                }

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.icon_plus),
                        contentDescription = null,
                        modifier = Modifier
                            .size(30.dp)
                            .clickable { plusFunction() }
                    )

                    Text(
                        text = "${item.quantity}",
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.nunito_sans_semi_bold)),
                        color = Color(0xff242424),
                        modifier = Modifier.padding(horizontal = 10.dp)
                    )

                    Image(
                        painter = painterResource(id = R.drawable.icon_minus),
                        contentDescription = null,
                        modifier = Modifier
                            .size(30.dp)
                            .clickable { minusFunction() }
                    )
                }
            }
        }
    }
}



