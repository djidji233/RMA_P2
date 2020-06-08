package rs.raf.projekat2.Djordje_Zivanovic_RN9818.data.repositories

import io.reactivex.Completable
import io.reactivex.Observable
import rs.raf.projekat2.Djordje_Zivanovic_RN9818.data.datasources.local.BeleskaDao
import rs.raf.projekat2.Djordje_Zivanovic_RN9818.data.models.Beleska
import rs.raf.projekat2.Djordje_Zivanovic_RN9818.data.models.BeleskaEntity

class BeleskeRepositoryImpl(
    private val dataSource: BeleskaDao
) : BeleskeRepository {

    override fun insert(entity: BeleskaEntity): Completable {
        return dataSource.insert(entity)
    }

    override fun delete(id: Long) {
        dataSource.delete(id)
    }

    override fun getAll(): Observable<List<Beleska>> {
        return dataSource.getAll().map {
            it.map {
                Beleska(it.id, it.title, it.content)
            }
        }
    }

    override fun update(id: Long, title: String, content: String): Completable {
        return dataSource.update(id, title, content)
    }


}