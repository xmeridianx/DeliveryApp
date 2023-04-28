package com.example.meatdeliveryapp.recyclerProduct

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.meatdeliveryapp.*

class AdapterProduct(private val list: MutableList<Product>) : RecyclerView.Adapter<AdapterProduct.ViewHolder>() {
    private lateinit var onProductChangeListener: OnProductChangeListener
    private lateinit var onProductCountChangeListener: OnProductCountChangeListener
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView){
        val name: TextView = itemView.findViewById(R.id.textViewName11)
        val price: TextView = itemView.findViewById(R.id.textViewPrice11)
        val image: ImageView = itemView.findViewById(R.id.imageView101)
        val buttonAdd: ImageButton = itemView.findViewById(R.id.buttonAddToCart11)
        val buttonDelete: ImageButton = itemView.findViewById(R.id.buttonDelete11)
        val quantity: TextView = itemView.findViewById(R.id.textViewQuantity11)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = list[position]
        //list[position].image
        holder.name.text = "aaaaaa"
        holder.price.text = "11"
        holder.quantity.text = "1"

        Glide.with(holder.itemView.context)
            .load(product.image)
            .error(R.drawable.ic_baseline_error_24)
            .into(holder.image)

        holder.buttonAdd.setOnClickListener {
            if (::onProductChangeListener.isInitialized) {
                onProductChangeListener.onProductAdded(product)
            }
            if (::onProductCountChangeListener.isInitialized) {
                onProductCountChangeListener.onProductCountChanged(list.size)
            }
            product.quantity++
            holder.quantity.text = product.quantity.toString()
            notifyItemChanged(position)
        }

        holder.buttonDelete.setOnClickListener {
            if (product.quantity > 1) {
                product.quantity--
                holder.quantity.text = product.quantity.toString()
                notifyItemChanged(position)
            } else {
                onProductChangeListener.onProductRemoved(product)
                onProductCountChangeListener.onProductCountChanged(list.size)
                list.removeAt(position)
                notifyItemRemoved(position)
            }
        }

}

    override fun getItemCount(): Int {
        return list.size
    }

}