package ml.ikiyuz.multicampkotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController

class MainActivity : AppCompatActivity() {
    var navController: NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /* https://stackoverflow.com/questions/59275009/fragmentcontainerview-using-findnavcontroller */
        navController = supportFragmentManager.findFragmentById(R.id.navHostFragment)?.findNavController()

        // Show/hide the back button at the top left corner, based on the currently displayed fragment
        navController?.addOnDestinationChangedListener { controller, destination, arguments ->
            if (destination.label == "fragment_community_list")
                setShowBackBtn(false)
            else
                setShowBackBtn(true)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home)   // When the back button at the top left corner pressed
            navController?.navigateUp() // Return to the previous fragment

        return super.onOptionsItemSelected(item)
    }

    fun setShowBackBtn(show: Boolean) {
        supportActionBar?.setDisplayHomeAsUpEnabled(show)
    }
}