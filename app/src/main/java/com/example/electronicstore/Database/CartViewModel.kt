package com.example.electronicstore.Database

import androidx.lifecycle.ViewModel

class CartViewModel : ViewModel() {
    // This is where the product list is stored
    var productList: MutableList<Product> = mutableListOf()

    // Function to add products to the cart
    fun addProductToCart(product: Product) {
        productList.add(product)
    }
}
