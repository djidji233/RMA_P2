package rs.raf.projekat2.Djordje_Zivanovic_RN9818.presentation.viewmodel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import rs.raf.projekat2.Djordje_Zivanovic_RN9818.data.models.Resource
import rs.raf.projekat2.Djordje_Zivanovic_RN9818.data.repositories.PredmetiRepository
import rs.raf.projekat2.Djordje_Zivanovic_RN9818.presentation.contract.MainContract
import rs.raf.projekat2.Djordje_Zivanovic_RN9818.presentation.view.states.PredmetiState
import timber.log.Timber
import java.util.concurrent.TimeUnit

class MainViewModel(
    private val predmetiRepository: PredmetiRepository
) : ViewModel(), MainContract.ViewModel {

    private val subscriptions = CompositeDisposable()
    override val predmetiState: MutableLiveData<PredmetiState> = MutableLiveData()

    private val publishSubject: PublishSubject<String> = PublishSubject.create()

    override fun fetchAllPredmeti() {
        val subscription = predmetiRepository
            .fetchAll()
            .startWith(Resource.Loading()) //Kada se pokrene fetch hocemo da postavimo stanje na Loading
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    when(it) {
                        is Resource.Loading -> predmetiState.value = PredmetiState.Loading
                        is Resource.Success -> predmetiState.value = PredmetiState.DataFetched
                        is Resource.Error -> predmetiState.value = PredmetiState.Error("Error happened while fetching data from the server")
                    }
                },
                {
                    predmetiState.value = PredmetiState.Error("Error happened while fetching data from the server")
                    Timber.e(it)
                }
            )
        subscriptions.add(subscription)
    }



    override fun getAllPredmeti() {
        val subscription = predmetiRepository
            .getAll()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    predmetiState.value = PredmetiState.Success(it)
                },
                {
                    predmetiState.value = PredmetiState.Error("Error fetching from DB - getAllPredmeti")
                    Timber.e(it)
                }
            )
        subscriptions.add(subscription)
    }

    override fun getByPredmetOrNastavnik(filter: String) {
        val subscription = predmetiRepository
            .getByPredmetOrNastavnik(filter)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    predmetiState.value = PredmetiState.Success(it)
                },
                {
                    predmetiState.value = PredmetiState.Error("Error fetching from DB - getByPredmetOrNastavnik")
                    Timber.e(it)
                }
            )
        subscriptions.add(subscription)
    }

    override fun getByGrupa(grupe: String) {
        val subscription = predmetiRepository
            .getByGrupa(grupe)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    predmetiState.value = PredmetiState.Success(it)
                },
                {
                    predmetiState.value = PredmetiState.Error("Error fetching from DB - getByGrupa")
                    Timber.e(it)
                }
            )
        subscriptions.add(subscription)
    }

    override fun getByDan(dan: String) {
        val subscription = predmetiRepository
            .getByDan(dan)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    predmetiState.value = PredmetiState.Success(it)
                },
                {
                    predmetiState.value = PredmetiState.Error("Error fetching from DB - getByDan")
                    Timber.e(it)
                }
            )
        subscriptions.add(subscription)
    }

    override fun getByGrupaAndDan(dan: String, grupa: String) {
        val subscription = predmetiRepository
            .getByGrupaAndDan(dan, grupa)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    predmetiState.value = PredmetiState.Success(it)
                },
                {
                    predmetiState.value = PredmetiState.Error("Error fetching from DB - getByGrupaAndDan")
                    Timber.e(it)
                }
            )
        subscriptions.add(subscription)
    }

    override fun getByGrupaAndPredmetOrNastavnik(grupa: String, filter: String) {
        val subscription = predmetiRepository
            .getByGrupaAndPredmetOrNastavnik(grupa, filter)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    predmetiState.value = PredmetiState.Success(it)
                },
                {
                    predmetiState.value = PredmetiState.Error("Error fetching from DB - getByGrupaAndPredmetOrNastavnik")
                    Timber.e(it)
                }
            )
        subscriptions.add(subscription)
    }

    override fun getByDanAndPredmetOrNastavnik(dan: String, filter: String) {
        val subscription = predmetiRepository
            .getByDanAndPredmetOrNastavnik(dan, filter)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    predmetiState.value = PredmetiState.Success(it)
                },
                {
                    predmetiState.value = PredmetiState.Error("Error fetching from DB - getByDanAndPredmetOrNastavnik")
                    Timber.e(it)
                }
            )
        subscriptions.add(subscription)
    }

    override fun getByAllFilters(dan: String, filter: String, grupa: String) {
        val subscription = predmetiRepository
            .getByAllFilters(dan, filter, grupa)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    predmetiState.value = PredmetiState.Success(it)
                },
                {
                    predmetiState.value = PredmetiState.Error("Error fetching from DB - getByAllFilters")
                    Timber.e(it)
                }
            )
        subscriptions.add(subscription)
    }

    override fun onCleared() {
        super.onCleared()
        subscriptions.dispose()
    }


}