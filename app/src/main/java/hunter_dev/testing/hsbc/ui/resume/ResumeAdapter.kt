package hunter_dev.testing.hsbc.ui.resume

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import hunter_dev.testing.hsbc.core.resume.model.Resume
import hunter_dev.testing.hsbc.ui.resume.vh.*

/**
 * RecyclerView Adapter for Resume
 */
class ResumeAdapter(resume: Resume) : RecyclerView.Adapter<BlockViewHolder>() {

    private val data: List<Block> = from(resume)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlockViewHolder {
        return when (viewType) {
            Block.TYPE_SUMMARY -> SummaryBlockViewHolder.create(
                parent
            )
            Block.TYPE_TOPIC -> TopicsBlockViewHolder.create(
                parent
            )
            Block.TYPE_EXPERIENCE -> ExperienceBlockViewHolder.create(
                parent
            )
            Block.TYPE_TITLE -> TitleBlockViewHolder.create(
                parent
            )
            Block.TYPE_CONTACTS -> ContactsBlockViewHolder.create(
                parent
            )
            else -> throw NotImplementedError("Block $viewType not supported")
        }
    }

    override fun getItemCount() = data.size

    override fun getItemViewType(position: Int): Int {
        return data[position].type
    }

    override fun onBindViewHolder(holder: BlockViewHolder, position: Int) {
        holder.bind(data[position])
    }
}


