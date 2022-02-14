package com.example.ocmr.ui.customer.main

import android.view.View
import androidx.viewpager.widget.PagerAdapter
import android.view.ViewGroup

import android.content.Context

import android.view.LayoutInflater
import android.widget.ImageView
import com.example.ocmr.R


// Custom pager adapter not using fragments
    class BannerAdapter constructor(context: Context) : PagerAdapter() {
        private var mLayoutInflater: LayoutInflater = LayoutInflater.from(context)
        private var pages: ArrayList<String> = ArrayList()

        // Returns the number of pages to be displayed in the ViewPager.
        override fun getCount(): Int {
            return 4
        }

        // Returns true if a particular object (page) is from a particular page
        override fun isViewFromObject(view: View, `object`: Any): Boolean {
            return view === `object`
        }

        // This method should create the page for the given position passed to it as an argument.
        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            // Inflate the layout for the page
            val itemView: View = mLayoutInflater.inflate(R.layout.item_banner, container, false)
            // Find and populate data into the page (i.e set the image)
            //val imageView: ImageView = itemView.findViewById<View>(R.id.imageView) as ImageView
            // ...
            // Add the page to the container
            container.addView(itemView)
            // Return the page
            return itemView
        }

        // Removes the page from the container for the given position.
        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            container.removeView(`object` as View)
        }

}