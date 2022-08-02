package com.example.noticeboardapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.main_content.*

class MainActivity : AppCompatActivity() , NavigationView.OnNavigationItemSelectedListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()

    }

    private fun init(){

        val toggle = ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        navView.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId){

            R.id.notice_my -> {
                Toast.makeText(this, "Presed notice_my", Toast.LENGTH_LONG).show()
            }
            R.id.notice_car -> {
                Toast.makeText(this, "Presed notice_car", Toast.LENGTH_LONG).show()
            }
            R.id.notice_dm -> {
                Toast.makeText(this, "Presed notice_dm", Toast.LENGTH_LONG).show()
            }
            R.id.notice_pc -> {
                Toast.makeText(this, "Presed notice_pc", Toast.LENGTH_LONG).show()
            }


        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

}


