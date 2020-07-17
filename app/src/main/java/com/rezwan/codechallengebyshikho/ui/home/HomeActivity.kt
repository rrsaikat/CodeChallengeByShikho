package com.rezwan.codechallengebyshikho.ui.home

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.apollographql.apollo.ApolloCall
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.coroutines.toDeferred
import com.rezwan.codechallengebyshikho.LoadAllPostsQuery
import com.rezwan.codechallengebyshikho.R
import com.rezwan.codechallengebyshikho.const.appconst.BASE_URL
import com.rezwan.codechallengebyshikho.ui.base.BaseActivity
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

class HomeActivity : BaseActivity() {
    private lateinit var apolloClient: ApolloClient
    lateinit var graphQLZeroPostListAPiCall: ApolloCall<LoadAllPostsQuery.Data>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        /*val okHttpClient = OkHttpClient.Builder()
            .addInterceptor {
                val original = it.request()
                val builder = original.newBuilder().method(original.method, original.body)
                it.proceed(builder.build())
            }
            .build()*/


        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build()


        apolloClient = ApolloClient.builder()
            .serverUrl(BASE_URL)
            .okHttpClient(okHttpClient)
            .build()


        launch {
            val response = apolloClient().query(LoadAllPostsQuery()).toDeferred().await()
            Toast.makeText(this@HomeActivity, "${response.data?.posts?.data?.size}", Toast.LENGTH_SHORT).show()
            if (response == null || response.hasErrors()){
                Log.e("size  ", "Something wrong")
            }
            Log.e("size  ", "${response.data?.posts?.data?.size}")
        }

    }

    fun apolloClient(): ApolloClient {
        return this.apolloClient;
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}