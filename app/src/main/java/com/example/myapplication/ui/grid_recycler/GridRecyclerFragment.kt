package com.example.myapplication.ui.grid_recycler

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class GridRecyclerFragment : Fragment(R.layout.fragment_grid_recycler) {

    val list : List<GridItem> = listOf(
        GridItem("11:00", R.drawable.picone),
        GridItem("12:00", R.drawable.picone),
        GridItem("13:00", R.drawable.pictwo),
        GridItem("14:00", R.drawable.picone),
        GridItem("15:00", R.drawable.pictwo)
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView : RecyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.adapter = GridRecyclerAdapter(list, requireContext())
    }
}