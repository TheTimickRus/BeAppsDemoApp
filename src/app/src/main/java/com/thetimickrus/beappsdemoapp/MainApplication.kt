package com.thetimickrus.beappsdemoapp

import android.app.Application
import com.thetimickrus.beappsdemoapp.ui.details.DetailsViewModel
import com.thetimickrus.beappsdemoapp.ui.main.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        val androidModule = module {

            viewModel {
                MainViewModel()
            }

            viewModel {
                DetailsViewModel()
            }
        }

        startKoin {
            androidLogger()
            androidContext(this@MainApplication)

            modules(androidModule)
        }

    }
}