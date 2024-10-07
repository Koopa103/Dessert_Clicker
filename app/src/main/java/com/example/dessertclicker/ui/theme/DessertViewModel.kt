package com.example.dessertclicker.ui

import androidx.lifecycle.ViewModel
import com.example.dessertclicker.data.DessertUiState
import com.example.dessertclicker.data.Datasource.dessertList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DessertViewModel : ViewModel() {

    private val _dessertUiState = MutableStateFlow(DessertUiState())
    val dessertUiState: StateFlow<DessertUiState> = _dessertUiState.asStateFlow()

    fun onDessertClicked() {
        _dessertUiState.update { currentState ->
            val dessertsSold = currentState.dessertsSold + 1
            val nextDessertIndex = determineDessertIndex(dessertsSold)
            currentState.copy(
                dessertsSold = dessertsSold,
                revenue = currentState.revenue + currentState.currentDessertPrice,
                currentDessertIndex = nextDessertIndex
            )
        }
    }

    private fun determineDessertIndex(dessertsSold: Int): Int {
        return dessertList.indexOfLast { dessertsSold >= it.startProductionAmount }
            .coerceAtLeast(0) // Ensure the index is not negative
    }
}
