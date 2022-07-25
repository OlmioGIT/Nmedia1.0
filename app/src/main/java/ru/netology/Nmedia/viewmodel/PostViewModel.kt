package ru.netology.Nmedia.viewmodel

import androidx.lifecycle.ViewModel
import ru.netology.Nmedia.data.InMemoryPostRepositoryImpl
import ru.netology.Nmedia.data.PostRepository

class PostViewModel : ViewModel() {
    private val repository: PostRepository = InMemoryPostRepositoryImpl()
    val data = repository.get()
    fun like() = repository.like()
    fun share() = repository.share()
}