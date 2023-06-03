package uz.it_school.funypysicsapp.ui.screens.bookMarks
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.it_school.funypysicsapp.model.room.AppDatabase
import uz.it_school.funypysicsapp.model.room.entities.PhysicsEntity

class BookMarksViewModel : ViewModel() {
    private val appDatabase= AppDatabase.getAppDatabase()
    val countriesLiveData= MediatorLiveData<List<PhysicsEntity>>()
    val openCountryScreenLiveData= MutableLiveData<PhysicsEntity>()
    fun open(country: PhysicsEntity) {
        openCountryScreenLiveData.value=country
    }


    init {
        countriesLiveData.addSource(appDatabase.getBookDao().getBooksByMarks()){
            countriesLiveData.value=it
        }

    }
}