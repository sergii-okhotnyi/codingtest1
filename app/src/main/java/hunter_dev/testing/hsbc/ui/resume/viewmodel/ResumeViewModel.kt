package hunter_dev.testing.hsbc.ui.resume.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import hunter_dev.testing.hsbc.core.resume.model.Resume
import hunter_dev.testing.hsbc.core.resume.repository.ResumeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch

/**
 * ResumeViewModel implementation
 */
class ResumeViewModel : ViewModel() {
    /**
     * Is data loading
     */
    val isLoading = MutableLiveData<Boolean>()
    /**
     * Loaded data
     */
    val resume = MutableLiveData<Resume>()
    /**
     * Error occured during data loading
     */
    val error = MutableLiveData<String>()

    private lateinit var repository: ResumeRepository

    /**
     * Inject dependency
     */
    fun inject(resumeRepository: ResumeRepository) {
        repository = resumeRepository
    }

    fun get() {
        isLoading.postValue(true)

        GlobalScope.launch(Dispatchers.IO) {
            try {
                val result = repository.getResume()
                isLoading.postValue(false)
                resume.postValue(result)
            } catch (e: Exception) {
                isLoading.postValue(false)
                error.postValue(e.message)
            }
        }
    }
}
