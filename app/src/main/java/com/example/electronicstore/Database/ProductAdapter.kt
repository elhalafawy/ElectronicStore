package com.example.electronicstore.Database

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.electronicstore.R

class ProductAdapter(private val productList: List<Product>) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val productImage: ImageView = itemView.findViewById(R.id.productImageView)
        val productName: TextView = itemView.findViewById(R.id.productNameTextView)
        val productPrice: TextView = itemView.findViewById(R.id.productPriceTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.product_item, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]
        holder.productImage.setImageResource(product.imageUrl)
        holder.productName.text = product.name
        holder.productPrice.text = "$${product.price}"
    }

    override fun getItemCount() = productList.size
}
