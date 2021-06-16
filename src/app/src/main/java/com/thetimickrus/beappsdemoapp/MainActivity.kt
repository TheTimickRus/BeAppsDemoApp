package com.thetimickrus.beappsdemoapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import org.koin.android.ext.android.getKoin

class MainActivity : AppCompatActivity() {
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.main_activity)

        // Инициализируем навигацию
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.mainFragment,
                R.id.detailsFragment,
                R.id.errorFragment
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)

        // Понимаю, что это такое себе, но очень много костылей было,
        // из - за отсутствия прямого доступа к основной активности
        getKoin().setProperty("MainActivity", this)
    }
}