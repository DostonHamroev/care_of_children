package uz.hamroev.careofchildren

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import android.view.animation.AnimationUtils
import uz.hamroev.careofchildren.activity.HomeActivity
import uz.hamroev.careofchildren.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        supportActionBar?.hide()
        startAnimation()

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }, 1500)


    }

    private fun startAnimation() {
        val anim_intro_card = AnimationUtils.loadAnimation(this, R.anim.anim_intro_card)
        binding.cardLogo.startAnimation(anim_intro_card)
        binding.typeWriter.animateText("Care of Children")
        binding.typeWriter.setCharacterDeley(50)
    }
}