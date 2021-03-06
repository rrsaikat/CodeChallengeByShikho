/*
 * Copyright 2020 RRsaikat. All rights reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.rezwan.codechallengebyshikho.ui.viewmodel


import android.content.Context
import android.icu.text.CaseMap
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.apollographql.apollo.ApolloCall
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.coroutines.toDeferred
import com.apollographql.apollo.exception.ApolloException
import com.rezwan.codechallengebyshikho.*
import com.rezwan.codechallengebyshikho.data.repository.UserRepository
import com.rezwan.codechallengebyshikho.ext.showShortToast
import com.rezwan.codechallengebyshikho.type.CreatePostInput
import com.rezwan.codechallengebyshikho.ui.base.BaseViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

class SharedViewModel @Inject constructor(val apolloClient: ApolloClient, userRepository: UserRepository) : BaseViewModel() {

    @Inject
    lateinit var app: App

    val isLoading = MutableLiveData<Boolean>()
    val postLivedata = MutableLiveData<LoadAllPostsQuery.Posts>()
    val postByIdLivedata = MutableLiveData<GetPostByIdQuery.Post>()
    val userByIdLivedata = MutableLiveData<GetUserByIdQuery.User>()
    val photoAlbumLivedata = MutableLiveData<GetAlbumQuery.Photos>()

    val posts = userRepository.fectchedPosts
    val photos = userRepository.fectchedPhotos


    fun getPosts() {
        viewModelScope.launch {
            isLoading.value = true
            try {
                apolloClient.query(LoadAllPostsQuery()).toDeferred().await().let {
                    isLoading.value = false
                    if (!it.hasErrors()) {
                        it.data.let { postLivedata.postValue(it?.posts) }
                    }
                }
            }catch (ex:Exception){
                isLoading.value = false
                app.showShortToast(ex.localizedMessage ?: "Something wrong")
            }

        }
    }

    fun getPost(id:String) {
        viewModelScope.launch {
            isLoading.value = true
            try {
                apolloClient.query(GetPostByIdQuery(id = id)).toDeferred().await().let {
                    isLoading.value = false
                    if (!it.hasErrors()) {
                        it.data.let { postByIdLivedata.postValue(it?.post) }
                    }
                }
            }catch (ex:Exception){
                isLoading.value = false
                app.showShortToast(ex.localizedMessage ?: "Something wrong")
            }

        }
    }

    fun getUser(id:String) {
        viewModelScope.launch {
            isLoading.value = true
            try {
                apolloClient.query(GetUserByIdQuery(id = id)).toDeferred().await().let {
                    isLoading.value = false
                    if (!it.hasErrors()) {
                        it.data.let { userByIdLivedata.postValue(it?.user) }
                    }
                }
            }catch (ex:Exception){
                isLoading.value = false
                app.showShortToast(ex.localizedMessage ?: "Something wrong")
            }

        }
    }

    fun getAlbum(id:String){
        viewModelScope.launch {
            isLoading.value = true
            try {
                apolloClient.query(GetAlbumQuery(id = id)).toDeferred().await().let {
                    isLoading.value = false
                    if (!it.hasErrors()) {
                        it.data.let { photoAlbumLivedata.postValue(it?.photo?.album?.photos) }
                    }
                }
            }catch (ex:Exception){
                isLoading.value = false
                app.showShortToast(ex.localizedMessage ?: "Something wrong")
            }

        }
    }

    fun createPostQuery(title: String, body:String){
        viewModelScope.launch {
            isLoading.postValue(true)

            try {
                apolloClient.mutate(CreatePostMutation( input = CreatePostInput(title = title, body =  body))).toDeferred().await()
                    .let {
                    isLoading.value = false
                    if (!it.hasErrors()) {
                        app.showShortToast("Success")
                        getPosts()
                    }else{
                        app.showShortToast(it.errors?.get(0)?.message ?: "Something wrong")
                    }
                }
            }catch (ex:Exception){
                isLoading.value = false
            }
        }
    }

    /*fun getPosts() = disposable.add(
        Observable.create<LoadAllPostsQuery.Posts> { emitter ->
            try {
                launch {
                    isLoading.value = true
                    getPostList()
                    val post = posts.await()
                }
                emitter.onComplete()
            } catch (ex: Exception) {
                emitter.onError(ex)
            }
        }.doOnError { isLoading.value = false }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                isLoading.value = false
                postLivedata.postValue(it)
            }, {

            })
    )*/

}