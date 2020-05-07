package com.example.introsliderusingkotlin

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.viewpager.widget.ViewPager
import com.example.introsliderusingkotlin.Adapter.myPagerAdapter
import com.example.introsliderusingkotlin.Fragment.Slider_Fragment
import com.example.introsliderusingkotlin.Fragment.Slider_Fragment_2
import com.example.introsliderusingkotlin.Fragment.Slider_Fragment_3
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val fragment1 = Slider_Fragment()
    val fragment2 = Slider_Fragment_2()
    val fragment3 = Slider_Fragment_3()
    lateinit var adapter: myPagerAdapter
    val pref_show_intro = "Intro"


   lateinit var preference : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)

        preference = getSharedPreferences("IntroSlider", Context.MODE_PRIVATE)


        if (!preference.getBoolean(pref_show_intro,true))
        {
            startActivity(Intent(this@MainActivity,WelcomeActivity::class.java))
            finish()
        }

        adapter = myPagerAdapter(
            supportFragmentManager
        )
        adapter.list.add(fragment1)
        adapter.list.add(fragment2)
        adapter.list.add(fragment3)

        view_pager.adapter = adapter
        btn_next.setOnClickListener {
            view_pager.currentItem++
        }

        btn_skip.setOnClickListener {
            GoToWelcomeScree()
        }

        view_pager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int)
            {

            }

            override fun onPageSelected(position: Int)
            {
                if (position == adapter.list.size-1)
                {
                    //last Page
                    btn_next.text = "DONE"
                    btn_next.setOnClickListener {
                        GoToWelcomeScree()
                    }
                }
                else
                {
                    //has next
                    btn_next.text = "NEXT"
                    btn_next.setOnClickListener {
                        view_pager.currentItem++
                    }
                }

                when(view_pager.currentItem)
                {
                    0->
                    {
                        indicator_1.setTextColor(Color.BLACK)
                        indicator_2.setTextColor(Color.GRAY)
                        indicator_3.setTextColor(Color.GRAY)
                    }
                    1->
                    {
                        indicator_1.setTextColor(Color.GRAY)
                        indicator_2.setTextColor(Color.BLACK)
                        indicator_3.setTextColor(Color.GRAY)
                    }
                    2->
                    {
                        indicator_1.setTextColor(Color.GRAY)
                        indicator_2.setTextColor(Color.GRAY)
                        indicator_3.setTextColor(Color.BLACK)
                    }
                }
            }

        })


    }

    fun GoToWelcomeScree()
    {
        startActivity(Intent(this@MainActivity,WelcomeActivity::class.java))
        finish()
        val editor = preference.edit()
        editor.putBoolean(pref_show_intro,false)
        editor.apply()
    }

}
