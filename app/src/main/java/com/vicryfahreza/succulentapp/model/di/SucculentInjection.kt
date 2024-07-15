package com.vicryfahreza.succulentapp.model.di

import com.vicryfahreza.succulentapp.model.repo.SucculentRepository

object SucculentInjection {
    fun provideRepository(): SucculentRepository {
        return SucculentRepository.getInstance()
    }
}