package org.softeer_2nd.caArt.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.fragment.NavHostFragment
import dagger.hilt.android.AndroidEntryPoint
import org.softeer_2nd.caArt.R
import org.softeer_2nd.caArt.databinding.ActivityMainBinding
import org.softeer_2nd.caArt.viewmodel.ToolBarViewModel

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val toolBarViewModel: ToolBarViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.lifecycleOwner = this
        binding.toolBarViewModel = toolBarViewModel

        setToolBar()
    }

    private fun setToolBar() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        navController.addOnDestinationChangedListener { _, destination, _ ->
            toolBarViewModel.setHomeFragment(destination.id == R.id.homeFragment)
            binding.toolbar.setNavigationOnClickListener {
                navController.navigateUp()
            }
        }

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
    }
}