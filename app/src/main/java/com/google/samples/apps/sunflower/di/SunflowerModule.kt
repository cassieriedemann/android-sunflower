package com.google.samples.apps.sunflower.di

import com.google.samples.apps.sunflower.data.AppDatabase
import com.google.samples.apps.sunflower.data.GardenPlantingRepository
import com.google.samples.apps.sunflower.data.PlantRepository
import com.google.samples.apps.sunflower.viewmodels.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.experimental.builder.viewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val sunflowerModule = module {
    module("app") {
        single { AppDatabase.getInstance(androidContext()) }
        single { get<AppDatabase>().plantDao() }
        single { get<AppDatabase>().gardenPlantingDao() }
        single { PlantRepository.getInstance(get()) }
        single { GardenPlantingRepository.getInstance(get()) }

        viewModel<GardenPlantingListViewModel>()
        viewModel<PlantListViewModel>()
        viewModel { (plantId: String) -> PlantDetailViewModel(get(), get(), plantId) }
    }
}
