package com.rezwan.codechallengebyshikho.ui.viewmodel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.coroutines.toDeferred
import com.rezwan.codechallengebyshikho.GetPostByIdQuery
import com.rezwan.codechallengebyshikho.GetUserByIdQuery
import com.rezwan.codechallengebyshikho.LoadAllPostsQuery
import com.rezwan.codechallengebyshikho.ui.base.BaseViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class SharedViewModel @Inject constructor(val apolloClient: ApolloClient) : BaseViewModel() {

    val isLoading = MutableLiveData<Boolean>()
    val postLivedata = MutableLiveData<LoadAllPostsQuery.Posts>()
    val postByIdLivedata = MutableLiveData<GetPostByIdQuery.Post>()
    val userByIdLivedata = MutableLiveData<GetUserByIdQuery.User>()

    fun getPosts() {
        viewModelScope.launch {
            isLoading.value = true
            apolloClient.query(LoadAllPostsQuery()).toDeferred().await().let {
                isLoading.value = false
                if (!it.hasErrors()) {
                    it.data.let { postLivedata.postValue(it?.posts) }
                }
            }
        }
    }

    fun getPost(id:String) {
        viewModelScope.launch {
            isLoading.value = true
            apolloClient.query(GetPostByIdQuery(id)).toDeferred().await().let {
                isLoading.value = false
                if (!it.hasErrors()) {
                    it.data.let { postByIdLivedata.postValue(it?.post) }
                }
            }
        }
    }


    fun getUser(id:String) {
        viewModelScope.launch {
            isLoading.value = true
            apolloClient.query(GetUserByIdQuery(id)).toDeferred().await().let {
                isLoading.value = false
                if (!it.hasErrors()) {
                    it.data.let { userByIdLivedata.postValue(it?.user) }
                }
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