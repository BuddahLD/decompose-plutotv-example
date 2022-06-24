package com.gmail.danylooliinyk.decomposeplutotvexample.ui.search

import android.view.View
import android.widget.LinearLayout
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.extensions.android.ViewContext
import com.arkivanov.decompose.extensions.android.layoutInflater
import com.arkivanov.decompose.value.observe
import com.gmail.danylooliinyk.decomposeplutotvexample.R
import com.gmail.danylooliinyk.decomposeplutotvexample.components.livetv.ILiveTv
import com.gmail.danylooliinyk.decomposeplutotvexample.components.ondemand.IOnDemand
import com.gmail.danylooliinyk.decomposeplutotvexample.components.search.ISearch

@ExperimentalDecomposeApi
internal fun ViewContext.searchView(searchComponent: ISearch): View {
    val layout = layoutInflater.inflate(R.layout.search, parent, false)
    // here we can do `findViewById` and so on

    searchComponent.model.observe(lifecycle) {
        // React on model changes
    }

    return layout
}
