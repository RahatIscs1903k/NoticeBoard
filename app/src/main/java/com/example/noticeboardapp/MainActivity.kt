package com.example.noticeboardapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.example.noticeboardapp.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity() , NavigationView.OnNavigationItemSelectedListener{
    private var rootElement:ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        rootElement = ActivityMainBinding.inflate(layoutInflater)
        val view = rootElement!!.root
        setContentView(view )
        init()
    }

    private fun init(){

        val toggle = ActionBarDrawerToggle(this,rootElement.drawerLayout,rootElement.mainContent.toolbar,R.string.open,R.string.close)
        rootElement.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        rootElement.navView.setNavigationItemSelectedListener(this)
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
        rootElement.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

}


