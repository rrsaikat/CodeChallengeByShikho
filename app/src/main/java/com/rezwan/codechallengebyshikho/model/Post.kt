package com.rezwan.codechallengebyshikho.model

import com.rezwan.codechallengebyshikho.LoadAllPostsQuery

data class Post(val postAction: PostAction, val postdata: LoadAllPostsQuery.Data1)

enum class PostAction {DELETE, EDIT}