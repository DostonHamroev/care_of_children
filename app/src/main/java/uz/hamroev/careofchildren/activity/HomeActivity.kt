package uz.hamroev.careofchildren.activity

import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.navigation.Navigation
import uz.hamroev.careofchildren.R
import uz.hamroev.careofchildren.cache.Cache
import uz.hamroev.careofchildren.databinding.ActivityHomeBinding
import uz.hamroev.careofchildren.databinding.DialogLanguageBinding
import java.util.*

class HomeActivity : AppCompatActivity() {

    lateinit var binding: ActivityHomeBinding

    var isBack = false
    lateinit var handler: Handler
    var doubleToast = "Пожалуйста, нажмите НАЗАД еще раз, чтобы выйти"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Cache.init(this)
        checkLanguage()

        val navController = Navigation.findNavController(this, R.id.my_nav_host_fragment)

        binding.menuBtn.setOnClickListener {
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