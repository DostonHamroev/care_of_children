package uz.hamroev.careofchildren.app

import android.app.Application
import uz.hamroev.careofchildren.cache.Cache

class App : Application() {
    override fun onCreate() {
        Cache.init(this)
        super.onCreate()
    }
}