package uz.hamroev.careofchildren.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatDelegate
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import uz.hamroev.careofchildren.R
import uz.hamroev.careofchildren.adapter.PicturesAdapter
import uz.hamroev.careofchildren.adapter.SectionAdapter
import uz.hamroev.careofchildren.cache.Cache
import uz.hamroev.careofchildren.databinding.ActivitySubjectBinding
import uz.hamroev.careofchildren.model.Pictures

class SubjectActivity : AppCompatActivity() {
    lateinit var binding: ActivitySubjectBinding
    lateinit var listImage: ArrayList<Pictures>
    lateinit var picturesAdapter: PicturesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubjectBinding.inflate(layoutInflater)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        setContentView(binding.root)

        Cache.init(this)
        loadSubjects()
        picturesAdapter =
            PicturesAdapter(this, listImage, object : PicturesAdapter.OnPicturesClickListener {
                override fun onClick(pictures: Pictures, position: Int) {

                }
            })
        binding.rvPictures.adapter = picturesAdapter

    }

    private fun loadSubjects() {
        when (Cache.subjectNumber) {
            "0" -> {
                subject1()
            }
            "1" -> {
                subject2()
            }
            "2" -> {
                subject3()
            }
            "3" -> {
                subject4()
            }
            "4" -> {
                subject5()
            }
            "5" -> {
                subject6()
            }
            "6" -> {
                subject7()
            }
            "7" -> {
                subject8()
            }
            "8" -> {
                subject9()
            }
            "9" -> {
                subject10()
            }
            "10" -> {
                subject11()
            }
            "11" -> {
                subject12()
            }
            "12" -> {
                subject13()
            }
            "13" -> {
                subject14()
            }
            "14" -> {
                subject15()
            }
            "15" -> {
                subject16()
            }
            "16" -> {
                subject17()
            }
            "17" -> {
                subject18()
            }
            "18" -> {
                subject19()
            }
        }
    }


    fun subject1() {
        binding.sectionInfo.text = resources.getString(R.string.info1)
        listImage = ArrayList()
        listImage.clear()
        listImage.add(Pictures(R.drawable.img1))
        binding.sectionName.text = resources.getString(R.string.section1)
        loadVideo1("kcu_DoXkAzU")
        loadVideo2("ydM_XEYGcWA")


    }


    fun subject2() {
        binding.sectionInfo.text = resources.getString(R.string.info2)
        listImage = ArrayList()
        listImage.clear()
        listImage.add(Pictures(R.drawable.img2))
        listImage.add(Pictures(R.drawable.img2_1))
        binding.sectionName.text = resources.getString(R.string.section2)
        binding.cardVideo1.visibility = View.GONE
        binding.cardVideo2.visibility = View.GONE
    }

    fun subject3() {
        binding.sectionInfo.text = resources.getString(R.string.info3)
        listImage = ArrayList()
        listImage.clear()
        listImage.add(Pictures(R.drawable.img3_1))
        listImage.add(Pictures(R.drawable.img3_2))
        listImage.add(Pictures(R.drawable.img3_3))
        listImage.add(Pictures(R.drawable.img3_4))
        listImage.add(Pictures(R.drawable.img3_5))
        binding.sectionName.text = resources.getString(R.string.section3)
        loadVideo1("_aDvOdEdobI")
        loadVideo2("UHugJcBohT8")

    }

    fun subject4() {
        binding.sectionInfo.text = resources.getString(R.string.info4)
        listImage = ArrayList()
        listImage.clear()
        listImage.add(Pictures(R.drawable.img4))
        binding.sectionName.text = resources.getString(R.string.section4)
        loadVideo1("QiwEo7gsZkE")
        binding.cardVideo2.visibility = View.GONE
    }

    fun subject5() {
        binding.sectionInfo.text = resources.getString(R.string.info5)
        listImage = ArrayList()
        listImage.clear()
        listImage.add(Pictures(R.drawable.img5))
        binding.sectionName.text = resources.getString(R.string.section5)
        binding.cardVideo1.visibility = View.GONE
        binding.cardVideo2.visibility = View.GONE
    }

    fun subject6() {
        binding.sectionInfo.text = resources.getString(R.string.info6)
        listImage = ArrayList()
        listImage.clear()
        listImage.add(Pictures(R.drawable.img6))
        listImage.add(Pictures(R.drawable.img6_1))
        binding.sectionName.text = resources.getString(R.string.section6)
        loadVideo1("VsuCi1m7-UM")
        binding.cardVideo2.visibility = View.GONE
    }

    fun subject7() {
        binding.sectionInfo.text = resources.getString(R.string.info7)
        listImage = ArrayList()
        listImage.clear()
        listImage.add(Pictures(R.drawable.img7))
        binding.sectionName.text = resources.getString(R.string.section7)
        loadVideo1("75CHU6Kxc7Q")
        binding.cardVideo2.visibility = View.GONE
    }

    fun subject8() {
        binding.sectionInfo.text = resources.getString(R.string.info8)
        listImage = ArrayList()
        listImage.clear()
        listImage.add(Pictures(R.drawable.img8))
        binding.sectionName.text = resources.getString(R.string.section8)
        binding.cardVideo1.visibility = View.GONE
        binding.cardVideo2.visibility = View.GONE
    }

    fun subject9() {
        binding.sectionInfo.text = resources.getString(R.string.info9)
        listImage = ArrayList()
        listImage.clear()
        listImage.add(Pictures(R.drawable.img9))
        binding.sectionName.text = resources.getString(R.string.section9)
        loadVideo1("KjvyzaipS4U")
        binding.cardVideo2.visibility = View.GONE
    }

    fun subject10() {
        binding.sectionInfo.text = resources.getString(R.string.info10)
        listImage = ArrayList()
        listImage.clear()
        listImage.add(Pictures(R.drawable.img10))
        binding.sectionName.text = resources.getString(R.string.section10)
        loadVideo1("nTuX8jdz9ho")
        binding.cardVideo2.visibility = View.GONE
    }

    fun subject11() {
        binding.sectionInfo.text = resources.getString(R.string.info11)
        listImage = ArrayList()
        listImage.clear()
        listImage.add(Pictures(R.drawable.img11))
        listImage.add(Pictures(R.drawable.img11_1))
        listImage.add(Pictures(R.drawable.img11_2))
        listImage.add(Pictures(R.drawable.img11_3))
        binding.sectionName.text = resources.getString(R.string.section11)
        loadVideo1("KjbEnJ0VCrw")
        loadVideo2("wn5_tAacaS4")
    }

    fun subject12() {
        binding.sectionInfo.text = resources.getString(R.string.info12)
        listImage = ArrayList()
        listImage.clear()
        listImage.add(Pictures(R.drawable.img12))
        binding.sectionName.text = resources.getString(R.string.section12)
        loadVideo1("6S5ay8CSFNU")
        binding.cardVideo2.visibility = View.GONE
    }

    fun subject13() {
        binding.sectionInfo.text = resources.getString(R.string.info13)
        listImage = ArrayList()
        listImage.clear()
        listImage.add(Pictures(R.drawable.img13))
        listImage.add(Pictures(R.drawable.img13_1))
        listImage.add(Pictures(R.drawable.img13_2))
        binding.sectionName.text = resources.getString(R.string.section13)
        loadVideo1("zYWwxcZsVmQ")
        loadVideo2("f1MzWX5727w")
    }

    fun subject14() {
        binding.sectionInfo.text = resources.getString(R.string.info14)
        listImage = ArrayList()
        listImage.clear()
        listImage.add(Pictures(R.drawable.img14))
        listImage.add(Pictures(R.drawable.img14_1))
        binding.sectionName.text = resources.getString(R.string.section14)
        loadVideo1("uwOoZYVA0Ms")
        binding.cardVideo2.visibility = View.GONE
    }

    fun subject15() {
        binding.sectionInfo.text = resources.getString(R.string.info15)
        listImage = ArrayList()
        listImage.clear()
        listImage.add(Pictures(R.drawable.img15))
        binding.sectionName.text = resources.getString(R.string.section15)
        loadVideo1("6cJYSvzWCeE")
        binding.cardVideo2.visibility = View.GONE
    }

    fun subject16() {
        binding.sectionInfo.text = resources.getString(R.string.info16)
        listImage = ArrayList()
        listImage.clear()
        listImage.add(Pictures(R.drawable.img16))
        listImage.add(Pictures(R.drawable.img16_1))
        binding.sectionName.text = resources.getString(R.string.section16)
        loadVideo1("9FwnFUxfzuM")
        loadVideo2("oouD01dbKkY")
    }

    fun subject17() {
        binding.sectionInfo.text = resources.getString(R.string.info17)
        listImage = ArrayList()
        listImage.clear()
        listImage.add(Pictures(R.drawable.img17))
        listImage.add(Pictures(R.drawable.img17_1))
        binding.sectionName.text = resources.getString(R.string.section17)
        binding.cardVideo1.visibility = View.GONE
        binding.cardVideo2.visibility = View.GONE
    }

    fun subject18() {
        binding.sectionInfo.text = resources.getString(R.string.info18)
        listImage = ArrayList()
        listImage.clear()
        listImage.add(Pictures(R.drawable.img18))
        binding.sectionName.text = resources.getString(R.string.section18)
        loadVideo1("Jke4a-O15hk")
        binding.cardVideo2.visibility = View.GONE
    }

    fun subject19() {
        binding.sectionInfo.text = resources.getString(R.string.info19)
        listImage = ArrayList()
        listImage.clear()
        listImage.add(Pictures(R.drawable.img19))
        listImage.add(Pictures(R.drawable.img19_2))
        binding.sectionName.text = resources.getString(R.string.section19)
        loadVideo1("5B_7t1Cn-xE")
        binding.cardVideo2.visibility = View.GONE
    }

    private fun loadVideo1(videoId: String) {
        binding.youtubePlayer1.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                super.onReady(youTubePlayer)
                youTubePlayer.loadVideo(videoId, 0.0f)
                youTubePlayer.pause()
            }
        })
    }

    private fun loadVideo2(videoId: String) {
        binding.youtubePlayer2.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                super.onReady(youTubePlayer)
                youTubePlayer.loadVideo(videoId, 0.0f)
                youTubePlayer.pause()
            }
        })
    }

}