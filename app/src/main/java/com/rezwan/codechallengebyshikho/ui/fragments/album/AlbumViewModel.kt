package com.rezwan.codechallengebyshikho.ui.fragments.album

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rezwan.codechallengebyshikho.GetAlbumQuery
import com.rezwan.codechallengebyshikho.di.AppModule
import com.rezwan.codechallengebyshikho.model.Post
import javax.inject.Inject

class AlbumViewModel @Inject constructor(private val appModule: AppModule) : ViewModel() {

    private val _status = MutableLiveData<Boolean>()

    val status: LiveData<Boolean>
        get() = _status

    private val _photoResults =
        MutableLiveData<List<GetAlbumQuery.Data1>>()

    val photos: LiveData<List<GetAlbumQuery.Data1>>
        get() = _photoResults

}