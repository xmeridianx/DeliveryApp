package com.example.meatdeliveryapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.meatdeliveryapp.data.Product

class Adapter(
    private val list: MutableList<Product>,
    private var onProductChangeListener: OnProductChangeListener
) : RecyclerView.Adapter<Adapter.ViewHolder>() {
    private lateinit var onProductCountChangeListener: OnProductCountChangeListener

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView){
        val name: TextView = itemView.findViewById(R.id.textProductName)
        val price: TextView = itemView.findViewById(R.id.textProductPrice)
        val image: ImageView = itemView.findViewById(R.id.imageProduct)
        val buttonAdd: ImageButton = itemView.findViewById(R.id.buttonProductAdd)
        val buttonDelete: ImageButton = itemView.findViewById(R.id.buttonProductDelete)
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
        holder.quantity.text = product.quantity.toString()

        Glide.with(holder.itemView.context)
            .load(product.imageUrl)
            .error(R.drawable.ic_baseline_error_24)
            .into(holder.image)

        holder.buttonAdd.setOnClickListener {
            onProductChangeListener.onProductAdded(product)
            if (::onProductCountChangeListener.isInitialized) {
                onProductCountChangeListener.onProductCountChanged(list.size)
            }
            product.quantity++
            holder.quantity.text = product.quantity.toString()
            notifyItemChanged(position)
        }

        holder.buttonDelete.setOnClickListener {
            if (list.isNotEmpty()) {
                val product = list[position]
                if (product.quantity > 1) {
                    product.quantity--
                    holder.quantity.text = product.quantity.toString()
                    notifyItemChanged(position)
                } else {
                    SingletonCart.deleteProduct(product)
                    if (list.size > 1) {
                        list.removeAt(position)
                        notifyItemRemoved(position)
                        notifyItemRangeChanged(position, list.size - position)
                    } else {
                        list.removeAt(position)
                        notifyItemRemoved(position)
                        onProductCountChangeListener.onProductCountChanged(list.size)
                    }
                }
            }
    }

}

    //добавить метод удаления

    override fun getItemCount(): Int {
        return list.size
    }
    fun clear(){
        return list.clear()
    }
}