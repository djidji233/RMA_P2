package rs.raf.projekat2.Djordje_Zivanovic_RN9818.modules

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import rs.raf.projekat2.Djordje_Zivanovic_RN9818.data.datasources.local.PredmetiDataBase
import rs.raf.projekat2.Djordje_Zivanovic_RN9818.data.datasources.remote.PredmetiService
import rs.raf.projekat2.Djordje_Zivanovic_RN9818.data.repositories.PredmetiRepository
import rs.raf.projekat2.Djordje_Zivanovic_RN9818.data.repositories.PredmetiRepositoryImpl
import rs.raf.projekat2.Djordje_Zivanovic_RN9818.presentation.viewmodel.MainViewModel

val predmetModule = module {

    viewModel { MainViewModel(predmetiRepository = get()) }

    single<PredmetiRepository> { PredmetiRepositoryImpl(localDataSource = get(), remoteDataSource = get()) }

    single { get<PredmetiDataBase>().getPredmetiDao() }

    single<PredmetiService> { create(retrofit = get()) }

}

