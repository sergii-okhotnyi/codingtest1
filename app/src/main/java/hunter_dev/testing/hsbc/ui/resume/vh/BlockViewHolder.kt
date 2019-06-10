package hunter_dev.testing.hsbc.ui.resume.vh

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * Base ViewHolder interface
 */
abstract class BlockViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bind(data: Any)
}