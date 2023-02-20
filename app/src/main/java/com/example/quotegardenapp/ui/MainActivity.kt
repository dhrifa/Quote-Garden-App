package com.example.quotegardenapp.ui

import android.os.Bundle
import android.view.Menu
import androidx.activity.viewModels
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import com.example.quotegardenapp.R
import com.example.quotegardenapp.data.model.quote.QuoteItemModel
import com.example.quotegardenapp.databinding.ActivityMainBinding
import com.example.quotegardenapp.ui.quote.QuoteFragment
import com.example.quotegardenapp.ui.quote.QuoteViewModel
import com.example.quotegardenapp.util.NetworkResult
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), Communicator {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    private val quoteViewModel: QuoteViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        binding.appBarMain.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_author, R.id.nav_quote, R.id.nav_genre
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        quoteViewModel.listQuotes.observe(this){
            quoteByAuthor(it)
        }
    }

    private fun quoteByAuthor(result: NetworkResult<List<QuoteItemModel>>?) {
//        result?.let {
//            supportFragmentManager.beginTransaction()
//                .replace(
//                    androidx.navigation.fragment.R.id.nav_host_fragment_container, //DisplayVerticalFragment()
//                    QuoteFragment.newInstance(it)
//                )
//                .addToBackStack(null)
//                .commit()// =>asynchronous
//        }
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun quotesByFilter(author: String?) {
        author?.let {
            quoteViewModel.getQuotesByAuthor(author)
        }
    }
}