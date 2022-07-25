package ru.netology.Nmedia
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import kotlinx.android.synthetic.main.activity_main.*
import ru.netology.Nmedia.R
import ru.netology.Nmedia.databinding.ActivityMainBinding
import ru.netology.Nmedia.servicecode.plural
import ru.netology.Nmedia.viewmodel.PostViewModel


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val viewModel: PostViewModel by viewModels()
        viewModel.data.observe(this) { post ->
            with(binding) {
                author.text = post.author
                published.text = post.published
                content.text = post.content
                likes.setImageResource(
                    if (post.likedByMe) R.drawable.ic_likes_24dp_red else R.drawable.ic_likes_24dp
                )
                menu.setImageResource(R.drawable.ic_menu_24)
                share.setImageResource(R.drawable.ic_share_24)
                avatar.setImageResource(R.drawable.posts_avatar_foreground)
                seen.setImageResource(R.drawable.ic_eye_24)
                likes_counter.text = plural(post.likes, 'K', 'M')
                share_counter.text = plural(post.share, 'K', 'M')
                seen_counter.text = plural(post.seen, 'K', 'M')
            }
        }
        binding.root.setOnClickListener {
            Log.d("stuff", "stuff")
        }
        binding.avatar.setOnClickListener {
            Log.d("stuff", "avatar")
        }

        binding.likes.setOnClickListener {
            Log.d("stuff", "like")
            viewModel.like()
        }

        binding.share.setOnClickListener {
            Log.d("stuff", "shared")
            viewModel.share()
        }

        binding.seen.setOnClickListener {
            Log.d("stuff", "viewed")
        }
    }
}




