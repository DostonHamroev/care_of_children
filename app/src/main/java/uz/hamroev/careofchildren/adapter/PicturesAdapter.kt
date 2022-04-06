package uz.hamroev.careofchildren.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.hamroev.careofchildren.databinding.ItemPicturesBinding
import uz.hamroev.careofchildren.model.Pictures

class PicturesAdapter(
    var context: Context,
    var list: ArrayList<Pictures>,
    var onPicturesClickListener: OnPicturesClickListener
) :
    RecyclerView.Adapter<PicturesAdapter.VHPIctures>() {

    inner class VHPIctures(var itemPicturesBinding: ItemPicturesBinding) :
        RecyclerView.ViewHolder(itemPicturesBinding.root) {

        fun onBind(pictures: Pictures, position: Int) {
            itemPicturesBinding.img.setImageResource(pictures.image)

            itemPicturesBinding.cardImage.setOnClickListener {
                onPicturesClickListener.onClick(pictures, position)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHPIctures {
        return VHPIctures(
            ItemPicturesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: VHPIctures, position: Int) {
        return holder.onBind(list[position], position)
    }

    override fun getItemCount(): Int = list.size

    interface OnPicturesClickListener {

        fun onClick(pictures: Pictures, position: Int)
    }
}