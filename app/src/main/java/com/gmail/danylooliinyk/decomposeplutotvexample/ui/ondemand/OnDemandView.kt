package com.gmail.danylooliinyk.decomposeplutotvexample.ui.ondemand

import android.view.View
import android.widget.LinearLayout
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.extensions.android.ViewContext
import com.arkivanov.decompose.extensions.android.layoutInflater
import com.arkivanov.decompose.value.observe
import com.gmail.danylooliinyk.decomposeplutotvexample.R
import com.gmail.danylooliinyk.decomposeplutotvexample.components.livetv.ILiveTv
import com.gmail.danylooliinyk.decomposeplutotvexample.components.ondemand.IOnDemand

@ExperimentalDecomposeApi
internal fun ViewContext.onDemandView(onDemandComponent: IOnDemand): View {
    val layout = layoutInflater.inflate(R.layout.on_demand, parent, false)
    // here we can do `findViewById` and so on

    onDemandComponent.model.observe(lifecycle) {
        // React on model changes
    }

    return layout
}
