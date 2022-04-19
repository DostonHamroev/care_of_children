package uz.hamroev.careofchildren.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.snackbar.Snackbar
import uz.hamroev.careofchildren.R
import uz.hamroev.careofchildren.activity.SubjectActivity
import uz.hamroev.careofchildren.adapter.SectionAdapter
import uz.hamroev.careofchildren.cache.Cache
import uz.hamroev.careofchildren.databinding.FragmentHomeBinding
import uz.hamroev.careofchildren.model.Section
import java.util.*
import kotlin.collections.ArrayList

class HomeFragment : Fragment() {


    lateinit var binding: FragmentHomeBinding
    lateinit var sectionAdapter: SectionAdapter
    lateinit var list: ArrayList<Section>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

        checkLanguage()
        loadData()
        startAnimation()
        sectionAdapter = SectionAdapter(
            binding.root.context,
            list,
            object : SectionAdapter.OnSectionClickListener {
                override fun onCLick(section: Section, position: Int) {
                    when (position) {
                        0 -> {
                            Cache.subjectNumber = "0"
                            startActivity(Intent(binding.root.context, SubjectActivity::class.java))
                        }
                        1 -> {
                            Cache.subjectNumber = "1"
                            startActivity(Intent(binding.root.context, SubjectActivity::class.java))
                        }
                        2 -> {
                            Cache.subjectNumber = "2"
                            startActivity(Intent(binding.root.context, SubjectActivity::class.java))
                        }
                        3 -> {
                            Cache.subjectNumber = "3"
                            startActivity(Intent(binding.root.context, SubjectActivity::class.java))
                        }
                        4 -> {
                            Cache.subjectNumber = "4"
                            startActivity(Intent(binding.root.context, SubjectActivity::class.java))
                        }
                        5 -> {
                            Cache.subjectNumber = "5"
                            startActivity(Intent(binding.root.context, SubjectActivity::class.java))
                        }
                        6 -> {
                            Cache.subjectNumber = "6"
                            startActivity(Intent(binding.root.context, SubjectActivity::class.java))
                        }
                        7 -> {
                            Cache.subjectNumber = "7"
                            startActivity(Intent(binding.root.context, SubjectActivity::class.java))
                        }
                        8 -> {
                            Cache.subjectNumber = "8"
                            startActivity(Intent(binding.root.context, SubjectActivity::class.java))
                        }
                        9 -> {
                            Cache.subjectNumber = "9"
                            startActivity(Intent(binding.root.context, SubjectActivity::class.java))
                        }
                        10 -> {
                            Cache.subjectNumber = "10"
                            startActivity(Intent(binding.root.context, SubjectActivity::class.java))
                        }
                        11 -> {
                            Cache.subjectNumber = "11"
                            startActivity(Intent(binding.root.context, SubjectActivity::class.java))
                        }
                        12 -> {
                            Cache.subjectNumber = "12"
                            startActivity(Intent(binding.root.context, SubjectActivity::class.java))
                        }
                        13 -> {
                            Cache.subjectNumber = "13"
                            startActivity(Intent(binding.root.context, SubjectActivity::class.java))
                        }
                        14 -> {
                            Cache.subjectNumber = "14"
                            startActivity(Intent(binding.root.context, SubjectActivity::class.java))
                        }
                        15 -> {
                            Cache.subjectNumber = "15"
                            startActivity(Intent(binding.root.context, SubjectActivity::class.java))
                        }
                        16 -> {
                            Cache.subjectNumber = "16"
                            startActivity(Intent(binding.root.context, SubjectActivity::class.java))
                        }
                        17 -> {
                            Cache.subjectNumber = "17"
                            startActivity(Intent(binding.root.context, SubjectActivity::class.java))
                        }
                        18 -> {
                            Cache.subjectNumber = "18"
                            startActivity(Intent(binding.root.context, SubjectActivity::class.java))
                        }
                    }
                }
            })
        binding.rvSection.adapter = sectionAdapter

        binding.cardLogo.setOnLongClickListener {
            val snacbar = Snackbar.make(it, "Doston Hamroyev Davronovich", Snackbar.LENGTH_LONG)
            snacbar.show()
            true
        }

        return binding.root
    }

    private fun startAnimation() {
        binding.typeWriter.animateText("Care of Children")
        binding.typeWriter.setCharacterDeley(70)
    }

    private fun loadData() {
        list = ArrayList()
        list.add(Section(resources.getString(R.string.section1)))
        list.add(Section(resources.getString(R.string.section2)))
        list.add(Section(resources.getString(R.string.section3)))
        list.add(Section(resources.getString(R.string.section4)))
        list.add(Section(resources.getString(R.string.section5)))
        list.add(Section(resources.getString(R.string.section6)))
        list.add(Section(resources.getString(R.string.section7)))
        list.add(Section(resources.getString(R.string.section8)))
        list.add(Section(resources.getString(R.string.section9)))
        list.add(Section(resources.getString(R.string.section10)))
        list.add(Section(resources.getString(R.string.section11)))
        list.add(Section(resources.getString(R.string.section12)))
        list.add(Section(resources.getString(R.string.section13)))
        list.add(Section(resources.getString(R.string.section14)))
        list.add(Section(resources.getString(R.string.section15)))
        list.add(Section(resources.getString(R.string.section16)))
        list.add(Section(resources.getString(R.string.section17)))
        list.add(Section(resources.getString(R.string.section18)))
        list.add(Section(resources.getString(R.string.section19)))
    }

    private fun checkLanguage() {
        when (Cache.language) {
            "en" -> {
                setAppLocale(binding.root.context, "en")
            }
            "ru" -> {
                setAppLocale(binding.root.context, "ru")
            }
            "uz" -> {
                setAppLocale(binding.root.context, "uz")
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