package com.example.simplegalleryhw

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.simplegalleryhw.databinding.ItemRecyclerBinding

class GalleryAdapter(
    private val images: ArrayList<GalleryModel>,
    private val clickListener: (GalleryModel) -> Unit
) :
    RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryViewHolder {
        return GalleryViewHolder(
            ItemRecyclerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) {
        holder.onBind(images[position])
    }

    override fun getItemCount() = images.size

    inner class GalleryViewHolder(private val binding: ItemRecyclerBinding): RecyclerView.ViewHolder(binding.root){
        fun onBind(galleryModel: GalleryModel){
            binding.imageItem.load(galleryModel.img)

            itemView.setOnClickListener {
                clickListener(galleryModel)

            if(galleryModel.select == true){
                binding.imageTranspItem.visibility = View.VISIBLE
            }else{
                binding.imageTranspItem.visibility = View.INVISIBLE
            }

            }

        }
    }
}