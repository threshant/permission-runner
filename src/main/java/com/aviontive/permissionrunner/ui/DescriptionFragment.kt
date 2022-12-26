package com.aviontive.permissionrunner.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aviontive.permissionrunner.R
import com.aviontive.permissionrunner.core.Permission
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class DescriptionFragment(permissions:List<Permission>,callback:()->Unit) : BottomSheetDialogFragment() {
    private val feed = permissions
    private val proceed = callback
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_description, container, false)
        val proceedButton = view.findViewById<TextView>(R.id.proceedButton)
        proceedButton.setOnClickListener {
            proceed()
            dismiss()
        }
        val contentRv = view.findViewById<RecyclerView>(R.id.contentRv)
        contentRv.layoutManager = LinearLayoutManager(requireContext())
        val descriptionAdapter = DescriptionAdapter(feed as ArrayList<Permission>)
        contentRv.adapter = descriptionAdapter
        return view
    }


}