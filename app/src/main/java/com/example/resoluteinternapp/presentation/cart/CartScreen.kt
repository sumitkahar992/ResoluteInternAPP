package com.example.resoluteinternapp.presentation.cart

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.resoluteinternapp.R
import com.example.resoluteinternapp.domain.local.getAllTea
import com.example.resoluteinternapp.domain.model.Tea
import com.example.resoluteinternapp.presentation.home.TeaIcon
import com.example.resoluteinternapp.presentation.navigation.top.TopBarDefault
import com.example.resoluteinternapp.presentation.viewmodel.homescreen.HomeScreenViewModel


@Composable
fun CartScreen(
    navController: NavController,
    viewModel: HomeScreenViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState
    var dialogueState by remember { mutableStateOf(false) }


    Scaffold(
        topBar = {
            TopBarDefault(
                title = "",
                icon = Icons.Filled.Menu,
                onClick = {}
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
        ) {

            Text(
                text = "Shopping Cart",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Text(
                text = "3 items in cart Cart",
                fontSize = 12.sp,
                color = Color.Gray
            )



            CartItemsList(
                tasks = uiState.tasks,
                onClickTask = { },
                onClickDelete = { task ->

                    dialogueState = true
                    viewModel.onSetTaskDeleted(task)

                }
            )

        }
        if (dialogueState) {
            MyTaskAlertDialog(
                title = "Delete Task",
                textDescription = "Do You Really Want to Delete This Task ?..",
                onConfirmClick = {
                    viewModel.onDeleteTask()
                    dialogueState = false
                },
                onDismissClick = {
                    dialogueState = false
                }
            )
        }
    }


}

@Composable
fun CartItemsList(
    tasks: List<Tea>,
    onClickTask: (Tea) -> Unit,
    onClickDelete: (Tea) -> Unit
) {

    LazyColumn {

        items(getAllTea()) { task ->

            CartItems(
                tasks = task,
                onClickTask = { onClickTask(task) },
                onClickDelete = { onClickDelete(task) }
            )

        }

    }

}


@Composable
fun CartItems(
    tasks: Tea,
    onClickTask: () -> Unit,
    onClickDelete: () -> Unit
) {
    var menuExpandedState by remember { mutableStateOf(false) }

    Log.d("TAG", "CartScreen: ${tasks.title} ")

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clickable { onClickDelete() },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        TeaIcon(tea = tasks)


        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            Text(
                text = tasks.title,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xB9000000)
            )

            Spacer(modifier = Modifier.height(18.dp))

            Text(
                text = "$  ${tasks.cost}",
                fontSize = 25.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color(0xB90E5806)
            )
        }

        IconButton(onClick = {}) {
            Icon(
                painter = painterResource(id = R.drawable.ic_add),
                contentDescription = ""
            )
        }

        Text(
            text = tasks.itemCount.toString(),
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xB9000000)
        )

        IconButton(onClick = {}) {
            Icon(
                painter = painterResource(id = R.drawable.ic_remove),
                contentDescription = ""
            )
        }

        Box(modifier = Modifier.wrapContentSize()) {
            MyTaskIcon(
                imageVector = Icons.Filled.MoreVert,
                onClick = {
                    menuExpandedState = true
                },
                modifier = Modifier.wrapContentSize()
            )
            TaskCardDropDownMenu(
                onActionClicked = { actionSelected ->
                    when (actionSelected) {
                        TaskCardAction.Edit -> onClickTask()
                        TaskCardAction.Delete -> onClickDelete()
                    }
                },
                menuExpandedState = menuExpandedState,
                menuExpandedStateChange = { menuExpandedState = false }
            )


        }

    }


}

@Composable
fun TaskCardDropDownMenu(
    onActionClicked: (TaskCardAction) -> Unit,
    menuExpandedState: Boolean,
    menuExpandedStateChange: () -> Unit
) {
    val actionOptionsLabels = listOf("Edit", "Delete")

    val actionOptions = listOf(
        TaskCardAction.Edit,
        TaskCardAction.Delete
    )

    MyTaskDropDownMenu(
        items = actionOptionsLabels,
        onItemIndexChange = { indexOptionSelected ->
            onActionClicked(actionOptions[indexOptionSelected])
        },
        expandedState = menuExpandedState,
        onExpandedStateChange = menuExpandedStateChange
    )


}

@Composable
fun MyTaskDropDownMenu(
    items: List<String>,
    onItemIndexChange: (Int) -> Unit,
    expandedState: Boolean,
    onExpandedStateChange: () -> Unit,
    modifier: Modifier = Modifier
) {
    DropdownMenu(
        expanded = expandedState,
        onDismissRequest = { onExpandedStateChange() },
        modifier = modifier
    ) {
        items.forEachIndexed { index, label ->
            DropdownMenuItem(
                onClick = {
                    onItemIndexChange(index)
                    onExpandedStateChange()
                },
                content = {
                    Text(text = label)
                }
            )
        }
    }
}

@Composable
fun MyTaskIcon(
    modifier: Modifier = Modifier,
    imageVector: ImageVector,
    contentDescription: String? = null,
    onClick: () -> Unit = {}
) {
    IconButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Icon(
            imageVector = imageVector,
            contentDescription = contentDescription,
            tint = MaterialTheme.colors.onPrimary,
        )
    }


}

@Composable
fun MyTaskAlertDialog(
    title: String,
    textDescription: String,
    onConfirmClick: () -> Unit,
    onDismissClick: () -> Unit
) {

    AlertDialog(
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.h5,
                color = MaterialTheme.colors.onBackground
            )
        },
        text = {
            Text(
                text = textDescription,
                style = MaterialTheme.typography.body2,
                color = MaterialTheme.colors.onBackground.copy(alpha = 0.5f)
            )
        },
        confirmButton = {
            TextButton(onClick = onConfirmClick) {
                Text(
                    text = "yes".uppercase(),
                    color = MaterialTheme.colors.secondary
                )
            }
        },
        dismissButton = {
            TextButton(onClick = onDismissClick) {
                Text(
                    text = "No".uppercase(),
                    color = MaterialTheme.colors.secondary
                )
            }
        },
        onDismissRequest = onDismissClick

    )


}
