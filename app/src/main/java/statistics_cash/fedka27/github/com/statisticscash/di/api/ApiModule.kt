package statistics_cash.fedka27.github.com.statisticscash.di.api

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.experimental.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import statistics_cash.fedka27.github.com.statisticscash.BuildConfig
import statistics_cash.fedka27.github.com.statisticscash.data.api.Api
import statistics_cash.fedka27.github.com.statisticscash.di.AppScope
import java.util.concurrent.TimeUnit

@Module
class ApiModule {

    companion object {
        private val CONNECT_TIMEOUT_SECONDS = 60
        private val READ_TIMEOUT_SECONDS = 60
        private val WRITE_TIMEOUT_SECONDS = 60
    }

    @AppScope
    @Provides
    fun provideApiInterface(retrofit: Retrofit): Api = retrofit.create(Api::class.java)

    @AppScope
    @Provides
    fun provideRetrofit(gson: Gson, client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build()
    }

    @AppScope
    @Provides
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }

    @AppScope
    @Provides
    fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
                .retryOnConnectionFailure(true)
                .connectTimeout(CONNECT_TIMEOUT_SECONDS.toLong(), TimeUnit.SECONDS)
                .readTimeout(READ_TIMEOUT_SECONDS.toLong(), TimeUnit.SECONDS)
                .writeTimeout(WRITE_TIMEOUT_SECONDS.toLong(), TimeUnit.SECONDS)
                .apply {
                    if (BuildConfig.DEBUG) addInterceptor(loggingInterceptor)
                }
                .build()
    }

    @AppScope
    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }
}