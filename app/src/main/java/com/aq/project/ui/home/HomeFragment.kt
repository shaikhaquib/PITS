package com.aq.project.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.aq.project.R
import com.aq.project.adapter.HomeScreenAdapter
import com.aq.project.adapter.ImageViewPagerAdapter
import com.aq.project.databinding.FragmentHomeBinding
import com.zhpan.indicator.enums.IndicatorSlideMode
import com.zhpan.indicator.enums.IndicatorStyle

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private lateinit var imageViewPagerAdapter: ImageViewPagerAdapter

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val imageUrlList = listOf(
            "https://jssors8.azureedge.net/demos/img/gallery/980x380/041.jpg",
            "https://jssors8.azureedge.net/demos/img/gallery/980x380/042.jpg",
            "https://jssors8.azureedge.net/demos/img/gallery/980x380/043.jpg",
            "https://jssors8.azureedge.net/demos/img/gallery/980x380/044.jpg",
            "https://jssors8.azureedge.net/demos/img/gallery/980x380/045.jpg",
            "https://jssors8.azureedge.net/demos/img/gallery/980x380/046.jpg",
            "https://jssors8.azureedge.net/demos/img/gallery/980x380/047.jpg",
            "https://jssors8.azureedge.net/demos/img/gallery/980x380/048.jpg",
            "https://jssors8.azureedge.net/demos/img/gallery/980x380/049.jpg",
            "https://jssors8.azureedge.net/demos/img/gallery/980x380/050.jpg"
        )


        binding.rvService.setHasFixedSize(true)
        binding.rvService.adapter = HomeScreenAdapter()

        //initializing the adapter
        imageViewPagerAdapter = ImageViewPagerAdapter(imageUrlList)
        setUpViewPager()
        return root
    }

    private fun setUpViewPager() {

        binding.viewPager.adapter = imageViewPagerAdapter
        binding.indicatorView.apply {
            setSliderWidth(resources.getDimension(R.dimen.dp_10))
            setSliderHeight(resources.getDimension(R.dimen.dp_5))
            setSlideMode(IndicatorSlideMode.WORM)
            setIndicatorStyle(IndicatorStyle.CIRCLE)
            setPageSize(binding.viewPager!!.adapter!!.itemCount)
            notifyDataChanged()
        }

        binding.viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        val currentPageIndex = 1
        binding.viewPager.currentItem = currentPageIndex
        binding.viewPager.registerOnPageChangeCallback(
            object : ViewPager2.OnPageChangeCallback() {

                override fun onPageScrolled(
                    position: Int,
                    positionOffset: Float,
                    positionOffsetPixels: Int
                ) {
                    super.onPageScrolled(position, positionOffset, positionOffsetPixels)
                    binding.indicatorView.onPageScrolled(
                        position,
                        positionOffset,
                        positionOffsetPixels
                    )

                }

                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    binding.indicatorView.onPageSelected(position)
                    //update the image number textview
                }
            }
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}