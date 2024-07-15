package com.vicryfahreza.succulentapp.ui.page.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vicryfahreza.succulentapp.model.BookMarkSucculent
import com.vicryfahreza.succulentapp.model.repo.SucculentRepository
import com.vicryfahreza.succulentapp.ui.page.state.UIStatus
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class DetailViewModel(
    private val repo: SucculentRepository
) : ViewModel() {
    private val _uiStatus: MutableStateFlow<UIStatus<BookMarkSucculent>> =
        MutableStateFlow(UIStatus.Loading)
    val uiStatus: StateFlow<UIStatus<BookMarkSucculent>>
        get() = _uiStatus

    fun getSucculentById(succulentId: Long) {
        viewModelScope.launch {
                repo.getSucculentById(succulentId)
                    .catch {
                        _uiStatus.value = UIStatus.Error(it.message.toString())
                    }
                    .collect { detailSneakers ->
                        _uiStatus.value = UIStatus.Success(detailSneakers)
                    }
            }
        }



}