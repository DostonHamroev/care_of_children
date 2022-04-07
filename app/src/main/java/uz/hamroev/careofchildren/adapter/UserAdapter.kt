package uz.hamroev.careofchildren.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.hamroev.careofchildren.databinding.ItemSectionBinding
import uz.hamroev.careofchildren.databinding.ItemUsersBinding
import uz.hamroev.careofchildren.model.Section
import uz.hamroev.careofchildren.model.User

class UserAdapter(
    var context: Context,
    var list: ArrayList<User>
) :
    RecyclerView.Adapter<UserAdapter.VhSection>() {

    inner class VhSection(var itemUsersBinding: ItemUsersBinding) :
        RecyclerView.ViewHolder(itemUsersBinding.root) {

        fun onBind(user: User, position: Int) {
            itemUsersBinding.userImage.setImageResource(user.userImg)
            itemUsersBinding.userInfo.text = user.username
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VhSection {
        return VhSection(
            ItemUsersBinding.inflate(
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

}