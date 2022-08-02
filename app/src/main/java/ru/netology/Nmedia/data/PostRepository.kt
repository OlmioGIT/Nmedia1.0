package ru.netology.Nmedia.data

import androidx.lifecycle.LiveData
import ru.netology.Nmedia.dto.Post

interface PostRepository {
    fun get(): LiveData<Post>
    fun like()
    fun share()
}