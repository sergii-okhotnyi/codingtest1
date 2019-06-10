package hunter_dev.testing.hsbc.core.resume

import hunter_dev.testing.hsbc.core.resume.model.Resume
import hunter_dev.testing.hsbc.ui.resume.from
import io.mockk.every
import io.mockk.mockk
import org.junit.Assert
import org.junit.Test

class ResumeToBlockListConversionUnitTest {

    private val resume = mockk<Resume>()

    @Test
    fun `Empty resume should have empty list`() {
        every { resume.experience }.returns(null)
        every { resume.topics }.returns(null)
        every { resume.summary }.returns(null)
        every { resume.phone }.returns(null)
        every { resume.email}.returns(null)

        val list = from(resume)
        Assert.assertEquals(0, list.size)
    }

    @Test
    fun `Fully featured resume with one experience should have 6 items `() {
        every { resume.experience }.returns(listOf(mockk()))
        every { resume.topics }.returns(listOf("Test String"))
        every { resume.summary }.returns(listOf("Test String"))
        every { resume.phone }.returns("Test phone")
        every { resume.email}.returns("Text email")

        val list = from(resume)
        Assert.assertEquals(8, list.size)
    }

    @Test
    fun `Resume with two experience should have 3 items `() {
        every { resume.experience }.returns(listOf(mockk(), mockk()))
        every { resume.topics }.returns(null)
        every { resume.summary }.returns(null)
        every { resume.phone }.returns(null)
        every { resume.email}.returns(null)

        val list = from(resume)
        Assert.assertEquals(3, list.size)
    }
}
