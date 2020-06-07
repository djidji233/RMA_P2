package rs.raf.projekat2.Djordje_Zivanovic_RN9818.presentation.view.viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import rs.raf.projekat2.Djordje_Zivanovic_RN9818.presentation.view.fragments.BeleskeFragment
import rs.raf.projekat2.Djordje_Zivanovic_RN9818.presentation.view.fragments.RasporedFragment
import rs.raf.projekat2.Djordje_Zivanovic_RN9818.presentation.view.fragments.StatistikaFragment

class PagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object {
        private const val ITEM_COUNT = 3
        const val FRAGMENT_RASPORED = 0
        const val FRAGMENT_BELESKE = 1
        const val FRAGMENT_STAT = 2
    }

    override fun getItem(position: Int): Fragment {
        return when(position) {
            FRAGMENT_RASPORED -> RasporedFragment()
            FRAGMENT_BELESKE -> BeleskeFragment()
            else -> StatistikaFragment()
        }
    }

    override fun getCount(): Int {
        return ITEM_COUNT
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position) {
            FRAGMENT_RASPORED -> "Raspored"
            FRAGMENT_BELESKE -> "Beleske"
            else -> "Statistika"
        }
    }

}