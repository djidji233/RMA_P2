package rs.raf.projekat2.Djordje_Zivanovic_RN9818.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "predmeti")
data class PredmetEntity (
    @PrimaryKey(autoGenerate = true) val id: Long,
    val predmet: String,
    val tip: String,
    val nastavnik: String,
    val ucionica: String,
    val grupe: String,
    val dan: String,
    val termin: String
)