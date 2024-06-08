package com.example.kot104_assignmentfinal.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.kot104_assignmentfinal.R
import com.example.kot104_assignmentfinal.httpModel.Product

data class AColor(
    val id: String,
    val color: Color
)

class DetailsScreen {
    @Composable
    fun Container(
        product: Product,
        goTo: (String) -> Unit,
        addToCart : (Product) -> Unit
    ) {
        var chooseColor = remember { mutableStateOf(0) }
        val listColor = listOf(
            AColor("1", Color(0xFF000000)),
            AColor("2", Color(0xFF0000FF)),
            AColor("3", Color(0xFF00FF00)),
        )
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(455.dp),
                contentAlignment = Alignment.TopEnd
            ) {
                AsyncImage(
                    model = product.image[0],
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .width(323.dp)
                        .height(455.dp)
                        .clip(RoundedCornerShape(bottomStart = 55.dp))
                )

                Column(
                    modifier = Modifier
                        .width(355.dp)
                        .height(455.dp)
                        .padding(vertical = 20.dp),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
//                    Spacer(modifier =Modifier.size(5.dp))
                    ToolBarCP(
                        leftIcon = R.drawable.ic_back,
//                        rightIcon = R.drawable.ic_cart,
                        simpleText = "null"
                    )

                    Column(
                        modifier = Modifier.shadow(
                            elevation = 10.dp,
                            shape = RoundedCornerShape(40.dp),
                            clip = true,
                            spotColor = Color(android.graphics.Color.parseColor("#999999")),
                            ambientColor = Color(android.graphics.Color.parseColor("#999999"))
                        )
                    ) {
                        LazyColumn(
                            modifier = Modifier
                                .width(64.dp)
                                .clip(RoundedCornerShape(40.dp))
                                .background(color = Color.White),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            itemsIndexed(listColor) { index, item ->
                                itemChooseColor(
                                    item = item,
                                    index = index,
                                    chooseColor = chooseColor
                                )
                            }
                        }
                    }

                    Spacer(
                        modifier = Modifier
                            .width(40.dp)
                            .height(40.dp)
                    )
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 25.dp)
            ) {
                Text(
//                    tách dấu cộng thành dấu cách

                    text = product.name.replace("+", " "),
                    fontSize = 24.sp,
                    fontFamily = FontFamily(Font(R.font.gelasio_bold)),
                    color = Color(android.graphics.Color.parseColor("#303030")),
                    modifier = Modifier.padding(top = 15.dp)
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "$ ${product.price}",
                        fontSize = 30.sp,
                        fontFamily = FontFamily(Font(R.font.nunito_sans_bold)),
                        color = Color(android.graphics.Color.parseColor("#303030"))
                    )

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.icon_plus),
                            contentDescription = null,
                            modifier = Modifier
                                .width(30.dp)
                                .height(30.dp)
                                .clip(RoundedCornerShape(6))
//                                .clickable { productDetail.quantity += 1 }
                        )

                        Spacer(modifier = Modifier.width(15.dp))

                        Text(
                            text = product.quantity.toString(),
                            fontSize = 18.sp,
                            fontFamily = FontFamily(Font(R.font.nunito_sans_semi_bold)),
                            color = Color(android.graphics.Color.parseColor("#242424"))
                        )

                        Spacer(modifier = Modifier.width(15.dp))

                        Image(
                            painter = painterResource(id = R.drawable.icon_minus),
                            contentDescription = null,
                            modifier = Modifier
                                .width(30.dp)
                                .height(30.dp)
                                .clip(RoundedCornerShape(6))
//                                .clickable { productDetail.quantity -= 1 }
                        )
                    }
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.icon_start_ams),
                        contentDescription = null,
                        modifier = Modifier
                            .width(20.dp)
                            .height(20.dp)
                    )

                    Text(
                        text = "4.5",
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.nunito_sans_bold)),
                        color = Color(android.graphics.Color.parseColor("#303030")),
                        modifier = Modifier.padding(start = 10.dp)
                    )

                    Text(
                        text = "(65 reviews)",
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.nunito_sans_bold)),
                        color = Color(android.graphics.Color.parseColor("#808080")),
                        modifier = Modifier.padding(start = 20.dp)
                    )
                }

                Text(
                    text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla eget",
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.nunito_sans_regular)),
                    color = Color(android.graphics.Color.parseColor("#606060")),
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .fillMaxWidth()
                        .weight(1f),
                    textAlign = TextAlign.Justify
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.icon_luu),
                        contentDescription = null,
                        modifier = Modifier
                            .size(60.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .clickable { }
                    )

                    ElevatedButton(
                        onClick = {
                            addToCart(product)
                        },
                        modifier = Modifier
                            .width(250.dp)
                            .height(60.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(android.graphics.Color.parseColor("#242424")),
                            disabledContainerColor = Color(android.graphics.Color.parseColor("#242424")),
                            contentColor = Color(android.graphics.Color.parseColor("#242424")),
                            disabledContentColor = Color(android.graphics.Color.parseColor("#242424")),
                        ),
                        shape = RoundedCornerShape(8.dp),
                        elevation = ButtonDefaults.buttonElevation(
                            defaultElevation = 8.dp
                        )
                    ) {
                        Text(
                            text = "Add to cart",
                            fontSize = 20.sp,
                            fontFamily = FontFamily(Font(R.font.nunito_sans_semi_bold)),
                            color = Color.White
                        )
                    }
                }
            }
        }
    }

    @Composable
    fun itemChooseColor(item: AColor, index: Int, chooseColor: MutableState<Int>) {
        Spacer(modifier = Modifier.height(15.dp))
        Box(
            modifier = Modifier
                .size(34.dp)
                .background(
                    color = if (index == chooseColor.value)
                        Color(android.graphics.Color.parseColor("#909090"))
                    else Color.White,
                    shape = CircleShape
                )
                .clickable { chooseColor.value = index },
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .size(24.dp)
                    .background(
                        color = item.color,
                        shape = CircleShape
                    )
            )
        }

        Spacer(modifier = Modifier.height(15.dp))
    }
}