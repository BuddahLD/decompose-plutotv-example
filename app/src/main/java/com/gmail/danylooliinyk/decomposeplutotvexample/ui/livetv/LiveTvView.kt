package com.gmail.danylooliinyk.decomposeplutotvexample.ui

import android.view.View
import android.widget.LinearLayout
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.extensions.android.ViewContext
import com.arkivanov.decompose.extensions.android.layoutInflater
import com.arkivanov.decompose.value.observe
import com.gmail.danylooliinyk.decomposeplutotvexample.R
import com.gmail.danylooliinyk.decomposeplutotvexample.components.livetv.ILiveTv

@ExperimentalDecomposeApi
internal fun ViewContext.liveTvView(liveTvComponent: ILiveTv): View {
    val layout = layoutInflater.inflate(R.layout.live_tv, parent, false)
    // here we can do `findViewById` and so on

    liveTvComponent.model.observe(lifecycle) {
        // React on model changes
    }

    return layout
}
