package com.thetimickrus.beappsdemoapp.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.thetimickrus.beappsdemoapp.R
import com.thetimickrus.beappsdemoapp.ui.main.mainrecyclerview.MainRecyclerViewAdapter
import com.thetimickrus.beappsdemoapp.viewmodels.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment(R.layout.main_fragment) {

    private val viewModel: MainViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val swipeRefresh = view.findViewById<SwipeRefreshLayout>(R.id.swipe_refresh)
        val mainRecyclerView: RecyclerView = view.findViewById(R.id.main_recyclerview)

        if (savedInstanceState == null) {
            swipeRefresh?.isRefreshing = true
        }

        val adapter = MainRecyclerViewAdapter {
            viewModel.onItemClick(it)
        }
        viewModel.getMainPage().observe(viewLifecycleOwner, {
            it?.let {
                swipeRefresh?.isRefreshing = true
                adapter.submitList(it.content)
                swipeRefresh?.isRefreshing = false
            }
        })
        mainRecyclerView.adapter = adapter

        swipeRefresh?.setOnRefreshListener {
            viewModel.updateMainPage()
        }
    }

}