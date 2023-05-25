package com.example.meatdeliveryapp.recyclerProduct

import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.meatdeliveryapp.*
import com.example.meatdeliveryapp.databinding.ItemProductBinding

class AdapterProduct(private val productList: List<Product>, private val listener: OnProductClickListener) : RecyclerView.Adapter<AdapterProduct.ViewHolder>() {


    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView){
        private val binding = ItemProductBinding.bind(itemView)
        val buttonAddToCartItem: Button = binding.buttonAddToCartItem
        val buttonDeleteItem: ImageButton = binding.buttonDeleteItem
        val buttonAddItem: ImageButton = binding.buttonAddItem
        val textViewQuantityItem: TextView =  binding.textViewQuantityItem
        val imageViewItem: ImageView = binding.imageViewItem

        fun setImageForProduct(imageUrl: String) {
            Glide.with(imageViewItem.context)
                .load(imageUrl)
                .error(R.drawable.ic_baseline_error_24)
                .into(binding.imageViewItem)
        }

        fun bind(product: Product) {
            binding.textViewNameItem.text = product.name
            binding.textViewPriceItem.text = product.price.toString()
            val quantity = SingletonCart.getQuantity(product.id)
            if (quantity == 0) {
                showView(buttonDeleteItem, textViewQuantityItem, buttonAddItem, buttonAddToCartItem)
            } else {
                textViewQuantityItem.text = quantity.toString()
                hideView(buttonDeleteItem, textViewQuantityItem, buttonAddItem, buttonAddToCartItem)
            }
        }


        private fun showView(buttonDeleteItem: ImageButton, textViewQuantityItem: TextView, buttonAddItem: ImageButton, buttonAddToCartItem: Button) {
            buttonDeleteItem.visibility = GONE
            textViewQuantityItem.visibility = GONE
            buttonAddItem.visibility = GONE
            buttonAddToCartItem.visibility = VISIBLE
        }
        private fun hideView(buttonDeleteItem: ImageButton, textViewQuantityItem: TextView, buttonAddItem: ImageButton, buttonAddToCartItem: Button) {
            buttonDeleteItem.visibility = VISIBLE
            textViewQuantityItem.visibility = VISIBLE
            buttonAddItem.visibility = VISIBLE
            buttonAddToCartItem.visibility = GONE
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = productList[position]
        holder.bind(product)

        holder.setImageForProduct(product.imageUrl)
        holder.buttonAddToCartItem.setOnClickListener {
            SingletonCart.addProduct(product)
            hideView(holder.buttonDeleteItem, holder.textViewQuantityItem, holder.buttonAddItem, holder.buttonAddToCartItem)
            notifyDataSetChanged()
            listener.onAddProduct(product)
        }

        holder.buttonDeleteItem.setOnClickListener {
                SingletonCart.deleteProduct(product)
                holder.textViewQuantityItem.text = SingletonCart.getQuantity(product.id).toString()
                showView(holder.buttonDeleteItem, holder.textViewQuantityItem, holder.buttonAddItem, holder.buttonAddToCartItem)
            notifyDataSetChanged()
                //listener.onDeleteProduct(product)
        }
        holder.buttonAddItem.setOnClickListener {
            SingletonCart.addProduct(product)
            holder.textViewQuantityItem.text = SingletonCart.getQuantity(product.id).toString()
            notifyDataSetChanged()

        }
}

    private fun showView(buttonDeleteItem: ImageButton, textViewQuantityItem: TextView, buttonAddItem: ImageButton, buttonAddToCartItem: Button) {
        buttonDeleteItem.visibility = GONE
        textViewQuantityItem.visibility = GONE
        buttonAddItem.visibility = GONE
        buttonAddToCartItem.visibility = VISIBLE
    }

    private fun hideView(buttonDeleteItem: ImageButton, textViewQuantityItem: TextView, buttonAddItem: ImageButton, buttonAddToCartItem: Button) {
        buttonDeleteItem.visibility = VISIBLE
        textViewQuantityItem.visibility = VISIBLE
        buttonAddItem.visibility = VISIBLE
        buttonAddToCartItem.visibility = GONE
    }


    override fun getItemCount(): Int {
        return productList.size
    }
}