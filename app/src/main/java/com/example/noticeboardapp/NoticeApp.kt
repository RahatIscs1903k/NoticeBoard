package com.example.noticeboardapp

import android.app.Application
import com.google.firebase.FirebaseApp

class NoticeApp: Application() {

    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(applicationContext)
    }
}