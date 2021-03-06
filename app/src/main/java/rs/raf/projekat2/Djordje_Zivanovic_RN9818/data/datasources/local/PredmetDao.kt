package rs.raf.projekat2.Djordje_Zivanovic_RN9818.data.datasources.local

import androidx.room.*
import io.reactivex.Completable
import io.reactivex.Observable
import rs.raf.projekat2.Djordje_Zivanovic_RN9818.data.models.PredmetEntity

@Dao
abstract class PredmetDao {

    @Insert( onConflict = OnConflictStrategy.REPLACE )
    abstract fun insert(entity: PredmetEntity): Completable

    @Insert( onConflict = OnConflictStrategy.REPLACE )
    abstract fun insertAll(entities: List<PredmetEntity>): Completable

    @Query("DELETE FROM predmeti")
    abstract fun deleteAll()

    @Transaction
    open fun deleteAndInsertAll(entities: List<PredmetEntity>) {
        deleteAll()
        insertAll(entities).blockingAwait()
    }

    @Query("SELECT * FROM predmeti")
    abstract fun getAll(): Observable<List<PredmetEntity>>

    @Query("SELECT * FROM predmeti WHERE predmet LIKE :filter || '%' OR nastavnik LIKE :filter || '%'")
    abstract fun getByPredmetOrNastavnik(filter: String): Observable<List<PredmetEntity>>

    @Query("SELECT * FROM predmeti WHERE grupe LIKE :grupe || '%'")
    abstract fun getByGrupa(grupe: String): Observable<List<PredmetEntity>>

    @Query("SELECT * FROM predmeti WHERE dan LIKE :dan || '%'")
    abstract fun getByDan(dan: String): Observable<List<PredmetEntity>>

    @Query("SELECT * FROM predmeti WHERE dan LIKE :dan || '%' AND grupe LIKE :grupa || '%'")
    abstract fun getByGrupaAndDan(dan: String, grupa: String): Observable<List<PredmetEntity>>

    @Query("SELECT * FROM predmeti WHERE grupe LIKE :grupa || '%' AND (predmet LIKE :filter || '%' OR nastavnik LIKE :filter || '%')")
    abstract fun getByGrupaAndPredmetOrNastavnik(grupa: String, filter: String): Observable<List<PredmetEntity>>

    @Query("SELECT * FROM predmeti WHERE dan LIKE :dan || '%' AND (predmet LIKE :filter || '%' OR nastavnik LIKE :filter || '%')")
    abstract fun getByDanAndPredmetOrNastavnik(dan: String, filter: String): Observable<List<PredmetEntity>>

    @Query("SELECT * FROM predmeti WHERE dan LIKE :dan || '%' AND (predmet LIKE :filter || '%' OR nastavnik LIKE :filter || '%') AND grupe LIKE :grupa ||'%'")
    abstract fun getByAllFilters(dan: String, filter: String, grupa: String): Observable<List<PredmetEntity>>

}