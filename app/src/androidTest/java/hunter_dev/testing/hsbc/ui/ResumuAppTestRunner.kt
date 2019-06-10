package hunter_dev.testing.hsbc.ui

import android.app.Application
import android.content.Context
import androidx.test.runner.AndroidJUnitRunner
import hunter_dev.testing.hsbc.App
import hunter_dev.testing.hsbc.core.di.DependencyLocator
import io.mockk.mockk

class ResumuAppTestRunner : AndroidJUnitRunner() {
    @Throws(InstantiationException::class, IllegalAccessException::class, ClassNotFoundException::class)
    override fun newApplication(cl: ClassLoader, className: String, context: Context): Application {
        return super.newApplication(cl, AppTest::class.java.name, context)
    }
}

class AppTest : App() {
    override var locator = mockk<DependencyLocator>(relaxed = true)
        set(_) {}

}