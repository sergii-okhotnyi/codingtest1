package hunter_dev.testing.hsbc.ui.resume.vh

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import hunter_dev.testing.hsbc.R
import hunter_dev.testing.hsbc.ui.resume.TopicsBlock
import kotlinx.android.synthetic.main.resume_topics_items.view.*

class TopicsBlockViewHolder(itemView: View) : BlockViewHolder(itemView) {

    private var chipGroup: ChipGroup? = itemView.chipGroup

    override fun bind(data: Any) {
        chipGroup?.let { chipGroup ->
            chipGroup.removeAllViews()
            (data as TopicsBlock).list.forEach {
                chipGroup.addView(
                    Chip(itemView.context).apply {
                        text = it
                    }
                )
            }
        }
    }

    companion object {
        fun create(parent: ViewGroup) = TopicsBlockViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.resume_topics_items,
                parent,
                false
            )
        )
    }
}