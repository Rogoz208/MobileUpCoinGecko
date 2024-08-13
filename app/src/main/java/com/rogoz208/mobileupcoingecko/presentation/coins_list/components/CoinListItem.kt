package com.rogoz208.mobileupcoingecko.presentation.coins_list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.rogoz208.mobileupcoingecko.data.remote.dto.Currency
import com.rogoz208.mobileupcoingecko.domain.model.Coin
import java.util.Locale
import kotlin.math.abs

@Composable
fun CoinListItem(
    coin: Coin,
    currency: Currency,
    onItemClick: (Coin) -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .clickable { onItemClick(coin) }
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            AsyncImage(
                model = coin.image,
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.size(8.dp))
            Column {
                Text(
                    text = coin.name,
                    fontSize = 16.sp,
                    fontWeight = FontWeight(500),
                    color = Color(0xFF525252)
                )
                Text(
                    text = coin.symbol.uppercase(Locale.getDefault()),
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF9B9B9B)
                )
            }
        }
        Column(horizontalAlignment = Alignment.End) {
            Text(
                text = when (currency) {
                    Currency.USD -> "$ ${coin.currentPrice}"
                    Currency.RUB -> "₽ ${coin.currentPrice}"
                },
                fontSize = 16.sp,
                fontWeight = FontWeight(600),
                color = Color(0xFF525252)
            )
            Text(
                text = if (coin.priceChangePercentage24h < 0) {
                    "- ${abs(coin.priceChangePercentage24h)}%"
                } else {
                    "+ ${coin.priceChangePercentage24h}%"
                },
                fontSize = 14.sp,
                fontWeight = FontWeight(400),
                color = if (coin.priceChangePercentage24h < 0) {
                    Color(0xFFEB5757)
                } else {
                    Color(0xFF2A9D8F)
                }
            )
        }
    }
}