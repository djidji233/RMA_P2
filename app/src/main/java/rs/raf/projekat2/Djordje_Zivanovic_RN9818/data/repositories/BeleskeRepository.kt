package rs.raf.projekat2.Djordje_Zivanovic_RN9818.data.repositories

import io.reactivex.Completable
import io.reactivex.Observable
import rs.raf.projekat2.Djordje_Zivanovic_RN9818.data.models.Beleska
import rs.raf.projekat2.Djordje_Zivanovic_RN9818.data.models.BeleskaEntity

interface BeleskeRepository {


    fun insert(entity: BeleskaEntity): Completable
    fun delete(id: Long)
    fun getAll(): Observable<List<Beleska>>
    fun update(id: Long, title:String, content: String): Completable


}