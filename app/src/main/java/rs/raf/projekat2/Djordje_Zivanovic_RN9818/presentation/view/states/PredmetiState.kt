package rs.raf.projekat2.Djordje_Zivanovic_RN9818.presentation.view.states

import rs.raf.projekat2.Djordje_Zivanovic_RN9818.data.models.Predmet

sealed class PredmetiState {
    object Loading: PredmetiState()
    object DataFetched: PredmetiState()
    data class Success(val predmeti: List<Predmet>): PredmetiState()
    data class Error(val message: String): PredmetiState()
}