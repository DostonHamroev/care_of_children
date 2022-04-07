package uz.hamroev.careofchildren.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.hamroev.careofchildren.databinding.ItemNavBinding
import uz.hamroev.careofchildren.model.Nav

class NavAdapter(
    var context: Context,
    var list: ArrayList<Nav>,
    var onNavClickListener: OnNavClickListener
) :
    RecyclerView.Adapter<NavAdapter.VhNav>() {

    inner class VhNav(var itemNavBinding: ItemNavBinding) :
        RecyclerView.ViewHolder(itemNavBinding.root) {
        fun onBind(nav: Nav, position: Int) {

            itemNavBinding.navName.text = nav.nav_name
            itemNavBinding.navImage.setImageResource(nav.nav_image)
            itemNavBinding.root.setOnClickListener {
                onNavClickListener.onClick(nav, position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VhNav {
        return VhNav(ItemNavBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: VhNav, position: Int) {
        return holder.onBind(list[position], position)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    interface OnNavClickListener {
        fun onClick(nav: Nav, position: Int)
    }
}