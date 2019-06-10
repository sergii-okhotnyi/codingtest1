package hunter_dev.testing.hsbc.core.resume

import hunter_dev.testing.hsbc.core.resume.api.GistDataSourceRetrofitFactory
import hunter_dev.testing.hsbc.core.resume.repository.ResumeRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class ResumeRepositoryTest {

    @Test
    fun `Gist Integrational test`() = runBlocking {
        val repo = ResumeRepository(GistDataSourceRetrofitFactory.build())
        val resume = repo.getResume()
        Assert.assertEquals("Sergii Okhotnyi", resume.fullName)
        Assert.assertEquals(2, resume.experience?.size)
        Assert.assertEquals(23, resume.summary?.size)
        Assert.assertEquals(4, resume.topics?.size)
    }
}