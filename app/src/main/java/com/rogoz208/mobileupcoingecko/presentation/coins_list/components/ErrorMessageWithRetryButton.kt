package com.rogoz208.mobileupcoingecko.presentation.coins_list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rogoz208.mobileupcoingecko.R

@Composable
fun ErrorMessageWithRetryButton(
    modifier: Modifier = Modifier,
    message: String,
    buttonLabel: String,
    onRetryButtonClicked: () -> Unit = {}
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = R.drawable.bitcoin_logo),
            contentDescription = "",
            Modifier
                .size(120.dp)
                .padding(bottom = 13.dp)
        )
        Text(
            text = message,
            fontSize = 16.sp

        )
        Button(modifier = Modifier.padding(top = 30.dp), onClick = { onRetryButtonClicked() }) {
            Text(text = buttonLabel)
        }
    }
}
