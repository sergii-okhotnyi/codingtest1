package hunter_dev.testing.hsbc.ui.resume

import hunter_dev.testing.hsbc.R
import hunter_dev.testing.hsbc.core.resume.model.Experience
import hunter_dev.testing.hsbc.core.resume.model.Resume

/**
 * Base abstract block class
 * Block is base wrapper class about RecyclerView single item
 */
abstract class Block(val type: Int) {
    companion object {
        const val TYPE_SUMMARY = 1
        const val TYPE_TOPIC = 2
        const val TYPE_EXPERIENCE = 3
        const val TYPE_TITLE = 4
        const val TYPE_CONTACTS = 5
    }
}

/**
 * Resume topics block
 */
class TopicsBlock(val list: List<String>) : Block(TYPE_TOPIC)

/**
 * Past work experience block
 */
class ExperienceBlock(val experience: Experience) : Block(TYPE_EXPERIENCE)

/**
 * Contact informat block
 */
class ContactsBlock(val email: String?, val phone: String?) : Block(TYPE_CONTACTS)

/**
 * Title for the next set of blocks
 * Accepts string resource identifier
 */
class TitleBlock(val textResourceId: Int) : Block(TYPE_TITLE)

/**
 * Resume summary block
 */
class SummaryBlock(val summary: String) : Block(TYPE_SUMMARY)

/**
 * Helper function that converts resume to plain Block list
 */
fun from(resume: Resume): List<Block> {
    val result = mutableListOf<Block>()

    if (resume.phone?.isNotEmpty() == true || resume.email?.isNotEmpty() == true) {
        result.add(TitleBlock(R.string.contacts))
        result.add(ContactsBlock(resume.email, resume.phone))
    }
    resume.summary?.run {
        result.add(TitleBlock(R.string.summary))
        result.add(SummaryBlock(this.joinToString("\n")))
    }
    resume.topics?.run {
        result.add(TitleBlock(R.string.topics))
        result.add(TopicsBlock(this))
    }
    resume.experience?.run {
        result.add(TitleBlock(R.string.experience))
        forEach { result.add(ExperienceBlock(it)) }
    }
    return result
}