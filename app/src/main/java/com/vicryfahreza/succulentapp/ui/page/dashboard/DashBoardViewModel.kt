package com.vicryfahreza.succulentapp.ui.page.dashboard

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vicryfahreza.succulentapp.model.BookMarkSucculent
import com.vicryfahreza.succulentapp.model.repo.SucculentRepository
import com.vicryfahreza.succulentapp.ui.page.state.UIStatus
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class DashBoardViewModel (
    private val repository: SucculentRepository
) : ViewModel() {
    private val _uistatus: MutableStateFlow<UIStatus<List<BookMarkSucculent>>> = MutableStateFlow(UIStatus.Loading)
    val uistatus: StateFlow<UIStatus<List<BookMarkSucculent>>>
        get() = _uistatus

    private val _query = mutableStateOf("")
    val query: State<String> get() = _query

    fun search(newQuery: String) {
        _query.value = newQuery
        _uistatus.value = UIStatus.Success(repository.searchSucculent(_query.value))
    }

    fun getAllSucculents() {
        viewModelScope.launch {
            repository.getAllSucculents()
                .catch {
                    _uistatus.value = UIStatus.Error(it.message.toString())
                }
                .collect { orderRewards ->
                    _uistatus.value = UIStatus.Success(orderRewards)
                }
        }
    }
}