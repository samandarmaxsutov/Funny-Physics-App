package uz.it_school.funypysicsapp.ui.screens.splashScreen


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import uz.it_school.funypysicsapp.model.PhysicsList
import uz.it_school.funypysicsapp.model.room.AppDatabase
import uz.it_school.funypysicsapp.model.shared.LocalStorage


class SplashScreenViewModel : ViewModel() {

    private val localStorage= LocalStorage.getLocalStorage()
    private val appDatabase= AppDatabase.getAppDatabase()
    private val booksList=PhysicsList()
    val openMainScreenLiveData = MutableLiveData<Unit>()

    init {
        viewModelScope.launch {
            if (!localStorage.first){
                localStorage.first=true
                appDatabase.getBookDao().insertAll(booksList.list)
            }
            delay(1500)

                openMainScreenLiveData.value=Unit

        }
    }
}

