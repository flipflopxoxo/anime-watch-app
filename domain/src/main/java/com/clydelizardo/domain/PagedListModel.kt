package com.clydelizardo.domain

data class PagedListModel<T>(
    val pageNumber: Int,
    val hasNext: Boolean,
    val content: List<T>,
)