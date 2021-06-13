package com.thetimickrus.beappsdemoapp.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.thetimickrus.beappsdemoapp.R
import com.thetimickrus.beappsdemoapp.ui.main.mainrecyclerview.MainRecyclerViewAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment(R.layout.main_fragment) {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val viewModel: MainViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val swipeRefresh = view.findViewById<SwipeRefreshLayout>(R.id.swipe_refresh)
        val mainRecyclerView: RecyclerView = view.findViewById(R.id.main_recyclerview)

        val adapter = MainRecyclerViewAdapter(this) {
            viewModel.onItemClick(childFragmentManager, it)
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