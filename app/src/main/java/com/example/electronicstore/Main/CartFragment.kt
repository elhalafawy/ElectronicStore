package com.example.electronicstore.Main

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.electronicstore.Database.CartAdapter
import com.example.electronicstore.Database.Product
import com.example.electronicstore.Database.CartViewModel
import com.example.electronicstore.R

class CartFragment : Fragment() {

    private lateinit var cartViewModel: CartViewModel // ViewModel to hold product list

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cart, container, false)
    }

    // This is called after the view has been created
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize the RecyclerView and ViewModel
        val recyclerView = view.findViewById<RecyclerView>(R.id.itemRecycleView)
        recyclerView.layoutManager = LinearLayoutManager(context)

        // Retrieve the ViewModel
        cartViewModel = ViewModelProvider(this).get(CartViewModel::class.java)

        // Check if there are already products in the ViewModel
        val productList = cartViewModel.productList

        // If no data exists in the ViewModel, add a default product
        if (productList.isEmpty()) {
            val productNames = arguments?.getString("name1") ?: "Unknown"
            val productPrices = arguments?.getInt("price1") ?: 0
            val productImages = arguments?.getInt("imageUrl1") ?: 0

            // Create and add the product to the list
            val product = Product(
                name = productNames,
                price = productPrices,
                imageUrl = productImages,
                description = "" // Optional description
            )
            cartViewModel.addProductToCart(product)
        }

        // Set up the adapter with the product list from the ViewModel
        val adapter = CartAdapter(cartViewModel.productList)
        recyclerView.adapter = adapter
    }

    // Function to add more products dynamically
    fun addProductToCart(product: Product) {
        cartViewModel.addProductToCart(product)
        // Notify the adapter that the data has changed
        view?.findViewById<RecyclerView>(R.id.itemRecycleView)?.adapter?.notifyDataSetChanged()
    }
}
