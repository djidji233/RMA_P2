package rs.raf.projekat2.Djordje_Zivanovic_RN9818.presentation.view.recycler.diff

import androidx.recyclerview.widget.DiffUtil
import rs.raf.projekat2.Djordje_Zivanovic_RN9818.data.models.Predmet

class PredmetDiffItemCallback : DiffUtil.ItemCallback<Predmet>() {

    override fun areItemsTheSame(oldItem: Predmet, newItem: Predmet): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Predmet, newItem: Predmet): Boolean {
        return oldItem.predmet == newItem.predmet &&
                oldItem.tip == newItem.tip &&
                oldItem.nastavnik == newItem.nastavnik &&
                oldItem.ucionica == newItem.ucionica &&
                oldItem.grupe == newItem.grupe &&
                oldItem.dan == newItem.dan &&
                oldItem.termin == newItem.termin
    }



}