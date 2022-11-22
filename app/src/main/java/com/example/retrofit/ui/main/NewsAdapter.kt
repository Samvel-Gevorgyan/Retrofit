package com.example.retrofit.ui.main

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit.data.model.guardia.GuardianNewsItem
import com.example.retrofit.databinding.AdapterBinding

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    private val items:MutableList<GuardianNewsItem> = mutableListOf()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val binding = AdapterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(items:List<GuardianNewsItem>?){
        this.items.clear()
        items?.let { this.items.addAll(it) }
        notifyDataSetChanged()
    }

    inner class NewsViewHolder(private  var binding: AdapterBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: GuardianNewsItem) {
            binding.textId.text = item.id
            binding.textType.text = item.type
            binding.textSecondId.text = item.sectionId
        }
    }


/*    private val differCallback = object : DiffUtil.ItemCallback<GuardianNewsItem>() {
        override fun areItemsTheSame(oldItem: GuardianNewsItem, newItem: GuardianNewsItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: GuardianNewsItem, newItem:GuardianNewsItem): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)*/
}