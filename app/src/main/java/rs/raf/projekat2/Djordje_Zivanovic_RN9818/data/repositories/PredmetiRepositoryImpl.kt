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

    override fun getByPredmetOrNastavnik(filter: String): Observable<List<Predmet>> {
        return localDataSource.getByPredmetOrNastavnik(filter).map{
            it.map {
                Predmet(it.id, it.predmet, it.tip, it.nastavnik, it.ucionica, it.grupe, it.dan, it.termin)
            }
        }
    }

    override fun getByGrupa(grupe: String): Observable<List<Predmet>> {
        return localDataSource.getByGrupa(grupe).map{
            it.map {
                Predmet(it.id, it.predmet, it.tip, it.nastavnik, it.ucionica, it.grupe, it.dan, it.termin)
            }
        }
    }

    override fun getByDan(dan: String): Observable<List<Predmet>> {
        return localDataSource.getByDan(dan).map{
            it.map {
                Predmet(it.id, it.predmet, it.tip, it.nastavnik, it.ucionica, it.grupe, it.dan, it.termin)
            }
        }
    }

    override fun getByGrupaAndDan(dan: String, grupa: String): Observable<List<Predmet>> {
        return localDataSource.getByGrupaAndDan(dan, grupa).map{
            it.map {
                Predmet(it.id, it.predmet, it.tip, it.nastavnik, it.ucionica, it.grupe, it.dan, it.termin)
            }
        }
    }

    override fun getByGrupaAndPredmetOrNastavnik(
        grupa: String,
        filter: String
    ): Observable<List<Predmet>> {
        return localDataSource.getByGrupaAndPredmetOrNastavnik(grupa,filter).map{
            it.map {
                Predmet(it.id, it.predmet, it.tip, it.nastavnik, it.ucionica, it.grupe, it.dan, it.termin)
            }
        }
    }

    override fun getByDanAndPredmetOrNastavnik(
        dan: String,
        filter: String
    ): Observable<List<Predmet>> {
        return localDataSource.getByDanAndPredmetOrNastavnik(dan,filter).map{
            it.map {
                Predmet(it.id, it.predmet, it.tip, it.nastavnik, it.ucionica, it.grupe, it.dan, it.termin)
            }
        }
    }

    override fun getByAllFilters(
        dan: String,
        filter: String,
        grupa: String
    ): Observable<List<Predmet>> {
        return localDataSource.getByAllFilters(dan, filter, grupa).map{
            it.map {
                Predmet(it.id, it.predmet, it.tip, it.nastavnik, it.ucionica, it.grupe, it.dan, it.termin)
            }
        }
    }

}