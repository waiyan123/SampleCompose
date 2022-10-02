package com.example.cleanarchi.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cleanarchi.R
import com.example.cleanarchi.domain.model.ListItemVO
import com.example.cleanarchi.ui.theme.CleanArchiTheme

class NewComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CleanArchiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val listItems = listOf(
                        ListItemVO("image", "Linovo", true),
                        ListItemVO("image", "Dell", true),
                        ListItemVO("image", "Acer", false),
                        ListItemVO("image", "Asus", true),
                        ListItemVO("image", "Apple", false),
                        ListItemVO("image", "Microsoft", false),
                        ListItemVO("image", "MSI", true),
                        ListItemVO("image", "Samsung", false),
                        ListItemVO("image", "Razer", true),
                        ListItemVO("image", "Toshiba", true)
                    )

                    MyScaffold(listItems = listItems+listItems+listItems)
                }
            }
        }
    }
}

@Composable
fun MyScaffold(listItems: List<ListItemVO>) {
    Scaffold(
        bottomBar = {
            MyButtomBar()
        },
        topBar = {
            MyTopAppBar(listItems)
        }
    ) {
        Box(modifier = Modifier.padding(it)) {
            ItemsList(listItems = listItems)
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ItemsList(listItems: List<ListItemVO>) {
    val grouped = listItems.groupBy { it.name.first() }
    val listState = rememberLazyListState()
    LazyColumn(
        state = listState,
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        grouped.forEach { (t, u) ->
            stickyHeader {
                StickHeader(t)
            }
            items(u) {
                ListItem(it)
            }
        }
    }

    val showButton by remember {
        derivedStateOf {
            listState.firstVisibleItemIndex > (listItems.size - 14)
        }
    }
    AnimatedVisibility(visible = showButton, enter = fadeIn(), exit = fadeOut()) {
        ActionButton()
    }
}

@Composable
fun ActionButton() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.Bottom
    ) {
        Button(
            onClick = { /*TODO*/ }
        ) {
            Text(text = "Scroll up")
        }
    }
}

@Composable
fun StickHeader(firstLetter: Char = 'A') {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.LightGray)
    ) {
        Text(
            text = firstLetter.toString(),
            modifier = Modifier.padding(
                PaddingValues(start = 10.dp, top = 5.dp)
            )
        )
    }
}

@Composable
fun ListItem(item: ListItemVO = ListItemVO()) {

    var checked by remember {
        mutableStateOf(false)
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                checked = !checked
            }
            .border(width = 1.dp, color = Color.Green)
            .padding(10.dp),

        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            modifier = Modifier
                .width(30.dp)
                .height(30.dp),
            painter = painterResource(id = R.drawable.ic_baseline_account_circle_24),
            contentDescription = "",
            contentScale = ContentScale.Crop
        )
        Text(text = item.name)
        Checkbox(
            modifier = Modifier.size(ButtonDefaults.IconSize),
            checked = checked,
            onCheckedChange = {
                checked = it
            }
        )
    }
}

@Composable
fun ButtonList(list: List<ListItemVO>) {
    LazyRow(
        modifier = Modifier.padding(10.dp),
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        items(list) { item ->
            ListItemButton(item)
        }
    }
}

@Composable
fun ListItemButton(item: ListItemVO = ListItemVO()) {
    Button(
        onClick = { /*TODO*/ },
        shape = RoundedCornerShape(50),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red)
    ) {
        Icon(
            Icons.Default.Face,
            contentDescription = "Description",
            modifier = Modifier.size(ButtonDefaults.IconSize)
        )
        Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
        Text(
            text = item.name,
            style = MaterialTheme.typography.body2
        )
    }
}

@Composable
fun MyTopAppBar(list: List<ListItemVO>) {
    TopAppBar() {
        ButtonList(list = list)
    }
}

@Composable
fun MyButtomBar() {
    BottomAppBar {
        BottomNavigation() {
            BottomNavigationItem(icon = {
                Icon(
                    Icons.Default.AccountBox,
                    "Description"
                )
            },
                selected = true, onClick = { /*TODO*/ })
            BottomNavigationItem(icon = {
                Icon(
                    Icons.Default.Favorite,
                    "Description"
                )
            },
                selected = false, onClick = { /*TODO*/ })
            BottomNavigationItem(icon = {
                Icon(
                    Icons.Default.Build,
                    "Description"
                )
            },
                selected = true, onClick = { /*TODO*/ })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
//    ListItem(ListItemVO())
//    StickHeader()
//    ActionButton()
//    MyButtonBar()
    ListItemButton(item = ListItemVO())
}