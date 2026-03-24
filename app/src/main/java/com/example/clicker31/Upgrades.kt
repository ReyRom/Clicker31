package com.example.clicker31

import kotlin.math.pow

sealed class UpgradeType(val title: String){
    object ClickMultiplier: UpgradeType("Множитель")
    object AutoClick: UpgradeType("Автоклик")
    object OfflineIncome: UpgradeType("Оффлайн доход")
}

data class Upgrade(
    val type: UpgradeType,
    val level: Int = 0,
    val initialValue: Double,
    val baseValue: Double,
    val valueMultiplier: Double,
    val baseCost: Double,
    val costMultiplier: Double
){
    fun currentCost(): Double{
        return baseCost * costMultiplier.pow(level)
    }
    fun currentValue(): Double{
        return initialValue + baseValue * valueMultiplier.pow(level)
    }
    fun next(): Upgrade{
        return copy(level=level+1)
    }
}