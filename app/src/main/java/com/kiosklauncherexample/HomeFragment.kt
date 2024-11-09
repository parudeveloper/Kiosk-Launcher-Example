package com.kiosklauncherexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import com.google.android.material.floatingactionbutton.FloatingActionButton

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    private lateinit var fabApps: FloatingActionButton
    private lateinit var imageButtonExit: ImageButton


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_home, container, false)


        fabApps = v.findViewById(R.id.floatingActionButton)
        imageButtonExit = v.findViewById(R.id.imageButton_exit)

        fabApps.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, AppsFragment())
                .commit()
        }

        imageButtonExit.setOnClickListener {
            KioskUtil.stopKioskMode(requireActivity())
        }

        return v
    }
}