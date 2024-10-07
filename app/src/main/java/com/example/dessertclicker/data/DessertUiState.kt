package com.example.dessertclicker.data

import androidx.annotation.DrawableRes
import com.example.dessertclicker.data.Datasource.dessertList

data class DessertUiState(
    val currentDessertIndex: Int = 0,
    val dessertsSold: Int = 0,
    val revenue: Int = 0
) {
    val currentDessertPrice: Int
        get() = dessertList[currentDessertIndex].price

    @get:DrawableRes
    val currentDessertImageId: Int
        get() = dessertList[currentDessertIndex].imageId
}
