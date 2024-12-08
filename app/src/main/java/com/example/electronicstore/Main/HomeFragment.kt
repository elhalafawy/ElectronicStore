package com.example.electronicstore.Main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.electronicstore.Database.ProductAdapter
import com.example.electronicstore.Database.Product
import com.example.electronicstore.R

class HomeFragment : Fragment() {

    private val products = listOf(
        Product(
            "Iphone 13 Pro Max",
            1100,
            R.drawable.phone1,
            "iPhone 13 Pro Max 128GB Sierra Blue 5G With Facetime - International Specs."
        ),
        Product(
            "Huawei Mate 40 Pro",
            1000,
            R.drawable.phone2,
            "HUAWEI Mate 40 Pro, 6.7-inch OLED Display, 50MP Ultra Aperture XMAGE Camera, IP68, 4700mAh Battery, Durable Kunlun Glass, 8GB+512GB."
        ),
        Product(
            "Iphone 14 Pro Max",
            900,
            R.drawable.phone3,
            "iPhone 14 Pro Max 1TB purple 5G With FaceTime - Middle East Version."
        ),
        Product(
            "Redmi",
            800,
            R.drawable.phone4,
            "Redmi Note 13 Pro+ 5G Dual SIM Mystic Silver 12GB RAM 512GB 5G Limited Edition - Global Version."
        ),
        Product(
            "Samsung Watch 5",
            400,
            R.drawable.watch1,
            "Galaxy Watch 5 44mm Graphite."
        ),
        Product(
            "Samsung Watch 4",
            300,
            R.drawable.watch2,
            "Galaxy Watch 4 Classic 46 mm Black."
        ),
        Product(
            "Apple Watch 9",
            800,
            R.drawable.watch3,
            "Watch Series 9 GPS 45mm Midnight Aluminium Case With orange Sport Band."
        ),
        Product(
            "Women Smart Watch",
            300,
            R.drawable.watch4,
            "Queen Smart Watch For Women With AMOLED Always On Display Bluetooth Calling Waterproof Fitness Watches."
        ),
        Product(
            "MSI Laptop",
            1900,
            R.drawable.laptop1,
            "Cyborg 15 A13VE Gaming Laptop With 15.6-Inch Display, Core i7-13620H Processor/16GB RAM/1TB SSD6GB NVIDIA RTX 4050 Graphics Card/Windows 11 Home English Black."
        ),
        Product(
            "ASUS Laptop",
            1500,
            R.drawable.laptop2,
            "ASUS Laptop With 17-Inch FHD Display, AMD Ryzen 7-8840HS Processor/16GB RAM/1TB SSD/Intel Iris XE Graphics/Windows 11 Jade Black."
        ),
        Product(
            "MacBook PRO",
            2000,
            R.drawable.laptop3,
            "MacBook Pro MNEJ3 13-Inch Display: Apple M2 chip with 8-core CPU and 10-core GPU, 512GB SSD, Space Grey."
        ),
        Product(
            "MacBook Air",
            1400,
            R.drawable.laptop4,
            "MacBook Air MGN63 13\" Display, Apple M1 Chip With 8-Core Processor and 7-Core Graphics / 8GB RAM / 256GB SSD."
        )
    )


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // Setup RecyclerView
        val recyclerView = view.findViewById<RecyclerView>(R.id.productRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = ProductAdapter(products)

        return view
    }
}
