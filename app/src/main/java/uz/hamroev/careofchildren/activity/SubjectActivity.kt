package uz.hamroev.careofchildren.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
        listImage = ArrayList()
        listImage.clear()
        listImage.add(Pictures(R.drawable.img_19))
        listImage.add(Pictures(R.drawable.img_19))
        binding.sectionName.text = resources.getString(R.string.section1)
        binding.youtubePlayer.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                super.onReady(youTubePlayer)
                val vidId = "kcu_DoXkAzU"
                youTubePlayer.loadVideo(vidId, 0.0f)
                youTubePlayer.pause()
            }
        })

    }

    fun subject2() {
        listImage = ArrayList()
        listImage.clear()
        listImage.add(Pictures(R.drawable.img_19))
        listImage.add(Pictures(R.drawable.img_19))
        binding.sectionName.text = resources.getString(R.string.section2)
    }

    fun subject3() {
        listImage = ArrayList()
        listImage.clear()
        listImage.add(Pictures(R.drawable.img_19))
        listImage.add(Pictures(R.drawable.img_19))
        binding.sectionName.text = resources.getString(R.string.section3)
    }

    fun subject4() {
        listImage = ArrayList()
        listImage.clear()
        listImage.add(Pictures(R.drawable.img_19))
        listImage.add(Pictures(R.drawable.img_19))
        binding.sectionName.text = resources.getString(R.string.section4)
    }

    fun subject5() {
        listImage = ArrayList()
        listImage.clear()
        listImage.add(Pictures(R.drawable.img_19))
        listImage.add(Pictures(R.drawable.img_19))
        binding.sectionName.text = resources.getString(R.string.section5)
    }

    fun subject6() {
        listImage = ArrayList()
        listImage.clear()
        listImage.add(Pictures(R.drawable.img_19))
        listImage.add(Pictures(R.drawable.img_19))
        binding.sectionName.text = resources.getString(R.string.section6)
    }

    fun subject7() {
        listImage = ArrayList()
        listImage.clear()
        listImage.add(Pictures(R.drawable.img_19))
        listImage.add(Pictures(R.drawable.img_19))
        binding.sectionName.text = resources.getString(R.string.section7)
    }

    fun subject8() {
        listImage = ArrayList()
        listImage.clear()
        listImage.add(Pictures(R.drawable.img_19))
        listImage.add(Pictures(R.drawable.img_19))
        binding.sectionName.text = resources.getString(R.string.section8)
    }

    fun subject9() {
        listImage = ArrayList()
        listImage.clear()
        listImage.add(Pictures(R.drawable.img_19))
        listImage.add(Pictures(R.drawable.img_19))
        binding.sectionName.text = resources.getString(R.string.section9)
    }

    fun subject10() {
        listImage = ArrayList()
        listImage.clear()
        listImage.add(Pictures(R.drawable.img_19))
        listImage.add(Pictures(R.drawable.img_19))
        binding.sectionName.text = resources.getString(R.string.section10)
    }

    fun subject11() {
        listImage = ArrayList()
        listImage.clear()
        listImage.add(Pictures(R.drawable.img_19))
        listImage.add(Pictures(R.drawable.img_19))
        binding.sectionName.text = resources.getString(R.string.section11)
    }

    fun subject12() {
        listImage = ArrayList()
        listImage.clear()
        listImage.add(Pictures(R.drawable.img_19))
        listImage.add(Pictures(R.drawable.img_19))
        binding.sectionName.text = resources.getString(R.string.section12)
    }

    fun subject13() {
        listImage = ArrayList()
        listImage.clear()
        listImage.add(Pictures(R.drawable.img_19))
        listImage.add(Pictures(R.drawable.img_19))
        binding.sectionName.text = resources.getString(R.string.section13)
    }

    fun subject14() {
        listImage = ArrayList()
        listImage.clear()
        listImage.add(Pictures(R.drawable.img_19))
        listImage.add(Pictures(R.drawable.img_19))
        binding.sectionName.text = resources.getString(R.string.section14)
    }

    fun subject15() {
        listImage = ArrayList()
        listImage.clear()
        listImage.add(Pictures(R.drawable.img_19))
        listImage.add(Pictures(R.drawable.img_19))
        binding.sectionName.text = resources.getString(R.string.section15)
    }

    fun subject16() {
        listImage = ArrayList()
        listImage.clear()
        listImage.add(Pictures(R.drawable.img_19))
        listImage.add(Pictures(R.drawable.img_19))
        binding.sectionName.text = resources.getString(R.string.section16)
    }

    fun subject17() {
        listImage = ArrayList()
        listImage.clear()
        listImage.add(Pictures(R.drawable.img_19))
        listImage.add(Pictures(R.drawable.img_19))
        binding.sectionName.text = resources.getString(R.string.section17)
    }

    fun subject18() {
        listImage = ArrayList()
        listImage.clear()
        listImage.add(Pictures(R.drawable.img_19))
        listImage.add(Pictures(R.drawable.img_19))
        binding.sectionName.text = resources.getString(R.string.section18)
    }

    fun subject19() {
        listImage = ArrayList()
        listImage.clear()
        listImage.add(Pictures(R.drawable.img_19))
        listImage.add(Pictures(R.drawable.img_19))
        binding.sectionName.text = resources.getString(R.string.section19)
    }

}