package uz.it_school.funypysicsapp.model.room.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import uz.it_school.funypysicsapp.model.room.entities.PhysicsEntity

@Dao
interface PhysicsDao {
    @Query("SELECT * FROM physics")
    fun getBooks(): LiveData<List<PhysicsEntity>>
    @Query("SELECT * FROM physics WHERE id = :id")
    fun getBook(id: Int): LiveData<PhysicsEntity>
    @Query("SELECT * FROM physics WHERE title like '%'||:title||'%' or author like '%'||:title||'%'")
    fun getBooksByTitle(title:String): LiveData<List<PhysicsEntity>>

    @Query("SELECT * FROM physics where bookMarks=1")
    fun getBooksByMarks(): LiveData<List<PhysicsEntity>>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(bookList: List<PhysicsEntity>)

    @Update
    fun update(book: PhysicsEntity)
    @Query("DELETE FROM physics")
    fun deleteAll()
    @Query("DELETE FROM physics WHERE id = :id")
    fun delete(id: String)

    @Insert
    fun insert(book: PhysicsEntity)


}