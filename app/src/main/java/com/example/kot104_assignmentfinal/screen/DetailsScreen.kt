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
import com.example.kot104_assignmentfinal.R


data class ProductDetail(
    val id: Int,
    val name: String,
    val price: Int,
    val start: Float,
    val reviews: Int,
    val description: String,
    var quantity: Int,
    val imgColors: List<imgColor>
) {
    data class imgColor(
        val id_img: Int,
        val img: Int,
        val color_img: String
    )
}
class DetailsScreen {
    @Composable
    fun Container() {
        var chooseColor = remember { mutableStateOf(0) }
        var quantity = remember { mutableStateOf(1) }
        val productDetail = ProductDetail(
            1,
            "Minimal Stand",
            50,
            4.5F,
            50,
            "Minimal Stand is made of by natural wood. The design that is very simple and minimal. This is truly one of the best furnitures in any family for now. With 3 different colors, you can easily select the best match for your home. ",
            1,
            imgColors = listOf(
                ProductDetail.imgColor(
                    1,
                    R.drawable.minimal_stand,
                    "FFFFFF"
                ),
                ProductDetail.imgColor(
                    2,
                    R.drawable.coffee_chair,
                    "B4916C"
                ),
                ProductDetail.imgColor(
                    3,
                    R.drawable.black_simple_lamp,
                    "E4CBAD"
                ),
            )
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
                Image(
                    painter = painterResource(id = productDetail.imgColors[0].img),
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
                            itemsIndexed(productDetail.imgColors){ index, item ->
                                itemChooseColor(item = item, index = index, chooseColor = chooseColor)
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

            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 25.dp)
            ){
                Text(
                    text = "${productDetail.name}",
                    fontSize = 24.sp,
                    fontFamily = FontFamily(Font(R.font.gelasio_bold)),
                    color = Color(android.graphics.Color.parseColor("#303030")),
                    modifier = Modifier.padding(top = 15.dp)
                )

                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(
                        text = "$ ${productDetail.price}",
                        fontSize = 30.sp,
                        fontFamily = FontFamily(Font(R.font.nunito_sans_bold)),
                        color = Color(android.graphics.Color.parseColor("#303030"))
                    )

                    Row (
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Image(
                            painter = painterResource(id = R.drawable.icon_plus),
                            contentDescription = null,
                            modifier = Modifier
                                .width(30.dp)
                                .height(30.dp)
                                .clip(RoundedCornerShape(6))
                                .clickable { productDetail.quantity += 1 }
                        )

                        Spacer(modifier = Modifier.width(15.dp))

                        Text(
                            text = "${productDetail.quantity}",
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
                                .clickable { productDetail.quantity -= 1 }
                        )
                    }
                }

                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Image(
                        painter = painterResource(id = R.drawable.icon_start_ams),
                        contentDescription = null,
                        modifier = Modifier
                            .width(20.dp)
                            .height(20.dp)
                    )

                    Text(
                        text = "${productDetail.start}",
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.nunito_sans_bold)),
                        color = Color(android.graphics.Color.parseColor("#303030")),
                        modifier = Modifier.padding(start = 10.dp)
                    )

                    Text(
                        text = "(${productDetail.reviews} reviews)",
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.nunito_sans_bold)),
                        color = Color(android.graphics.Color.parseColor("#808080")),
                        modifier = Modifier.padding(start = 20.dp)
                    )
                }

                Text(
                    text = "${productDetail.description}",
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.nunito_sans_regular)),
                    color = Color(android.graphics.Color.parseColor("#606060")),
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .fillMaxWidth(),
                    textAlign = TextAlign.Justify
                )

                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Image(
                        painter = painterResource(id = R.drawable.icon_luu),
                        contentDescription = null,
                        modifier = Modifier
                            .size(60.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .clickable { }
                    )

                    ElevatedButton(
                        onClick = { /*TODO*/ },
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
    fun itemChooseColor(item: ProductDetail.imgColor, index: Int, chooseColor: MutableState<Int>) {
        Spacer(modifier = Modifier.height(15.dp))
        Box (
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
        ){
            Box(
                modifier = Modifier
                    .size(24.dp)
                    .background(
                        color = Color(android.graphics.Color.parseColor("#${item.color_img}")),
                        shape = CircleShape
                    )
            )
        }

        Spacer(modifier = Modifier.height(15.dp))
    }
}