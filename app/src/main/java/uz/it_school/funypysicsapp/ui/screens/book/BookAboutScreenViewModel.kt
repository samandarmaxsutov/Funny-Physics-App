package uz.it_school.funypysicsapp.ui.screens.book

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import uz.it_school.funypysicsapp.model.room.AppDatabase
import uz.it_school.funypysicsapp.model.room.entities.PhysicsEntity

class BookAboutScreenViewModel : ViewModel() {
    var id=0
    private val appDatabase= AppDatabase.getAppDatabase()
    val getUiChange=MediatorLiveData<PhysicsEntity>()
    private var bookEntity:PhysicsEntity?=null
    fun update(){
        bookEntity!!.bookMarks=!bookEntity!!.bookMarks
        appDatabase.getBookDao().update(bookEntity!!)
    }
    fun init(book:PhysicsEntity) {
            getUiChange.addSource(appDatabase.getBookDao().getBook(book.id)){
                bookEntity=it
                getUiChange.value=it
            }
        }

}