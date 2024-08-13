package com.rogoz208.mobileupcoingecko.presentation.coins_list.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarWithChips(
    modifier: Modifier = Modifier,
    title: String,
    items: List<String>,
    defaultSelectedItemIndex: Int = 0,
    onSelectedChanged: (Int) -> Unit = {}
) {
    Column(modifier = modifier) {
        TopAppBar(
            title = {
                Text(
                    text = title,
                    fontWeight = FontWeight.Medium,
                    fontSize = 20.sp
                )
            },
        )
        FilterChipGroup(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .padding(top = 16.dp)
                .padding(bottom = 13.dp),
            items = items,
            defaultSelectedItemIndex = defaultSelectedItemIndex,
            onSelectedChanged = { itemIndex ->
                onSelectedChanged(itemIndex)
            }
        )
        HorizontalDivider()
    }
}