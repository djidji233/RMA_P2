package rs.raf.projekat2.Djordje_Zivanovic_RN9818.presentation.view.recycler.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.beleska_list_item.*
import rs.raf.projekat2.Djordje_Zivanovic_RN9818.data.models.Beleska

class BeleskaViewHolder(
    override val containerView: View
) : RecyclerView.ViewHolder(containerView),
    LayoutContainer {


    fun bind(beleska: Beleska){
        noteTitleTv.text = beleska.title
        noteContentTv.text = beleska.content
    }

}