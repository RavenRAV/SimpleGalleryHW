package com.example.simplegalleryhw

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.recyclerview.widget.GridLayoutManager
import com.example.simplegalleryhw.base.BaseActivity
import com.example.simplegalleryhw.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {

    private val imagesList = arrayListOf<GalleryModel>()
    private val selectedImgs = arrayListOf<GalleryModel>()
    private lateinit var adapter: GalleryAdapter

    override fun checkInternet() {

    }

    override fun initView() {
        imagesList.add(GalleryModel("https://i.pinimg.com/originals/78/44/0b/78440b7fa11ad7b6fe2fc8c2defa16e3.jpg", false))
        imagesList.add(GalleryModel("https://upload.wikimedia.org/wikipedia/commons/c/c5/Best_Nature_Picture_of_the_day.jpg", false))
        imagesList.add(GalleryModel("https://cdn.fishki.net/upload/post/201508/05/1618749/main_1200-3.jpg", false))
        imagesList.add(GalleryModel("https://images4.alphacoders.com/168/168614.jpg", false))
        imagesList.add(GalleryModel("https://images7.alphacoders.com/316/thumb-1920-316372.jpg", false))
        imagesList.add(GalleryModel("https://wallpaper-mania.com/wp-content/uploads/2018/09/High_resolution_wallpaper_background_ID_77700054817.jpg", false))
        imagesList.add(GalleryModel("https://fullpicture.ru/wp-content/uploads/2015/06/Takim-nash-mir-vidyat-kompyutery-1.jpg", false))
        imagesList.add(GalleryModel("https://www.boredpanda.com/blog/wp-content/uploads/2014/09/american-nature-photography-exhibit-wilderness-forever-smithsonian-23.jpg", false))
        val gridLayoutManager = GridLayoutManager(this,2)
        adapter = GalleryAdapter(imagesList, this::clickListener)
        binding.galleryRecycler.layoutManager = gridLayoutManager
        binding.galleryRecycler.adapter = adapter
    }

    override fun initObservers() {

    }

    override fun initListener() {
        binding.fabSend.setOnClickListener {
            val intent = Intent(this, SelectedImagesActivity::class.java)
            intent.putExtra(AM_SIA_IMAGES, selectedImgs)
            startActivity(intent)
        }

    }

    private fun clickListener(imgModel : GalleryModel){
       imgModel.select = !imgModel.select
        if (imgModel.select == true){
            selectedImgs.add(imgModel)
        }else{
            selectedImgs.remove(imgModel)
        }

        Log.e("ololo", selectedImgs.toString(), )


    }


    override fun inflateViewBinding(inflater: LayoutInflater): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    companion object{
        const val AM_SIA_IMAGES = "amsiaimg"
        const val AM_SIA_BUNDLE = "amsiabundle"
    }



}