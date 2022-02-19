package com.gpolitov.countries.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.gpolitov.countries.CountryListFragment
import com.gpolitov.countries.FavoriteListFragment

const val COUNTRY_LIST_PAGE_INDEX = 0
const val FAVORITE_LIST_PAGE_INDEX = 1

class CountriesAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    private val tabFragmentsCreators: Map<Int, () -> Fragment> = mapOf(
        COUNTRY_LIST_PAGE_INDEX to { CountryListFragment() },
        FAVORITE_LIST_PAGE_INDEX to { FavoriteListFragment() }
    )

    override fun getItemCount(): Int {
        return tabFragmentsCreators.size
    }

    override fun createFragment(position: Int): Fragment {
        return tabFragmentsCreators[position]?.invoke() ?: throw IndexOutOfBoundsException()
    }
}
