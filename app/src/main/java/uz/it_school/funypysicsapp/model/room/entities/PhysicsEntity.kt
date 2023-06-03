package uz.it_school.funypysicsapp.model.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "physics")
data class PhysicsEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Int=0,
    val title: String,
    val author: String,
    val url: String,
    val image:Int,
    val description: String,
    var bookMarks:Boolean=false
):Serializable