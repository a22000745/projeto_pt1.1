package pt.ulusofona.deisi.cm2223.app

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

object NavigationManager {
    private fun placeFragment(fm: FragmentManager, fragment: Fragment) {
        val transition = fm.beginTransaction()
        transition.replace(R.id.frame, fragment)
        transition.addToBackStack(null)
        transition.commit()
    }
    fun goToFormFragment(fm: FragmentManager){
        placeFragment(fm, FormFragment())
    }
    fun goToListFragment(fm: FragmentManager){
        placeFragment(fm, ListFragment())
    }
    fun goToMapFragment(fm: FragmentManager){
        placeFragment(fm, MapFragment())
    }
}