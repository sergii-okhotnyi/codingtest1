package hunter_dev.testing.hsbc.ui.resume.vh

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import hunter_dev.testing.hsbc.R
import hunter_dev.testing.hsbc.core.makeCall
import hunter_dev.testing.hsbc.core.sendEmail
import hunter_dev.testing.hsbc.ui.resume.ContactsBlock
import kotlinx.android.synthetic.main.resume_contacts.view.*

class ContactsBlockViewHolder(itemView: View) : BlockViewHolder(itemView) {

    private val contactEmail = itemView.contactEmail
    private val contactPhone = itemView.contactPhone

    override fun bind(data: Any) {
        with(data as ContactsBlock) {
            if (email?.isNotEmpty() == true) {
                contactEmail.apply {
                    text = email
                    visibility = View.VISIBLE
                    setOnClickListener {
                        sendEmail(contactEmail.context, email)
                    }
                }
            } else {
                contactEmail.visibility = View.GONE
            }
            if (phone?.isNotEmpty() == true) {
                contactPhone.apply {
                    text = phone
                    visibility = View.VISIBLE
                    setOnClickListener {
                        makeCall(contactPhone.context, phone)
                    }
                }
            } else {
                contactPhone.visibility = View.GONE
            }

        }
    }

    companion object {
        fun create(parent: ViewGroup) = ContactsBlockViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.resume_contacts,
                parent,
                false
            )
        )
    }
}