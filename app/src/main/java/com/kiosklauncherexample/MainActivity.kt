package com.kiosklauncherexample

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        KioskUtil.startKioskMode(this)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        if (supportFragmentManager.findFragmentById(R.id.fragmentContainerView) is AppsFragment) supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView, HomeFragment()).commit()
    }
}
