package rs.raf.projekat2.Djordje_Zivanovic_RN9818.data.datasources.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import rs.raf.projekat2.Djordje_Zivanovic_RN9818.data.models.BeleskaEntity

@Database(
    entities = [BeleskaEntity::class],
    version = 1,
    exportSchema = false)
@TypeConverters()
abstract class BeleskeDataBase : RoomDatabase() {
    abstract fun getBeleskaDao(): BeleskaDao
}