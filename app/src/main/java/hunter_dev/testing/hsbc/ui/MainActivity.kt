package hunter_dev.testing.hsbc.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity;
import hunter_dev.testing.hsbc.R
import hunter_dev.testing.hsbc.ui.resume.ResumeFragment

/**
 * Empty activity that hosts Main Fragment @ResumeFragment
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (false && savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.mainContainer, ResumeFragment.newInstance())
                .commit()
        }
    }
}
