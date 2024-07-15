package com.vicryfahreza.succulentapp.model.repo

import com.vicryfahreza.succulentapp.model.BookMarkSucculent
import com.vicryfahreza.succulentapp.model.SucculentsData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class SucculentRepository {

    private val bookMarkSucculent = mutableListOf<BookMarkSucculent>()

    init {
        if (bookMarkSucculent.isEmpty()) {
            SucculentsData.succulents.forEach {
                bookMarkSucculent.add(BookMarkSucculent(it, false))
            }
        }
    }

    fun searchSucculent(query: String): List<BookMarkSucculent>{
        return bookMarkSucculent.filter {
            it.succulent.name.contains(query, ignoreCase = true)
        }
    }

    fun getAllSucculents(): Flow<List<BookMarkSucculent>> {
        return flowOf(bookMarkSucculent)
    }

    fun getSucculentById(succulentId: Long): Flow<BookMarkSucculent> {
        return flowOf(
            bookMarkSucculent.first { it.succulent.id == succulentId }
        )
    }


    companion object {
        @Volatile
        private var instance: SucculentRepository? = null

        fun getInstance(): SucculentRepository =
            instance ?: synchronized(this) {
                SucculentRepository().apply {
                    instance = this
                }
            }
    }
}
