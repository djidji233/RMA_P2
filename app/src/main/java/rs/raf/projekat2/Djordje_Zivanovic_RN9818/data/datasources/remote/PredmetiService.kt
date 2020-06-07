package rs.raf.projekat2.Djordje_Zivanovic_RN9818.data.datasources.remote

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import rs.raf.projekat2.Djordje_Zivanovic_RN9818.data.models.PredmetResponse

interface PredmetiService {

    @GET("raspored/json.php")
    fun getAll(@Query("limit") limit: Int = 1000): Observable<List<PredmetResponse>>

}