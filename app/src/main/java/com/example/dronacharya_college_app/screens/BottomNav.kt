package com.example.dronacharya_college_app.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextMotion
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.dronacharya_college_app.R
import com.example.dronacharya_college_app.models.BottomNavItem
import com.example.dronacharya_college_app.models.NavItem
import com.example.dronacharya_college_app.navigation.Routes
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNav() {

    val bottomNavController = rememberNavController()

    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    var selectedItemIndex by rememberSaveable { mutableIntStateOf(0) }
    val list = listOf(
        NavItem(title = "Website", icon = R.drawable.internet),
        NavItem(title = "Notice", icon = R.drawable.reminders),
        NavItem(title = "Notes", icon = R.drawable.writing),
        NavItem(title = "Contact Us", icon = R.drawable.contactmail)
    )

    ModalNavigationDrawer(drawerState = drawerState, drawerContent = {
        ModalDrawerSheet {
            Image(
                modifier = Modifier.height(220.dp),
                contentScale = ContentScale.Crop,
                painter = painterResource(id = R.drawable.dronacharya_college_image),
                contentDescription = null
            )

            HorizontalDivider()
            Text(text = "")
            list.forEachIndexed { index, item ->
                NavigationDrawerItem(label = { Text(text = item.title) },
                    selected = index == selectedItemIndex,
                    onClick = {
                        Toast.makeText(context, item.title, Toast.LENGTH_SHORT).show()
                        selectedItemIndex = index
                        scope.launch {
                            drawerState.close()
                        }
                    },
                    icon = {
                        Icon(
                            painter = painterResource(id = item.icon),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                )
            }
        }
    },
        content = {
            Scaffold(
                topBar = {
                    TopAppBar(title = { Text(text = "Dronacharya College Of Engineering", style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.W500,
                        color = Color.Black,
                    )
                    ) },
                        navigationIcon = {
                            IconButton(onClick = {
                                scope.launch {
                                    drawerState.open()
                                }
                            }) {
                                Icon(
                                    imageVector = Icons.Rounded.Menu,
                                    contentDescription = null,
                                    tint = Color.Black,
                                )
                            }
                        })
                },

                bottomBar = {
                    BottomNavigationBar(navController = bottomNavController)
                }
            ) { padding ->
                NavHost(navController = bottomNavController,
                    startDestination = Routes.Home.route,
                    modifier = Modifier.padding(padding)
                ) {
                    composable(Routes.Home.route) {
                        Home()
                    }
                    composable(Routes.Gallery.route) {
                        Gallery()
                    }

                    composable(Routes.AboutUs.route) {
                        AboutUs()
                    }

                    composable(Routes.Faculty.route) {
                        Faculty()
                    }
                }
            }
        })
}

@Composable
fun BottomNavigationBar(navController: NavController){
    val backStackEntry = navController.currentBackStackEntryAsState()

    val bottomItem = listOf(
        BottomNavItem(
            title = "Home",
            icon = R.drawable.home,
            route = Routes.Home.route
        ),
        BottomNavItem(
            title = "Gallery",
            icon = R.drawable.gallery,
            route = Routes.Gallery.route
        ),
        BottomNavItem(
            title = "Faculty",
            icon = R.drawable.graduation,
            route = Routes.Faculty.route
        ),
        BottomNavItem(
            title = "About Us",
            icon = R.drawable.group,
            route = Routes.AboutUs.route
        )
    )

    BottomAppBar {
        bottomItem.forEach{
            val curRoute = it.route
            val otherRoute = try {
                backStackEntry.value!!.destination.route
            }catch (e:Exception){
                Routes.Home.route
            }
            val selected = curRoute == otherRoute

            NavigationBarItem(selected = selected,
                onClick = {
                          navController.navigate(it.route){
                              popUpTo(navController.graph.findStartDestination().id){
                                  saveState = true
                              }
                              launchSingleTop = true
                          }
                },
                label = {
                    Text(text = it.title)
                },
                icon = {
                Icon(painter = painterResource(id = it.icon), contentDescription = null ,modifier = Modifier.size(26.dp))
            })
        }
    }
}
@Preview(showBackground = true)
@Composable
fun Prev_BottomNav() {
    BottomNav()
}