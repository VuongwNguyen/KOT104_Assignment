package com.example.kot104_assignmentfinal

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.kot104_assignmentfinal.httpModel.Product
import com.example.kot104_assignmentfinal.screen.CartScreen
import com.example.kot104_assignmentfinal.screen.DetailsScreen
import com.example.kot104_assignmentfinal.screen.HomeScreen
import com.example.kot104_assignmentfinal.screen.LoginScreen
import com.example.kot104_assignmentfinal.screen.RegisterScreen
import com.example.kot104_assignmentfinal.screen.SlashScreen
import com.example.kot104_assignmentfinal.ui.theme.KOT104_AssignmentFinalTheme
import com.example.kot104_assignmentfinal.ui.theme.WhiteColor
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

data class TabBarItem(
    val title: String,
    val selectedIcon: Int,
    val unselectedIcon: Int,
)

data class CartItem(
    val product: Product, var quantity: Int
)

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KOT104_AssignmentFinalTheme {
                val navController = rememberNavController()
                fun goTo(screen: String) {
                    navController.navigate(screen)
                }


                Container(navController = navController,
                    goTo = { goTo(it) },
                    saveCart = { cartItem -> saveCart(cartItem, this) },
                    addToCart = { product -> addToCart(product, this) },
                    getCart = { getCart(this) })
            }
        }
    }
}

// hàm xử lý việc tăng, giảm số lượng sản phẩm trong giỏ hàng
fun changeQuantity(product: Product, context: Context, type: String = "") {
    val cart = getCart(context)
    val newCart = cart.toMutableList()
    val existingProduct = newCart.find { it.product._id == product._id }
    if (existingProduct != null) {
        if (type == "increase") {
            existingProduct.quantity += 1
        } else {
            existingProduct.quantity -= 1
            if (existingProduct.quantity == 0) {
                newCart.remove(existingProduct)
            }
        }
    }
    saveCart(newCart, context)
}

fun addToCart(product: Product, context: Context) {
    val cart = getCart(context)
    val newCart = cart.toMutableList()
    val existingProduct = newCart.find { it.product._id == product._id }
    if (existingProduct != null) {
        existingProduct.quantity += 1
    } else {
        newCart.add(CartItem(product, 1))
    }
    Toast.makeText(
        context, "Added ${product.name.replace("+", " ")} to cart ", Toast.LENGTH_SHORT
    ).show()
    saveCart(newCart, context)
}

fun saveCart(cartItem: List<CartItem>, context: Context) {
    val sharedPreferences = context.getSharedPreferences("cart", Context.MODE_PRIVATE)
    val editor = sharedPreferences.edit()
    val cartJson = Gson().toJson(cartItem)
    editor.putString("cart", cartJson)
    editor.apply()
}

fun getCart(context: Context): List<CartItem> {
    val sharedPreferences = context.getSharedPreferences("cart", Context.MODE_PRIVATE)
    val cartJson = sharedPreferences.getString("cart", "[]")
    val cartType = object : TypeToken<List<CartItem>>() {}.type
    return Gson().fromJson(cartJson, cartType)
}


@Composable
fun Container(
    navController: NavHostController,
    goTo: (String) -> Unit,
    addToCart: (Product) -> Unit,
    getCart: (Context) -> List<CartItem>,
    saveCart : (List<CartItem>) -> Unit
) {
    val loginScreen = LoginScreen()
    val slashScreen = SlashScreen()
    val registerScreen = RegisterScreen()
    val cartScreen = CartScreen()
    val detailsScreen = DetailsScreen()

    val ctxt = LocalContext.current

    NavHost(navController = navController, startDestination = "slashScreen"){
        composable("slashScreen") {
            slashScreen.Container(goTo = { goTo(it) })
        }
        composable("loginScreen") {
            loginScreen.Container(goTo = { goTo(it) })
        }
        composable("registerScreen") {
            registerScreen.Container(goTo = { goTo(it) })
        }
        composable("TabView") {
            MainTabs(goTo = { goTo(it) })
        }
        composable("cartScreen") {
            cartScreen.Container(
                getCart = { getCart(ctxt) },
//                changeQuantity = { product, type -> changeQuantity(product, ctxt, type)},
                saveCart = { saveCart(it) },
                goTo = { goTo(it) }
            )
        }
        composable(
            "detailsScreen/{product}",
            arguments = listOf(navArgument("product") { type = NavType.StringType })
        ) { backStackEntry ->
            val jsonString = backStackEntry.arguments?.getString("product")
            val productType = object : TypeToken<Product>() {}.type
            val product = Gson().fromJson<Product>(jsonString, productType)
            detailsScreen.Container(product = product,
                goTo = { goTo(it) },
                addToCart = { addToCart(it) })
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainTabs(
    goTo: (String) -> Unit
) {
    // setting up the individual tabs
    val homeTab = TabBarItem(
        title = "Home", selectedIcon = R.drawable.home_selected, unselectedIcon = R.drawable.home
    )
    val alertsTab = TabBarItem(
        title = "Alerts", selectedIcon = R.drawable.bell_selected, unselectedIcon = R.drawable.bell
    )
    val settingsTab = TabBarItem(
        title = "Settings",
        selectedIcon = R.drawable.marker_selected,
        unselectedIcon = R.drawable.marker
    )
    val moreTab = TabBarItem(
        title = "More",
        selectedIcon = R.drawable.person_selected,
        unselectedIcon = R.drawable.person
    )
    // creating a list of all the tabs
    val tabBarItems = listOf(homeTab, alertsTab, settingsTab, moreTab)
    // creating our navController
    val navController = rememberNavController()
    Scaffold(bottomBar = { TabView(tabBarItems, navController) }) {
        NavHost(navController = navController, startDestination = homeTab.title) {
            val homeScreen = HomeScreen()
            composable(homeTab.title) {
                homeScreen.Container(goTo = { goTo(it) })
            }
            composable(alertsTab.title) {
                Text(alertsTab.title)
            }
            composable(settingsTab.title) {
                Text(settingsTab.title)
            }
            composable(moreTab.title) {
                Text(moreTab.title)
            }
        }
    }
}

@Composable
fun TabView(tabBarItems: List<TabBarItem>, navController: NavController) {
    var selectedTabIndex by rememberSaveable {
        mutableIntStateOf(0)
    }
    NavigationBar(
        containerColor = WhiteColor,
    ) {
        tabBarItems.forEachIndexed { index, tabBarItem ->
            NavigationBarItem(
                selected = selectedTabIndex == index,
                onClick = {
                    selectedTabIndex = index
                    navController.navigate(tabBarItem.title)
                },
                icon = {
                    TabBarIconView(
                        isSelected = selectedTabIndex == index,
                        selectedIcon = tabBarItem.selectedIcon,
                        unselectedIcon = tabBarItem.unselectedIcon,
                        title = tabBarItem.title,
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    unselectedTextColor = WhiteColor,
                    selectedTextColor = WhiteColor,
                    unselectedIconColor = WhiteColor,
                    selectedIconColor = WhiteColor,
                ),
            )
        }
    }
}

@Composable
fun TabBarIconView(
    isSelected: Boolean,
    selectedIcon: Int,
    unselectedIcon: Int,
    title: String = "",
) {
    Image(
        painter = painterResource(id = if (isSelected) selectedIcon else unselectedIcon),
//        modifier = Modifier
//            .width(24.dp)
//            .height(24.dp),
        contentDescription = title
    )
}
