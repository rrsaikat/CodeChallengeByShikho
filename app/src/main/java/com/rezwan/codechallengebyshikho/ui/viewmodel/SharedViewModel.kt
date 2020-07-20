package com.rezwan.codechallengebyshikho.ui.viewmodel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.coroutines.toDeferred
import com.rezwan.codechallengebyshikho.*
import com.rezwan.codechallengebyshikho.ext.showShortToast
import com.rezwan.codechallengebyshikho.type.CreatePostInput
import com.rezwan.codechallengebyshikho.ui.base.BaseViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class SharedViewModel @Inject constructor(val apolloClient: ApolloClient) : BaseViewModel() {


    val isLoading = MutableLiveData<Boolean>()
    val postLivedata = MutableLiveData<LoadAllPostsQuery.Posts>()
    val postByIdLivedata = MutableLiveData<GetPostByIdQuery.Post>()
    val userByIdLivedata = MutableLiveData<GetUserByIdQuery.User>()
    val photoAlbumLivedata = MutableLiveData<GetAlbumQuery.Photos>()

    //val posts = userRepository.fectchedPosts

    @Inject
    lateinit var app: App

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