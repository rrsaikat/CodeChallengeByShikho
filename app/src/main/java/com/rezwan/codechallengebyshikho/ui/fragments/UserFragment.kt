package com.rezwan.codechallengebyshikho.ui.fragments


import com.rezwan.codechallengebyshikho.GetUserByIdQuery
import com.rezwan.codechallengebyshikho.R
import com.rezwan.codechallengebyshikho.databinding.FragmentUserBinding
import com.rezwan.codechallengebyshikho.ui.base.BaseFragment
import com.rtchubs.filmadmin.adapters.UserListAdapter
import dagger.android.support.AndroidSupportInjection


class UserFragment : BaseFragment<FragmentUserBinding>(){

    override fun getLayoutRes(): Int = R.layout.fragment_user

    override fun setUpInitializers() {
        val adapter = UserListAdapter(listOf(
            GetUserByIdQuery.User("", "", "ggggggggggg", "", GetUserByIdQuery.Address("",GetUserByIdQuery.Geo("", 0.0, 0.0))),
            GetUserByIdQuery.User("", "", "thhh", "", GetUserByIdQuery.Address("",GetUserByIdQuery.Geo("", 0.0, 0.0))),
            GetUserByIdQuery.User("", "", "ttrt666666", "", GetUserByIdQuery.Address("",GetUserByIdQuery.Geo("", 0.0, 0.0)))

            )){}
        binding.recyclerUser.adapter = adapter
        adapter.notifyDataSetChanged()

    }

    override fun setUpListener() {

    }

    override fun setUpObservers() {

    }

    override fun onCreate() {

    }
}