package com.kiosklauncherexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AppsFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_apps, container, false)
        recyclerView = view.findViewById(R.id.recyclerView_apps)
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 4, RecyclerView.HORIZONTAL, false)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = AppsAdapter(AppsUtil.getAllApps(requireContext()), requireContext())

        return view
    }
}