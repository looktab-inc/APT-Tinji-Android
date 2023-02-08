package com.looktab.tinji.feature.model

data class History(
    val date: String,
    val icon: String,
    val name: String,
    val transactionValue: String,
    val isReview: Boolean,
    val subtitle: String,
) {
    fun getDateVisible(): Boolean {
        return date.isNotEmpty()
    }

    fun getReviewWriteComplete(): Boolean {
        return (isReview && subtitle.isNotEmpty())
    }

    fun getReviewWriteReady(): Boolean {
        return (isReview && subtitle.isEmpty())
    }
}
