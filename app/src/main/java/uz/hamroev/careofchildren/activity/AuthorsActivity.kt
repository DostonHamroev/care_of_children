package uz.hamroev.careofchildren.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import uz.hamroev.careofchildren.R
import uz.hamroev.careofchildren.adapter.UserAdapter
import uz.hamroev.careofchildren.databinding.ActivityAuthorsBinding
import uz.hamroev.careofchildren.model.User

class AuthorsActivity : AppCompatActivity() {
    lateinit var binding: ActivityAuthorsBinding
    lateinit var list: ArrayList<User>
    lateinit var userAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthorsBinding.inflate(layoutInflater)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        setContentView(binding.root)


        binding.back.setOnClickListener {
            finish()
        }


        loadData()
        userAdapter = UserAdapter(this, list)
        binding.rvUsers.adapter = userAdapter
    }

    private fun loadData() {
        list = ArrayList()
        list.add(User(resources.getString(R.string.info_saida), R.drawable.ic_saida))
        list.add(User(resources.getString(R.string.info_kamila), R.drawable.ic_kamila))
        list.add(User(resources.getString(R.string.info_madina), R.drawable.ic_madina))

    }
}