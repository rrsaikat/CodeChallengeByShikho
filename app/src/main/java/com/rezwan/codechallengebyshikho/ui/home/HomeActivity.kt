package com.rezwan.codechallengebyshikho.ui.home

import android.view.Menu
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.rezwan.codechallengebyshikho.R
import com.rezwan.codechallengebyshikho.databinding.ActivityMainBinding
import com.rezwan.codechallengebyshikho.ui.base.BaseActivity


class HomeActivity : BaseActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun setUpLayoutBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun setUpInitializers() {
        initNavBar()
    }

    override fun toolbarTitle(): CharSequence? = ""

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    private fun initNavBar() {
        val navController = findNavController(R.id.nav_host_fragment)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_users,
                R.id.navigation_posts,
                R.id.navigation_finder
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.navView.setupWithNavController(navController)

    }
}