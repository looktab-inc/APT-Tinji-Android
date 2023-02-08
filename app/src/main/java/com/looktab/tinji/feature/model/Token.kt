package com.looktab.tinji.feature.model

import kotlin.math.roundToInt

data class Token(
    val name: String,
    val icon: String,
    val token: Double,
    val tokenWord: String,
    val dollar: Double,
    val dollarGap: Double,
) {
    fun getTokenHolding(): String {
        return tokenWord;
//        if (dollar > 1) {
//            return "${(token * 10000.0).roundToInt() / 10000.0} $tokenWord"
//        } else {
//            return "${token.roundToInt()} $tokenWord"
//        }
    }

    fun getHoldingDollarStr(): String {
        return "$${(token * dollar * 100.0).roundToInt() / 100.0}"
    }

    fun getHoldingDollar(): Double {
        return ((token * dollar * 100.0).roundToInt() / 100.0)
    }

    fun getHoldingDollarGap(): String {
//        return if (dollarGap < 0) {
//            "-${(token * dollarGap * dollar * 100.0).roundToInt() / -100.0}APT"
//        } else if (dollarGap > 0) {
//            "+${(token * dollarGap * dollar * 100.0).roundToInt() / 100.0}APT"
//        } else {
//            ""
//        }
        return if (dollarGap < 0) {
            "-${dollarGap}APT"
        } else if (dollarGap > 0) {
            "+${dollarGap}APT"
        } else {
            ""
        }
    }
}