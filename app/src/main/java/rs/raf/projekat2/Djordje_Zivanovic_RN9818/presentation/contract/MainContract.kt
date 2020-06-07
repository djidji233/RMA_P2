package rs.raf.projekat2.Djordje_Zivanovic_RN9818.presentation.contract

import androidx.lifecycle.LiveData
import rs.raf.projekat2.Djordje_Zivanovic_RN9818.presentation.view.states.PredmetiState

interface MainContract {

    interface ViewModel {

        val predmetiState: LiveData<PredmetiState>

        // za sad ovo
        fun fetchAllPredmeti()
        fun getAllPredmeti()

    }
}