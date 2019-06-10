package hunter_dev.testing.hsbc.ui.resume.vh

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import hunter_dev.testing.hsbc.R
import hunter_dev.testing.hsbc.ui.resume.TitleBlock
import kotlinx.android.synthetic.main.resume_title_item.view.*

class TitleBlockViewHolder(itemView: View) : BlockViewHolder(itemView) {

    private val resumeTitle = itemView.resumeTitle

    override fun bind(data: Any) {
        with(data as TitleBlock) {
            resumeTitle.text = resumeTitle.resources.getString(textResourceId)
        }
    }

    companion object {
        fun create(parent: ViewGroup) = TitleBlockViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.resume_title_item,
                parent,
                false
            )
        )
    }
}