package rs.raf.projekat2.Djordje_Zivanovic_RN9818.presentation.view.recycler.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import rs.raf.projekat2.Djordje_Zivanovic_RN9818.R
import rs.raf.projekat2.Djordje_Zivanovic_RN9818.data.models.Predmet
import rs.raf.projekat2.Djordje_Zivanovic_RN9818.presentation.view.recycler.diff.PredmetDiffItemCallback
import rs.raf.projekat2.Djordje_Zivanovic_RN9818.presentation.view.recycler.viewholder.PredmetViewHolder

class PredmetAdapter (
    patientDiffItemCallback: PredmetDiffItemCallback
) : ListAdapter<Predmet, PredmetViewHolder>(patientDiffItemCallback){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PredmetViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val containerView = layoutInflater.inflate(R.layout.predmet_list_item, parent, false)
        return PredmetViewHolder(
            containerView
        )
    }

    override fun onBindViewHolder(holder: PredmetViewHolder, position: Int) {
        val predmet = getItem(position)
        holder.bind(predmet)
    }

}