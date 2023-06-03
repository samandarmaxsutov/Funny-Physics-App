package uz.it_school.funypysicsapp.app

import android.app.Application
import uz.it_school.funypysicsapp.model.room.AppDatabase
import uz.it_school.funypysicsapp.model.shared.LocalStorage

class App:Application() {
    override fun onCreate() {
        super.onCreate()
        LocalStorage.init(this)
        AppDatabase.init(this)
    }
}