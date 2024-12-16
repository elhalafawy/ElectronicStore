package com.example.electronicstore.Main


import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.electronicstore.Database.Product
import com.example.electronicstore.R
import android.os.Parcel

class ObjectDetailsFragment : Fragment() {

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_object_details, container, false)

        // UI references
        val productName = view.findViewById<TextView>(R.id.name)
        val productPrice = view.findViewById<TextView>(R.id.price)
        val productDescription = view.findViewById<TextView>(R.id.description)
        val productImage = view.findViewById<ImageView>(R.id.image)
        val addToCartButton = view.findViewById<Button>(R.id.cartButton)

        // Retrieve data from arguments
        val name = arguments?.getString("name") ?: "Unknown"
        val price = arguments?.getInt("price") ?: 0
        val description = arguments?.getString("description") ?: "No description available"
        val imageUrl = arguments?.getInt("imageUrl") ?: 0

        // Display data in the UI
        productName.text = name
        productPrice.text = "$$price"
        productDescription.text = description

        // Set image only if the resource is valid
        if (imageUrl != 0) {
            productImage.setImageResource(imageUrl)
        } else {
            productImage.visibility = View.GONE
        }

        // Add product to cart and navigate to CartFragment
        addToCartButton.setOnClickListener {
            // Create a bundle with product data
            val bundle = Bundle().apply {
                putString("name1", name)
                putInt("price1", price)
                putInt("imageUrl1", imageUrl)
            }

            // Create a new instance of CartFragment and attach the bundle
            val cartFragment = CartFragment().apply {
                arguments = bundle
            }

            // Replace the current fragment with CartFragment
                  parentFragmentManager.beginTransaction()
                .replace(R.id.container, cartFragment) // Replace container with the correct ID
                .addToBackStack(null) // Add transaction to back stack for back navigation
                .commit()
        }


        return view
    }
}




