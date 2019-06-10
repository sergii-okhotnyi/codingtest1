package hunter_dev.testing.hsbc.ui.resume.vh

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import hunter_dev.testing.hsbc.R
import hunter_dev.testing.hsbc.ui.resume.SummaryBlock
import kotlinx.android.synthetic.main.resume_summary_item.view.*

class SummaryBlockViewHolder(itemView: View) : BlockViewHolder(itemView) {

    private val resumeSummaryText = itemView.resumeSummaryText

    override fun bind(data: Any) {
        with(data as SummaryBlock) {
            resumeSummaryText.text = summary
        }
    }

    companion object {
        fun create(parent: ViewGroup) = SummaryBlockViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.resume_summary_item,
                parent,
                false
            )
        )
    }
}