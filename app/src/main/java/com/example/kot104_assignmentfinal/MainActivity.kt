package com.example.kot104_assignmentfinal

import android.annotation.SuppressLint
import android.os.Bundle
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
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kot104_assignmentfinal.screen.CartScreen
import com.example.kot104_assignmentfinal.screen.DetailsScreen
import com.example.kot104_assignmentfinal.screen.HomeScreen
import com.example.kot104_assignmentfinal.screen.LoginScreen
import com.example.kot104_assignmentfinal.screen.RegisterScreen
import com.example.kot104_assignmentfinal.screen.SlashScreen
import com.example.kot104_assignmentfinal.ui.theme.KOT104_AssignmentFinalTheme
import com.example.kot104_assignmentfinal.ui.theme.WhiteColor

data class TabBarItem(
    val title: String,
    val selectedIcon: Int,
    val unselectedIcon: Int,
)

data class UserInfo(
    val name: String,
    val email: String,
    val phone: String,
    val address: String,
)

data class CartItem(
    val name: String,
    val price: String,
    val image: Int,
    val quantity: Int,
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KOT104_AssignmentFinalTheme {
                Container()
            }
        }
    }
}

@Composable
fun Container() {
    val loginScreen = LoginScreen()
    val homeScreen = HomeScreen()
    val slashScreen = SlashScreen()
    val registerScreen = RegisterScreen()
    val cartScreen = CartScreen()
    val detailsScreen = DetailsScreen()

    val navController = rememberNavController()
    fun goTo(screen: String) {
        navController.navigate(screen)
    }

    NavHost(navController = navController, startDestination = "loginScreen") {
        composable("slashScreen") {
            slashScreen.Container(
                goTo = { goTo(it) }
            )
        }
        composable("loginScreen") {
            loginScreen.Container(
                goTo = { goTo(it) },
            )
        }
        composable("registerScreen") {
            registerScreen.Container(
                goTo = { goTo(it) }
            )
        }
        composable("TabView") {
            MainTabs()
        }
        composable("cartScreen") {
            cartScreen.Container()
        }
        composable("detailsScreen") {
            detailsScreen.Container()
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainTabs() {
    // setting up the individual tabs
    val homeTab = TabBarItem(
        title = "Home",
        selectedIcon = R.drawable.home_selected,
        unselectedIcon = R.drawable.home
    )
    val alertsTab = TabBarItem(
        title = "Alerts",
        selectedIcon = R.drawable.bell_selected,
        unselectedIcon = R.drawable.bell
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
                homeScreen.Container()
            }
            composable(alertsTab.title) {
                Text(alertsTab.title)
            }
            composable(settingsTab.title) {
                Text(settingsTab.title)
            }
            composable(moreTab.title) {
                Text(text = "Hello")
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
