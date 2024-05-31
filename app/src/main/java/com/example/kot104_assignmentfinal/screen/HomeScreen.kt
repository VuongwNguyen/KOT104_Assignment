package com.example.kot104_assignmentfinal.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kot104_assignmentfinal.R
import com.example.kot104_assignmentfinal.constant.AppConstant
import com.example.kot104_assignmentfinal.ui.theme.DisableColor
import com.example.kot104_assignmentfinal.ui.theme.GreyColor
import com.example.kot104_assignmentfinal.ui.theme.HomeBeautiColor
import com.example.kot104_assignmentfinal.ui.theme.MakeYourColor40
import com.example.kot104_assignmentfinal.ui.theme.PrimaryColor

class HomeScreen {
    @Composable
    fun Container() {
        Column(Modifier.padding(top = 30.dp)) {
            ToolBarCP(
                leftIcon = R.drawable.ic_search,
                rightIcon = R.drawable.ic_cart,
//                simpleText = "My cart"
            )
            LazyRow {
                items(getCategories()) { item ->
                    RenderItemCate(item)
                }
            }
            LazyVerticalStaggeredGrid(
                columns = StaggeredGridCells.Fixed(2),
                verticalItemSpacing = 10.dp,
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier.padding(10.dp)
            ) {
                items(getProduct()) { item ->
                    RenderProduct(item)
                }
            }
        }
    }

    @Composable
    fun RenderProduct(item: Product) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
                    .height(200.dp)
                    .paint(
                        painter = painterResource(id = item.image),
                        contentScale = ContentScale.FillBounds
                    )
            ) {
                Image(
                    painter = painterResource(
                        id = R.drawable.ic_shopping_bag,
                    ),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .size(45.dp)
                        .padding(10.dp)
                        .offset(x = (-7).dp, y = (-7).dp)
                        .background(
                            color = MakeYourColor40,
                            shape = RoundedCornerShape(5.dp)
                        )
                )
            }
            Text(
                text = item.name,
                style = MaterialTheme.typography.bodySmall,
            )
            Text(
                text = "$${item.price}.00",
                style = MaterialTheme.typography.bodySmall,
                fontWeight = FontWeight(700),
                color = HomeBeautiColor,
                fontFamily = FontFamily(Font(AppConstant.FONT_NUNITO_SANS_BOLD)),
            )
        }
    }

    @Composable
    fun RenderItemCate(item: Category) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = item.image),
                contentDescription = null,
                modifier = Modifier
                    .size(50.dp)
                    .background(color = DisableColor, shape = RoundedCornerShape(10.dp))
                    .padding(10.dp)
            )
            Text(
                text = item.name,
                style = MaterialTheme.typography.displaySmall
            )
        }
    }


    data class Category(
        val name: String, val image: Int
    )

    fun getCategories() = listOf(
        Category("Chair", R.drawable.ic_chair),
        Category("Table", R.drawable.ic_table),
        Category("Armchair", R.drawable.ic_sofa),
        Category("Bed", R.drawable.ic_bed),
        Category("Lamp", R.drawable.ic_lamp),
    )

    data class Product(
        val name: String,
        val image: Int,
        val price: Int,
    )

    fun getProduct() = listOf(
        Product("Black Simple Lamp", R.drawable.product_image, 50),
        Product("Black Simple Lamp", R.drawable.product_image, 50),
        Product("Black Simple Lamp", R.drawable.product_image, 50),
        Product("Black Simple Lamp", R.drawable.product_image, 50),
        Product("Black Simple Lamp", R.drawable.product_image, 50),
        Product("Black Simple Lamp", R.drawable.product_image, 50),
        Product("Black Simple Lamp", R.drawable.product_image, 50),
        Product("Black Simple Lamp", R.drawable.product_image, 50),
        Product("Black Simple Lamp", R.drawable.product_image, 50),
        Product("Black Simple Lamp", R.drawable.product_image, 50),
        Product("Black Simple Lamp", R.drawable.product_image, 50),
        Product("Black Simple Lamp", R.drawable.product_image, 50),
    )
}

@Composable
fun ToolBarCP(
    leftIcon: Int = 0,
    rightIcon: Int = 0,
    simpleText: String = ""
) {
    val lIcon = if (leftIcon == 0) 0 else leftIcon
    val rIcon = if (rightIcon == 0) 0 else rightIcon
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        if (lIcon != 0) {
            Icon(painter = painterResource(id = lIcon), contentDescription = null)
        } else {
            Spacer(modifier = Modifier.size(25.dp))
        }
        if (simpleText == "") {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Make home",
                    style = TextStyle(
                        fontFamily = FontFamily(Font(AppConstant.FONT_GELASIO_REGULAR)),
                        fontWeight = FontWeight(400),
                        fontSize = 18.sp,
                        color = GreyColor,
                        lineHeight = 25.sp,
                        fontStyle = FontStyle.Normal
                    )
                )
                Text(text = "beautiful".uppercase(),
                    style = TextStyle(
                        fontFamily = FontFamily(Font(AppConstant.FONT_GELASIO_BOLD)),
                        fontWeight = FontWeight(700),
                        fontSize = 18.sp,
                        color = PrimaryColor,
                        lineHeight = 25.sp,
                        fontStyle = FontStyle.Normal
                    ))
            }
        } else if (simpleText == "null") {
            Spacer(modifier = Modifier.size(25.dp))
        } else {
            Text(
                text = simpleText,
                style = TextStyle(
                    fontFamily = FontFamily(Font(AppConstant.FONT_GELASIO_BOLD)),
                    fontWeight = FontWeight(700),
                    fontSize = 16.sp,
                    color = HomeBeautiColor

                )
            )
        }
        if (rIcon != 0) {
            Icon(painter = painterResource(id = rIcon), contentDescription = null)
        } else {
            Spacer(modifier = Modifier.size(25.dp))
        }
    }
}