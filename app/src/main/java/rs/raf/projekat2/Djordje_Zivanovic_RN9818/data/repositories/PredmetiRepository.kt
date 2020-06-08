package rs.raf.projekat2.Djordje_Zivanovic_RN9818.data.repositories

import io.reactivex.Completable
import io.reactivex.Observable
import rs.raf.projekat2.Djordje_Zivanovic_RN9818.data.models.Predmet
import rs.raf.projekat2.Djordje_Zivanovic_RN9818.data.models.PredmetEntity
import rs.raf.projekat2.Djordje_Zivanovic_RN9818.data.models.Resource

interface PredmetiRepository {
    fun fetchAll(): Observable<Resource<Unit>>
    fun insert(entity: PredmetEntity): Completable
    fun insertAll(entities: List<PredmetEntity>): Completable
    fun deleteAll()
    fun deleteAndInsertAll(entities: List<PredmetEntity>)
    fun getAll(): Observable<List<Predmet>>
    fun getByPredmetOrNastavnik(filter: String): Observable<List<Predmet>>
    fun getByGrupa(grupe: String): Observable<List<Predmet>>
    fun getByDan(dan: String): Observable<List<Predmet>>
    fun getByGrupaAndDan(dan: String, grupa: String): Observable<List<Predmet>>
    fun getByGrupaAndPredmetOrNastavnik(grupa: String, filter: String): Observable<List<Predmet>>
    fun getByDanAndPredmetOrNastavnik(dan: String, filter: String): Observable<List<Predmet>>
    fun getByAllFilters(dan: String, filter: String, grupa: String): Observable<List<Predmet>>
}