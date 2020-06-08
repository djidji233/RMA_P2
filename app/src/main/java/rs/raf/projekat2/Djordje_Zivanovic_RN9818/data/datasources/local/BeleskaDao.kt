package rs.raf.projekat2.Djordje_Zivanovic_RN9818.data.datasources.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Completable
import io.reactivex.Observable
import rs.raf.projekat2.Djordje_Zivanovic_RN9818.data.models.BeleskaEntity

@Dao
abstract class BeleskaDao {

    @Insert( onConflict = OnConflictStrategy.REPLACE )
    abstract fun insert(entity: BeleskaEntity): Completable

    @Query("DELETE FROM beleske WHERE id == :id")
    abstract fun delete(id: Long)

    @Query("SELECT * FROM beleske")
    abstract fun getAll(): Observable<List<BeleskaEntity>>

    @Query("UPDATE beleske SET title = :title, content = :content WHERE id == :id")
    abstract fun update(id: Long, title:String, content: String): Completable

}