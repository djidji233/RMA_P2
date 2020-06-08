package rs.raf.projekat2.Djordje_Zivanovic_RN9818.presentation.contract

import androidx.lifecycle.LiveData
import rs.raf.projekat2.Djordje_Zivanovic_RN9818.presentation.view.states.PredmetiState

interface MainContract {

    interface ViewModel {

        val predmetiState: LiveData<PredmetiState>

        // za sad ovo
        fun fetchAllPredmeti()
        fun getAllPredmeti()

        fun getByPredmetOrNastavnik(filter: String)
        fun getByGrupa(grupe: String)
        fun getByDan(dan: String)
        fun getByGrupaAndDan(dan: String, grupa: String)
        fun getByGrupaAndPredmetOrNastavnik(grupa: String, filter: String)
        fun getByDanAndPredmetOrNastavnik(dan: String, filter: String)
        fun getByAllFilters(dan: String, filter: String, grupa: String)

    }
}