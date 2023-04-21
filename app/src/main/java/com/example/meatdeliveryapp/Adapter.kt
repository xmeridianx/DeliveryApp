package com.example.meatdeliveryapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class Adapter (private val list: MutableList<Product>) : RecyclerView.Adapter<Adapter.ViewHolder>() {
    private lateinit var onProductChangeListener: OnProductChangeListener
    private lateinit var onProductCountChangeListener: OnProductCountChangeListener

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView){
        val name: TextView = itemView.findViewById(R.id.textProductName)
        val price: TextView = itemView.findViewById(R.id.textProductPrice)
        val image: ImageView = itemView.findViewById(R.id.imageProduct)
        val buttonAdd: Button = itemView.findViewById(R.id.buttonProductAdd)
        val buttonDelete: Button = itemView.findViewById(R.id.buttonProductDelete)
        val quantity: TextView = itemView.findViewById(R.id.textProductQuantity)
    }
    fun setOnProductCountChangeListener(listener: OnProductCountChangeListener) {
        onProductCountChangeListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent , false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = list[position]
        //list[position].image
        holder.name.text = list[position].name
        holder.price.text = list[position].price.toString()

        Glide.with(holder.itemView.context)
            .load(product.imageUrl) // URL-адрес изображения из объекта Product
            .error(R.drawable.ic_baseline_error_24)
            .into(holder.image)
        //holder.image.setImageResource(list[position].image)
            /*holder.buttonAdd.setOnClickListener {
            addProductToList(list[position])
        }
             */
        holder.buttonAdd.setOnClickListener {
            onProductChangeListener.onProductAdded(product)
            onProductCountChangeListener.onProductCountChanged(list.size)
            //val currentQuantity = holder.quantity.text.toString().toIntOrNull() ?: 0
            holder.quantity.text = product.quantity.toString()
            notifyDataSetChanged()
        }
        /*
        holder.buttonDelete.setOnClickListener {
            removeProductFromList(list[position])
        }
         */
        holder.buttonDelete.setOnClickListener {
            onProductChangeListener.onProductRemoved(product)
            onProductCountChangeListener.onProductCountChanged(list.size)
            holder.quantity.text = product.quantity.toString()
            notifyDataSetChanged()
        }
    }

    fun addProductToList(item: Product) {
        list.add(item)
        notifyDataSetChanged()
    }

    fun removeProductFromList(item: Product) {
        list.remove(item)
        notifyDataSetChanged()
    }
    fun notifyProductRemoved(product: Product) {
        val index = list.indexOf(product)
        if (index != -1) {
            list.remove(product)
            notifyItemRemoved(index)

        }
    }
    fun setOnProductChangeListener(listener: OnProductChangeListener) {
        onProductChangeListener = listener
    }

    override fun getItemCount(): Int {
        return list.size
    }
}