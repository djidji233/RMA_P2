package rs.raf.projekat2.Djordje_Zivanovic_RN9818.presentation.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import rs.raf.projekat2.Djordje_Zivanovic_RN9818.R
import rs.raf.projekat2.Djordje_Zivanovic_RN9818.presentation.view.viewpager.PagerAdapter

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        initViewPager()
        initNavigation()
    }

    private fun initViewPager() {
        viewPager.adapter = PagerAdapter(supportFragmentManager)
    }


    private fun initNavigation() {
        bottomNavigation.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.menu_raspored ->  {
                    viewPager.setCurrentItem(PagerAdapter.FRAGMENT_RASPORED, false)
                }
                R.id.menu_beleske ->  {
                    viewPager.setCurrentItem(PagerAdapter.FRAGMENT_BELESKE, false)
                }
                R.id.menu_stat ->  {
                    viewPager.setCurrentItem(PagerAdapter.FRAGMENT_STAT, false)
                }
            }
            true
        }
    }
}
