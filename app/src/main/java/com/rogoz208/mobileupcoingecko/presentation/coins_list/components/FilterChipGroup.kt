package com.rogoz208.mobileupcoingecko.presentation.coins_list.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.rogoz208.mobileupcoingecko.presentation.ui.theme.Gray10
import com.rogoz208.mobileupcoingecko.presentation.ui.theme.Orange10
import com.rogoz208.mobileupcoingecko.presentation.ui.theme.Orange70

@Composable
fun FilterChipGroup(
    modifier: Modifier = Modifier,
    items: List<String>,
    defaultSelectedItemIndex: Int = 0,
    onSelectedChanged: (Int) -> Unit = {}
) {

    var selectedItemIndex by remember { mutableIntStateOf(defaultSelectedItemIndex) }

    LazyRow(modifier = modifier) {
        items(items.size) { index ->
            FilterChip(
                modifier = Modifier
                    .padding(end = 8.dp)
                    .width(89.dp),
                selected = items[selectedItemIndex] == items[index],
                onClick = {
                    selectedItemIndex = index
                    onSelectedChanged(index)
                },
                label = {
                    Text(
                        text = items[index],
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                },
                shape = CircleShape,
                border = FilterChipDefaults.filterChipBorder(
                    enabled = true,
                    selected = items[selectedItemIndex] == items[index],
                    borderColor = Color.Transparent
                ),
                colors = FilterChipDefaults.filterChipColors(
                    containerColor = Gray10,
                    selectedContainerColor = Orange10,
                    selectedLabelColor = Orange70,
                    iconColor = Color.Red
                ),
            )
        }
    }
}