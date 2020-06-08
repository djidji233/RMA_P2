package rs.raf.projekat2.Djordje_Zivanovic_RN9818.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "beleske")
data class BeleskaEntity (
    @PrimaryKey(autoGenerate = true) val id: Long,
    val title: String,
    val content: String,
    val archived: Boolean
)