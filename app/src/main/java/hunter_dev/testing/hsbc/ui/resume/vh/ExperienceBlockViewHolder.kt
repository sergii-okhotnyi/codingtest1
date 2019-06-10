package hunter_dev.testing.hsbc.ui.resume.vh

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import hunter_dev.testing.hsbc.R
import hunter_dev.testing.hsbc.ui.resume.ExperienceBlock
import kotlinx.android.synthetic.main.resume_experience_item.view.*

class ExperienceBlockViewHolder(itemView: View) : BlockViewHolder(itemView) {

    private var companyDescription: TextView? = itemView.companyDescription
    private var companyRole: TextView? = itemView.companyRole
    private var companyDates: TextView? = itemView.companyDates
    private var companyLogo: ImageView? = itemView.companyLogo
    private var companyName: TextView? = itemView.companyName

    override fun bind(data: Any) {
        with(data as ExperienceBlock) {
            companyName?.text = experience.companyName
            companyDates?.text = experience.period
            companyRole?.text = experience.role
            companyDescription?.text = data.experience.description?.joinToString("\n")
            if (data.experience.logoUrl?.isNotEmpty() == true) {
                companyLogo?.let {
                    Glide.with(it)
                        .load(experience.logoUrl)
                        .into(it)
                }
            }
        }
    }

    companion object {

        fun create(parent: ViewGroup) = ExperienceBlockViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.resume_experience_item,
                parent,
                false
            )
        )
    }
}