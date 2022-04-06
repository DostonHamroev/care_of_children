package uz.hamroev.careofchildren.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.hamroev.careofchildren.databinding.ItemSectionBinding
import uz.hamroev.careofchildren.model.Section

class SectionAdapter(
    var context: Context,
    var list: ArrayList<Section>,
    var onSectionClickListener: OnSectionClickListener
) :
    RecyclerView.Adapter<SectionAdapter.VhSection>() {

    inner class VhSection(var itemSectionBinding: ItemSectionBinding) :
        RecyclerView.ViewHolder(itemSectionBinding.root) {

        fun onBind(section: Section, position: Int) {
            itemSectionBinding.sectionName.text = section.sectionName
            itemSectionBinding.cardMain.setOnClickListener {
                onSectionClickListener.onCLick(section, position)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VhSection {
        return VhSection(
            ItemSectionBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: VhSection, position: Int) {
        return holder.onBind(list[position], position)
    }

    override fun getItemCount(): Int = list.size

    interface OnSectionClickListener {
        fun onCLick(section: Section, position: Int)
    }
}