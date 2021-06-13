package com.thetimickrus.beappsdemoapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.thetimickrus.beappsdemoapp.ui.details.DetailsFragment
import com.thetimickrus.beappsdemoapp.ui.details.DetailsViewModel
import com.thetimickrus.beappsdemoapp.ui.main.MainFragment
import com.thetimickrus.beappsdemoapp.ui.main.MainViewModel
import org.koin.androidx.scope.lifecycleScope
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.main_activity)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commit()
        }
    }
}