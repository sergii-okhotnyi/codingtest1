package hunter_dev.testing.hsbc.core.di

import android.content.Context
import hunter_dev.testing.hsbc.core.resume.api.GistDataSourceRetrofitFactory
import hunter_dev.testing.hsbc.core.resume.repository.ResumeRepository

/**
 * Simple Service Locator implementation for dependency resolve
 */
class DependencyLocator(val context: Context) {

    fun provideResumeRepository() = ResumeRepository(GistDataSourceRetrofitFactory.build())

    fun provideContext() = context

    companion object {
        fun init(context: Context): DependencyLocator {
            return DependencyLocator(context)
        }
    }
}
