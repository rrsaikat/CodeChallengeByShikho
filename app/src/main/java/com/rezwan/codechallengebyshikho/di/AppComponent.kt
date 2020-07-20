package com.rezwan.codechallengebyshikho.di

import android.app.Application
import android.content.Context
import com.rezwan.codechallengebyshikho.App
import com.rezwan.codechallengebyshikho.ui.fragments.album.AlbumFragment
import com.rezwan.codechallengebyshikho.ui.fragments.post.PostListFragment
import com.rezwan.codechallengebyshikho.ui.fragments.query.QLFragment
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjection
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
       ViewModelModule::class
    ]
)

interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: App): Builder

//        @BindsInstance
//        fun networkModule(networkModule: NetworkModule): Builder
        //
//        @BindsInstance
//        fun databaseModule(databaseModule: DatabaseModule): Builder

        fun build(): AppComponent
    }

    fun inject(application: App)

}
