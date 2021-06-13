package com.thetimickrus.beappsdemoapp.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.thetimickrus.beappsdemoapp.R
import com.thetimickrus.beappsdemoapp.ui.main.mainrecyclerview.MainRecyclerViewAdapter
import org.koin.android.ext.android.get
import org.koin.android.ext.android.getKoin
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val viewModel: MainViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val swipeRefresh = view?.findViewById<SwipeRefreshLayout>(R.id.swipe_refresh)

        val mainRecyclerView: RecyclerView = view?.findViewById(R.id.main_recyclerview)!!
        val adapter = MainRecyclerViewAdapter(this)
        val mp = viewModel.getMainPage()
        mp.observe(this.viewLifecycleOwner, Observer {
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