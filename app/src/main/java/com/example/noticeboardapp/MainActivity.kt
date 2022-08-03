package com.example.noticeboardapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.example.noticeboardapp.databinding.ActivityMainBinding
import com.example.noticeboardapp.dialogHelper.DialogConst
import com.example.noticeboardapp.dialogHelper.DialogHelper
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var tvAccount: TextView
    private lateinit var rootElement: ActivityMainBinding
    private val dialogHelper = DialogHelper(this)
    val mAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        rootElement = ActivityMainBinding.inflate(layoutInflater)
        val view = rootElement.root
        setContentView(view)
        init()
        tvAccount = rootElement.navView.getHeaderView(0).findViewById(R.id.tvAccountEmail)
    }


    override fun onStart() {
        super.onStart()
        uiUpdate(mAuth.currentUser)
    }


    private fun init() {

        val toggle = ActionBarDrawerToggle(
            this,
            rootElement.drawerLayout,
            rootElement.mainContent.toolbar,
            R.string.open,
            R.string.close
        )
        rootElement.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        rootElement.navView.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {

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

            R.id.notice_sign_up -> {
                dialogHelper.createSignDialog(DialogConst.SIGN_UP_STATE)
            }
            R.id.notice_sing_in -> {
                dialogHelper.createSignDialog(DialogConst.SIGN_IN_STATE)
            }
            R.id.notice_sing_in -> {
                uiUpdate(null)
            }

        }
        rootElement.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    fun uiUpdate(user: FirebaseUser?) {
       tvAccount.text = if (user == null) {
           resources.getString(R.string.not_reg)
       }else{
       user.email
       }
       }
}



