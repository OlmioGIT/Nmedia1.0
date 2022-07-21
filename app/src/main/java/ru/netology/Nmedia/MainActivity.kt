package ru.netology.Nmedia
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import ru.netology.Nmedia.R
import ru.netology.Nmedia.databinding.ActivityMainBinding
import ru.netology.Nmedia.dto.Post
import ru.netology.Nmedia.servicecode.plural

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val post = Post(
            id = 1,
            author = "Нетология. Университет интернет-профессий будущего",
            content = "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. Затем появились курсы по дизайну, разработке, аналитике и управлению. Мы растём сами и помогаем расти студентам: от новичков до уверенных профессионалов. Но самое важное остаётся с нами: мы верим, что в каждом уже есть сила, которая заставляет хотеть больше, целиться выше, бежать быстрее. Наша миссия — помочь встать на путь роста и начать цепочку перемен → http://netolo.gy/fyb",
            published = "21 мая в 18:36",
            likedByMe = false,
            likes = 999,
            share = 9996,
            seen = 2
        )
        with(binding) {
            author.text = post.author
            published.text = post.published
            content.text = post.content
            if (post.likedByMe) {
                likes.setImageResource(R.drawable.ic_likes_24dp_red)
            } else {
                likes.setImageResource(R.drawable.ic_likes_24dp)
            }
            menu.setImageResource(R.drawable.ic_menu_24)
            share.setImageResource(R.drawable.ic_share_24)
            avatar.setImageResource(R.drawable.ic_share_24)
            seen.setImageResource(R.drawable.ic_eye_24)
            likes_counter.text = plural(post.likes,'K', 'M')
            share_counter.text = plural(post.share,'K', 'M')
            seen_counter.text = plural(post.seen,'K', 'M')

            root.setOnClickListener {
                Log.d("stuff", "stuff")
            }

            avatar.setOnClickListener {
                Log.d("stuff", "avatar")
            }

            likes.setOnClickListener {
                Log.d("stuff", "like")
                post.likedByMe = !post.likedByMe
                likes.setImageResource(
                    if (post.likedByMe) R.drawable.ic_likes_24dp_red else R.drawable.ic_likes_24dp
                )
                if (post.likedByMe) post.likes++ else post.likes--
                likes_counter.text = plural(post.likes,'K', 'M')
            }

            share.setOnClickListener {
                Log.d("stuff", "share")
                share_counter.text = plural(post.share++,'K', 'M')
            }

            seen.setOnClickListener {
                Log.d("stuff", "viewed")
            }
        }
    }
}


