package rs.raf.projekat2.Djordje_Zivanovic_RN9818.presentation.view.recycler.diff

import androidx.recyclerview.widget.DiffUtil
import rs.raf.projekat2.Djordje_Zivanovic_RN9818.data.models.Beleska

class BeleskaDiffItemCallback: DiffUtil.ItemCallback<Beleska>() {
    override fun areItemsTheSame(oldItem: Beleska, newItem: Beleska): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Beleska, newItem: Beleska): Boolean {
        return oldItem.title == newItem.title &&
                oldItem.content == newItem.content
    }
}