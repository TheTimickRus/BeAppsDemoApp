package com.thetimickrus.beappsdemoapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.thetimickrus.beappsdemoapp.ui.details.DetailsFragment
import com.thetimickrus.beappsdemoapp.ui.main.MainFragment
import org.koin.android.ext.android.getKoin

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.main_activity)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.main_activity_container, MainFragment.newInstance())
                .add(R.id.main_activity_container, DetailsFragment.newInstance())
                .replace(R.id.main_activity_container, MainFragment.newInstance())
                .commit()
        }

        // Понимаю, что это такое себе, но очень много костылей было,
        // из - за отсутствия прямого доступа к основной активности
        getKoin().setProperty("MainActivity", this)
    }
}