package hunter_dev.testing.hsbc.core.resume.api

import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import hunter_dev.testing.hsbc.core.resume.model.Resume
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

/**
 * Gist datasource service
 */

interface GistDataSource {

    @GET("/sergii-okhotnyi/4f443d53f0c15783718da5ef3455192e/raw/392479043654607de10c8a297d7c40cb873bb955/resume.json")
    suspend fun get(): Response<Resume>

    companion object {
        const val ENDPOINT = "https://gist.github.com"
    }

}

/**
 * Retrofit @GistDataSource implementation
 */
object GistDataSourceRetrofitFactory {
    fun build(): GistDataSource {
        val gsonConverterFactory = GsonConverterFactory.create(
            GsonBuilder()
                .setLenient()
                .create()
        )
        return Retrofit.Builder()
            .baseUrl(GistDataSource.ENDPOINT)
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(gsonConverterFactory)
            .build()
            .create(GistDataSource::class.java)
    }
}