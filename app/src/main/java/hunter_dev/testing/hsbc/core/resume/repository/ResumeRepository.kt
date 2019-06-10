package hunter_dev.testing.hsbc.core.resume.repository

import hunter_dev.testing.hsbc.core.resume.api.GistDataSource
import hunter_dev.testing.hsbc.core.resume.model.Resume

/**
 * Repository proxy class
 */
class ResumeRepository(private val resumeDataSource: GistDataSource) {

    suspend fun getResume(): Resume {
        resumeDataSource.get().let {
            if (it.isSuccessful && it.body() != null) {
                return it.body()!!
            } else {
                throw Exception(it.message())
            }
        }
    }

}