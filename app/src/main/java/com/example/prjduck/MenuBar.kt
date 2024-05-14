package com.example.prjduck

import android.os.Bundle
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

private val baseFrag = BaseFragment()
private val baseStatFrag = BaseStatFragment()
private val feedFrag = FeedFragment()
private val feedStatFrag = FeedStatFragment()
private val playFrag = PlayFragment()
private val playStatFrag = PlayStatFragment()
private val bathFrag = BathFragment()
private val bathStatFrag = BathStatFragment()

class MenuBar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu_bar)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        replaceFrag(baseFrag, baseStatFrag)
        val bottomBar = findViewById<BottomNavigationView>(R.id.NavBar)
        bottomBar.setOnItemSelectedListener{
            when(it.itemId)
            {
                R.id.ic_feed-> replaceFrag(feedFrag, feedStatFrag)
                R.id.ic_play-> replaceFrag(playFrag, playStatFrag)
                R.id.ic_bath-> replaceFrag(bathFrag, bathStatFrag)
            }
            true
        }
    }
    private fun replaceFrag(fragment: Fragment, fragment2: Fragment)
    {
        if(fragment != null)
        {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.frameLayout, fragment)
            transaction.commit()
            val transaction2 = supportFragmentManager.beginTransaction()
            transaction2.replace(R.id.statFrameLayout, fragment2)
            transaction2.commit()
        }
    }
}