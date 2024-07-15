package com.vicryfahreza.succulentapp.ui.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vicryfahreza.succulentapp.model.repo.SucculentRepository
import com.vicryfahreza.succulentapp.ui.page.dashboard.DashBoardViewModel
import com.vicryfahreza.succulentapp.ui.page.detail.DetailViewModel

class ViewModelFactory(private val repo: SucculentRepository) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DashBoardViewModel::class.java)) {
            return DashBoardViewModel(repo) as T
        } else if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            return DetailViewModel(repo) as T
        }
        throw IllegalArgumentException("Not Found ViewModel class: " + modelClass.name)
    }

}