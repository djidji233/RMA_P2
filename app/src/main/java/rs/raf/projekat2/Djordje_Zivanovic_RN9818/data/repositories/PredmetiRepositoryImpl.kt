package rs.raf.projekat2.Djordje_Zivanovic_RN9818.data.repositories

import io.reactivex.Completable
import io.reactivex.Observable
import rs.raf.projekat2.Djordje_Zivanovic_RN9818.data.datasources.local.PredmetDao
import rs.raf.projekat2.Djordje_Zivanovic_RN9818.data.datasources.remote.PredmetiService
import rs.raf.projekat2.Djordje_Zivanovic_RN9818.data.models.Predmet
import rs.raf.projekat2.Djordje_Zivanovic_RN9818.data.models.PredmetEntity
import rs.raf.projekat2.Djordje_Zivanovic_RN9818.data.models.Resource
import timber.log.Timber

class PredmetiRepositoryImpl ( // iz entity/response u predmet
    private val localDataSource: PredmetDao,
    private val remoteDataSource: PredmetiService
) : PredmetiRepository {

    override fun fetchAll(): Observable<Resource<Unit>> {
        return remoteDataSource
            .getAll()
            .doOnNext {
                Timber.e("Skidam s neta i upisujem u lokal")
                val entities = it.map {
                    PredmetEntity(
                        it.id,
                        it.predmet,
                        it.tip,
                        it.nastavnik,
                        it.ucionica,
                        it.grupe,
                        it.dan,
                        it.termin
                    )
                }
                localDataSource.deleteAndInsertAll(entities)
            }
            .map {
                Resource.Success(Unit)
            }
    }

    override fun insert(entity: PredmetEntity): Completable {
        Timber.e("Insert")
        return localDataSource
            .insert(entity)
    }

    override fun insertAll(entities: List<PredmetEntity>): Completable {
        Timber.e("Insert All")
        return localDataSource
            .insertAll(entities)
    }

    override fun deleteAll() {
        Timber.e("Delete all")
        localDataSource.deleteAll()
    }

    override fun deleteAndInsertAll(entities: List<PredmetEntity>) {
        Timber.e("Delete and insert all")
        localDataSource.deleteAndInsertAll(entities)
    }

    override fun getAll(): Observable<List<Predmet>> {
        Timber.e("Get all")
        return localDataSource
            .getAll()
            .map {
                it.map {
                    Predmet(it.id, it.predmet, it.tip, it.nastavnik, it.ucionica, it.grupe, it.dan, it.termin)
                }
            }
    }

    override fun getByPredmet(predmet: String): Observable<List<PredmetEntity>> {
        return localDataSource.getByPredmet(predmet)
    }

    override fun getByNastavnik(nastavnik: String): Observable<List<PredmetEntity>> {
        return localDataSource.getByNastavnik(nastavnik)
    }

    override fun getByGrupa(grupe: String): Observable<List<PredmetEntity>> {
        return localDataSource.getByGrupa(grupe)
    }

    override fun getByDan(dan: String): Observable<List<PredmetEntity>> {
        return localDataSource.getByDan(dan)
    }

//    override fun getAllByName(name: String): Observable<List<Predmet>> {
//        TODO("Not yet implemented")
//    }

}