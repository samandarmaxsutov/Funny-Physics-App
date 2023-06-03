package uz.it_school.funypysicsapp.ui.screens.home

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.it_school.funypysicsapp.model.room.AppDatabase
import uz.it_school.funypysicsapp.model.room.entities.PhysicsEntity

class HomeScreenViewModel : ViewModel() {
    private val appDatabase= AppDatabase.getAppDatabase()
    val countriesLiveData= MediatorLiveData<List<PhysicsEntity>>()
    val openBookAboutScreenLiveData=MutableLiveData<PhysicsEntity>()
     fun open(country: PhysicsEntity) {
        openBookAboutScreenLiveData.value=country
    }


    init {
        countriesLiveData.addSource(appDatabase.getBookDao().getBooks()){
            countriesLiveData.value=it
        }

    }

    fun search(words:String){
        if (words.isNotEmpty()) {
            countriesLiveData.addSource(appDatabase.getBookDao().getBooksByTitle(words)) {
                countriesLiveData.value = it
            }
        }else{
            countriesLiveData.addSource(appDatabase.getBookDao().getBooks()){
                countriesLiveData.value=it
            }
        }
    }
}