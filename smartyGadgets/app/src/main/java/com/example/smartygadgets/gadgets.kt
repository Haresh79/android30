package com.example.smartygadgets

data class gadgets(
    val limit: Int,
    val products: List<Product>,
    val skip: Int,
    val total: Int
)