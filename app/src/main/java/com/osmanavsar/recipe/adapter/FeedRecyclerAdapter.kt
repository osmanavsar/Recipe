package com.osmanavsar.recipe.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.osmanavsar.recipe.databinding.RecyclerRowBinding
import com.osmanavsar.recipe.post
import com.squareup.picasso.Picasso


class FeedRecyclerAdapter(private val postList : ArrayList<post>) : RecyclerView.Adapter<FeedRecyclerAdapter.PostHolder>() {

    class PostHolder(val binding: RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostHolder {
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PostHolder(binding)
    }

    override fun getItemCount(): Int {
        return postList.size

    }

    override fun onBindViewHolder(holder: PostHolder, position: Int) {
        holder.binding.recyclerFoodName.text = postList.get(position).foodName
        holder.binding.recyclerIngredients.text = postList.get(position).ingredients
        holder.binding.recyclerRecipeText.text = postList.get(position).recipe
        Picasso.get().load(postList[position].downloadUrl).into(holder.binding.recyclerImageView)

    }

}