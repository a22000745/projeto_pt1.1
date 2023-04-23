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
    fun goToBeginningFragment(fm: FragmentManager){
        placeFragment(fm,DashBoardFragment())
    }
    fun goToFormFragment(fm: FragmentManager,arrayPosition: Int = -1){
         if(arrayPosition == -1){
            placeFragment(fm, FormFragment())
        }else{
            placeFragment(fm, FormFragment(arrayPosition))
        }
    }
    fun goToListFragment(fm: FragmentManager){
        placeFragment(fm, ListFragment())
    }
    fun goToMapFragment(fm: FragmentManager){
        placeFragment(fm, MapFragment())
    }
    fun showDialog(fm: FragmentManager){
        val dialogFragment = DialogFragment()
        dialogFragment.show(fm, "my_dialog")
    }
    fun goToDetailsFragment(fm: FragmentManager,position : Int){
        placeFragment(fm, DetailsFragment(position))
    }
}