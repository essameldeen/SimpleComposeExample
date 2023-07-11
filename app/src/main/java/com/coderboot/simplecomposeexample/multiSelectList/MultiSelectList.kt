package com.coderboot.simplecomposeexample.multiSelectList

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MultiSelectItem(modifier: Modifier = Modifier) {

    var items by remember {
        mutableStateOf(
            (1..20).map {
                ListItem(
                    title = "Item $it",
                    isSelect = false,
                )
            }
        )
    }

    LazyColumn(modifier = modifier.fillMaxSize()) {
        items(items.size) { index ->
            Row(modifier = modifier
                .fillMaxWidth()
                .clickable {
                    items = items.mapIndexed { i, item ->
                        if (i == index) {
                            item.copy(isSelect = ! item.isSelect)
                        } else {
                            item
                        }
                    }
                }
                .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = items[index].title)
                if (items[index].isSelect) {
                    Icon(
                        imageVector = Icons.Default.Check, contentDescription = "check",
                        tint = Color.Green,
                        modifier = modifier.size(20.dp)
                    )
                }
            }
        }
    }
}