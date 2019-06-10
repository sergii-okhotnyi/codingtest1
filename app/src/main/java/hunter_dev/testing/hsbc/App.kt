package hunter_dev.testing.hsbc

import android.app.Application
import android.content.Context
import androidx.fragment.app.Fragment
import hunter_dev.testing.hsbc.core.di.DependencyLocator

/**
 * Application module.
 * Creates instance of @DependencyLocator
 */
open class App : Application() {

    open lateinit var locator: DependencyLocator

    override fun onCreate() {
        super.onCreate()
        locator = DependencyLocator.init(this)
    }
}

fun Context.provideLocator() =
    (this.applicationContext as App).locator

fun Fragment.provideLocator() =
    (this.context?.applicationContext as App).locator