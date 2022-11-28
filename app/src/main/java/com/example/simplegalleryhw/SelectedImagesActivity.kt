package com.example.simplegalleryhw

import android.util.Log
import android.view.LayoutInflater
import androidx.recyclerview.widget.GridLayoutManager
import com.example.simplegalleryhw.base.BaseActivity
import com.example.simplegalleryhw.databinding.ActivitySelectedImagesBinding

class SelectedImagesActivity : BaseActivity<ActivitySelectedImagesBinding>() {

    private lateinit var adapter: GalleryAdapter

    override fun checkInternet() {

    }

    override fun initView() {
        val imgs = intent.getSerializableExtra(MainActivity.AM_SIA_IMAGES) as ArrayList<GalleryModel>
        Log.e("extra", imgs.toString(), )
        val gridLayoutManager = GridLayoutManager(this,2)
        adapter = GalleryAdapter(imgs, this::clickListener)
        binding.selectedRecycler.layoutManager = gridLayoutManager
        binding.selectedRecycler.adapter = adapter
    }

    override fun initObservers() {

    }

    override fun initListener() {

    }

    private fun clickListener(imgModel : GalleryModel){

    }

    override fun inflateViewBinding(inflater: LayoutInflater): ActivitySelectedImagesBinding {
        return ActivitySelectedImagesBinding.inflate(layoutInflater)
    }


}