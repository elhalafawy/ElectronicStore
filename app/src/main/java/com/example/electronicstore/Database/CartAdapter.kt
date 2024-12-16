package com.example.electronicstore.Database

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.electronicstore.R

// Modify the constructor to accept a list of products
class CartAdapter(
    private val productList: List<Product> // Accept a list of products
) : RecyclerView.Adapter<CartAdapter.ProductViewHolder>() {

    // ViewHolder to hold references to the views
    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val productImageView: ImageView = itemView.findViewById(R.id.cartItemImage)
        val productNameView: TextView = itemView.findViewById(R.id.cartItemName)
        val productPriceView: TextView = itemView.findViewById(R.id.cartItemPrice)
    }

    // Create new ViewHolder for each item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_cart, parent, false)
        return ProductViewHolder(view)
    }

    // Bind data to the ViewHolder for each item in the list
    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position] // Get the product at the given position
        holder.productImageView.setImageResource(product.imageUrl)
        holder.productNameView.text = product.name
        holder.productPriceView.text = "$${product.price}"
    }

    // Return the size of the list (number of products)
    override fun getItemCount(): Int = productList.size
}
