package hunter_dev.testing.hsbc.ui.resume

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import hunter_dev.testing.hsbc.R
import hunter_dev.testing.hsbc.core.resume.model.Resume
import hunter_dev.testing.hsbc.core.sendEmail
import hunter_dev.testing.hsbc.provideLocator
import hunter_dev.testing.hsbc.ui.resume.viewmodel.ResumeViewModel
import kotlinx.android.synthetic.main.resume_fragment.*

/**
 * Main resume fragment
 */
class ResumeFragment : Fragment() {

    companion object {

        fun newInstance() = ResumeFragment().apply {
            arguments = Bundle().apply {
                // TODO here we can launch params
            }
        }

    }

    private var data: Resume? = null
    private lateinit var viewModel: ResumeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.resume_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(ResumeViewModel::class.java)
        viewModel.inject(provideLocator().provideResumeRepository())

        viewModel.isLoading.observe(this, Observer {
            showLoadingScreen(it)
        })

        viewModel.error.observe(this, Observer {
            Log.e("Resume","Error: $it")
            showError(it)
        })

        viewModel.resume.observe(this, Observer {
            showData(it)
        })

        viewModel.get()

    }

    private fun showLoadingScreen(it: Boolean) {
        errorPlaceholder.visibility = GONE
        contentRecycler.visibility = GONE
        if (it) {
            loadingPlaceholder.visibility = VISIBLE
            fab.hide()
        } else {
            loadingPlaceholder.visibility = GONE
        }
    }

    private fun showError(it: String?) {
        errorPlaceholder.visibility = VISIBLE
        errorLabel.text = it ?: getString(R.string.error)
        fab.hide()
    }

    private fun showData(data: Resume) {
        this.data = data
        if (data.email.isNullOrEmpty()) {
            fab.hide()
        } else {
            fab.show()
            fab.setOnClickListener { sendEmail(context!!, data.email) }
        }
        errorPlaceholder.visibility = GONE
        loadingPlaceholder.visibility = GONE

        contentRecycler.visibility = VISIBLE
        contentFullName?.text = data.fullName
        contentTitle?.text = data.title

        if (!data.photoUrl.isNullOrEmpty()) {
            Glide.with(this)
                .load(data.photoUrl)
                .circleCrop()
                .placeholder(R.drawable.ic_person_black_24dp)
                .into(contentPhoto)
        }

        contentRecycler.adapter = ResumeAdapter(data)
    }

}
