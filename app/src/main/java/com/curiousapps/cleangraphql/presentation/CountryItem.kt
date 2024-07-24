package com.curiousapps.cleangraphql.presentation

import android.graphics.Paint.Style
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.curiousapps.cleangraphql.domain.DetailedCountry
import com.curiousapps.cleangraphql.domain.ListCountries

@Composable
fun CountryItem(
    country: ListCountries,
    modifier: Modifier = Modifier,
){
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = country.emoji,
            fontSize = 56.sp
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column(
            modifier = Modifier.weight(1F)
        ) {
            Text(
                text = country.name,
                fontSize = 24.sp,
            )
            Spacer(
                modifier = Modifier.height(4.dp)
            )
            Text(
                text = country.capital,
                fontSize = 20.sp,
                fontStyle = FontStyle.Italic
            )
        }
    }

}