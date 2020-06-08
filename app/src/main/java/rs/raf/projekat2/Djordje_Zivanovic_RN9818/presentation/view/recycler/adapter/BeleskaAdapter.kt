package rs.raf.projekat2.Djordje_Zivanovic_RN9818.presentation.view.recycler.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import rs.raf.projekat2.Djordje_Zivanovic_RN9818.R
import rs.raf.projekat2.Djordje_Zivanovic_RN9818.data.models.Beleska
import rs.raf.projekat2.Djordje_Zivanovic_RN9818.presentation.view.recycler.diff.BeleskaDiffItemCallback
import rs.raf.projekat2.Djordje_Zivanovic_RN9818.presentation.view.recycler.viewholder.BeleskaViewHolder

class BeleskaAdapter(
    beleskaDiffItemCallback: BeleskaDiffItemCallback
) : ListAdapter<Beleska, BeleskaViewHolder>(beleskaDiffItemCallback){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeleskaViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val containerView = layoutInflater.inflate(R.layout.predmet_list_item, parent, false)
        return BeleskaViewHolder(
            containerView
        )
    }

    override fun onBindViewHolder(holder: BeleskaViewHolder, position: Int) {
        val predmet = getItem(position)
        holder.bind(predmet)
    }

}