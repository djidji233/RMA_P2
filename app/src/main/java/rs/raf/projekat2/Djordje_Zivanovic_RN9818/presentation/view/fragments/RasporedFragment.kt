package rs.raf.projekat2.Djordje_Zivanovic_RN9818.presentation.view.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_raspored.*
import kotlinx.android.synthetic.main.predmet_list_item.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import rs.raf.projekat2.Djordje_Zivanovic_RN9818.R
import rs.raf.projekat2.Djordje_Zivanovic_RN9818.presentation.contract.MainContract
import rs.raf.projekat2.Djordje_Zivanovic_RN9818.presentation.view.recycler.adapter.PredmetAdapter
import rs.raf.projekat2.Djordje_Zivanovic_RN9818.presentation.view.recycler.diff.PredmetDiffItemCallback
import rs.raf.projekat2.Djordje_Zivanovic_RN9818.presentation.view.states.PredmetiState
import rs.raf.projekat2.Djordje_Zivanovic_RN9818.presentation.viewmodel.MainViewModel
import timber.log.Timber

class RasporedFragment : Fragment(R.layout.fragment_raspored){

    private lateinit var predmetAdapter: PredmetAdapter
    private val mainViewModel: MainContract.ViewModel by sharedViewModel<MainViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init(){
        initRecycler()
        initObservers()
    }

    private fun initRecycler(){
        recyclerList.layoutManager = LinearLayoutManager(this.context)
        predmetAdapter = PredmetAdapter(
            PredmetDiffItemCallback()
        )
        recyclerList.adapter = predmetAdapter
    }

    private fun initObservers(){
        mainViewModel.predmetiState.observe(viewLifecycleOwner, Observer {
            Timber.e(it.toString())
            renderState(it)
        })
        // Pravimo subscription kad observablu koji je vezan za getAll iz baze
        // Na svaku promenu tabele, obserrvable ce emitovati na onNext sve elemente
        // koji zadovoljavaju query
        mainViewModel.getAllPredmeti()
        // Pokrecemo operaciju dovlacenja podataka sa servera, kada podaci stignu,
        // bice sacuvani u bazi, tada ce se triggerovati observable na koji smo se pretplatili
        // preko metode getAllMovies()
        mainViewModel.fetchAllPredmeti()
    }

    private fun renderState(state: PredmetiState) {
        when (state) {
            is PredmetiState.Success -> {
                showLoadingState(false)
                predmetAdapter.submitList(state.predmeti)
            }
            is PredmetiState.Error -> {
                showLoadingState(false)
                Toast.makeText(context, state.message, Toast.LENGTH_SHORT).show()
            }
            is PredmetiState.DataFetched -> {
                showLoadingState(false)
                Toast.makeText(context, "Fresh data fetched from the server", Toast.LENGTH_LONG).show()
            }
            is PredmetiState.Loading -> {
                showLoadingState(true)
            }
        }
    }

    private fun showLoadingState(loading: Boolean) {
        spinnerGrupa.isVisible = !loading
        spinnerDan.isVisible = !loading
        recyclerList.isVisible = !loading
        profesor_predmetChoice.isVisible = !loading
    }

}
