package rs.raf.projekat2.Djordje_Zivanovic_RN9818.presentation.view.recycler.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.predmet_list_item.*
import rs.raf.projekat2.Djordje_Zivanovic_RN9818.data.models.Predmet

class PredmetViewHolder(
    override val containerView: View
) : RecyclerView.ViewHolder(containerView),
    LayoutContainer {


    fun bind(predmet: Predmet){
        predmetTv.text = predmet.predmet
        tipTv.text = predmet.tip
        nastavnikTv.text = predmet.nastavnik
        ucionicaTv.text = predmet.ucionica
        grupeTv.text = predmet.grupe
        danTv.text = predmet.dan
        terminTv.text = predmet.termin
    }

}