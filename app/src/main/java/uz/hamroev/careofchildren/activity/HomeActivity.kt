package uz.hamroev.careofchildren.activity

import android.app.AlertDialog
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.GravityCompat
import androidx.navigation.Navigation
import uz.hamroev.careofchildren.R
import uz.hamroev.careofchildren.adapter.NavAdapter
import uz.hamroev.careofchildren.cache.Cache
import uz.hamroev.careofchildren.databinding.ActivityHomeBinding
import uz.hamroev.careofchildren.databinding.DialogLanguageBinding
import uz.hamroev.careofchildren.model.Nav
import java.util.*
import kotlin.collections.ArrayList

class HomeActivity : AppCompatActivity() {

    lateinit var binding: ActivityHomeBinding

    var isBack = false
    lateinit var handler: Handler
    var doubleToast = "Пожалуйста, нажмите НАЗАД еще раз, чтобы выйти"

    lateinit var listNav: ArrayList<Nav>
    lateinit var navAdapter: NavAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        setContentView(binding.root)

        Cache.init(this)
        checkLanguage()

        val navController = Navigation.findNavController(this, R.id.my_nav_host_fragment)

        loadNavMenu()
        navAdapter = NavAdapter(this, listNav, object : NavAdapter.OnNavClickListener {
            override fun onClick(nav: Nav, position: Int) {
                when (position) {
                    0 -> {
                        navController.popBackStack()
                        navController.navigate(R.id.homeFragment)
                        binding.drawerLayout.closeDrawers()
                    }
                    1 -> {
                        startActivity(Intent(this@HomeActivity, AuthorsActivity::class.java))
                        binding.drawerLayout.closeDrawers()
                    }
                    2 -> {
                        try {
                            val intent = Intent(Intent.ACTION_SEND)
                            intent.setType("text/plain")
                            intent.putExtra(Intent.EXTRA_SUBJECT, "Care of Children")
                            val shareMessage: String =
                                "https://play.google.com/store/apps/details?id=$packageName"
                            intent.putExtra(Intent.EXTRA_TEXT, shareMessage)
                            startActivity(Intent.createChooser(intent, "share by"))
                        } catch (e: Exception) {
                        }
                        binding.drawerLayout.closeDrawers()
                    }
                    3 -> {
                        try {
                            val uri: Uri = Uri.parse("market://details?id=$packageName")
                            val intent = Intent(Intent.ACTION_VIEW, uri)
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                            startActivity(intent)
                        } catch (e: ActivityNotFoundException) {
                            val uri: Uri =
                                Uri.parse("http://play.google.com/store/apps/details?id=$packageName")
                            val intent = Intent(Intent.ACTION_VIEW, uri)
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                            startActivity(intent)
                        }
                        binding.drawerLayout.closeDrawers()
                    }
                    4 -> {
                        binding.drawerLayout.closeDrawers()
                        finish()
                    }
                }
            }
        })
        binding.rvNav.adapter = navAdapter


        binding.menuBtn.setOnClickListener {
            checkLanguage()
            loadNavMenu()
            binding.drawerLayout.open()
        }


        binding.languageBtn.setOnClickListener {
            val alertDialog = AlertDialog.Builder(binding.root.context)
            val dialog = alertDialog.create()
            val bindingLanguage =
                DialogLanguageBinding.inflate(LayoutInflater.from(applicationContext))
            dialog.setView(bindingLanguage.root)
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.setCancelable(true)

            bindingLanguage.textRu.text = resources.getString(R.string.language_rus)
            bindingLanguage.textUk.text = resources.getString(R.string.language_eng)

            bindingLanguage.russian.setOnClickListener {
                Cache.language = "ru"
                navController.popBackStack()
                navController.navigate(R.id.homeFragment)
                checkLanguage()
                dialog.dismiss()
            }
            bindingLanguage.uk.setOnClickListener {
                Cache.language = "en"
                navController.popBackStack()
                navController.navigate(R.id.homeFragment)
                checkLanguage()
                dialog.dismiss()
            }


            dialog.show()

        }


    }

    private fun loadNavMenu() {
        listNav = ArrayList()
        listNav.add(Nav(resources.getString(R.string.home), R.drawable.ic_home))
        listNav.add(Nav(resources.getString(R.string.users), R.drawable.ic_users))
        listNav.add(Nav(resources.getString(R.string.share), R.drawable.ic_share))
        listNav.add(Nav(resources.getString(R.string.rate), R.drawable.ic_rate))
        listNav.add(Nav(resources.getString(R.string.exit), R.drawable.ic_exit))
    }

    override fun onSupportNavigateUp(): Boolean {
        return Navigation.findNavController(this, R.id.my_nav_host_fragment).navigateUp()
    }

    override fun onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            if (isBack) {
                super.onBackPressed()
                return
            }

            this.isBack = true
            handler = Handler(Looper.getMainLooper())
            Toast.makeText(this, "$doubleToast", Toast.LENGTH_SHORT).show()
            handler.postDelayed({
                isBack = false
            }, 1000)
        }

    }

    private fun checkLanguage() {
        when (Cache.language) {
            "en" -> {
                setAppLocale(this, "en")
            }
            "ru" -> {
                setAppLocale(this, "ru")
            }
            "uz" -> {
                setAppLocale(this, "uz")
            }
        }
    }

    fun setAppLocale(context: Context, language: String) {
        val locale = Locale(language)
        Locale.setDefault(locale)
        val config = context.resources.configuration
        config.setLocale(locale)
        context.createConfigurationContext(config)
        context.resources.updateConfiguration(
            config,
            context.resources.displayMetrics
        )
    }


}