package com.santander.android.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.santander.android.R
import com.santander.android.viewmodel.FundViewModel

class FundFragment : Fragment() {

    private lateinit var mViewModel: FundViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.let { mViewModel = FundViewModel.create(it) }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_fund, container, false)
        return rootView
    }

    companion object {
        fun getInstance(): FundFragment {
            return FundFragment()
        }
    }

}