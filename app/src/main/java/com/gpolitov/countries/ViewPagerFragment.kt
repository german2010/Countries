package com.gpolitov.countries

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.gpolitov.countries.adapters.COUNTRY_LIST_PAGE_INDEX
import com.gpolitov.countries.adapters.CountriesAdapter
import com.gpolitov.countries.adapters.FAVORITE_LIST_PAGE_INDEX
import com.gpolitov.countries.databinding.FragmentViewPagerBinding

class ViewPagerFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentViewPagerBinding.inflate(inflater, container, false)
        val tabLayout = binding.tabs
        val viewPager = binding.viewPager

        viewPager.adapter = CountriesAdapter(this)
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.setIcon(getTabIcon(position))
            tab.text = getTabTitle(position)
        }.attach()

        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)

        return binding.root
    }

    private fun getTabIcon(position: Int): Int {
        return when (position) {
            COUNTRY_LIST_PAGE_INDEX -> R.drawable.country_list_icon
            FAVORITE_LIST_PAGE_INDEX -> R.drawable.favorite_list_icon
            else -> throw IndexOutOfBoundsException()
        }
    }

    private fun getTabTitle(position: Int): String? {
        return when (position) {
            COUNTRY_LIST_PAGE_INDEX -> getString(R.string.country_list_title)
            FAVORITE_LIST_PAGE_INDEX -> getString(R.string.favorite_list_title)
            else -> null
        }
    }
}
