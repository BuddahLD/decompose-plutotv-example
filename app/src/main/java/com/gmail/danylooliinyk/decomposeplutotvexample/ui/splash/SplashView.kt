package com.gmail.danylooliinyk.decomposeplutotvexample.ui.splash

import android.view.View
import android.widget.LinearLayout
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.extensions.android.ViewContext
import com.arkivanov.decompose.extensions.android.layoutInflater
import com.arkivanov.decompose.value.observe
import com.gmail.danylooliinyk.decomposeplutotvexample.R
import com.gmail.danylooliinyk.decomposeplutotvexample.components.splash.ISplash

@ExperimentalDecomposeApi
internal fun ViewContext.splashView(splashComponent: ISplash): View {
    val layout = layoutInflater.inflate(R.layout.splash, parent, false)
    // here we can do `findViewById` and so on

    splashComponent.model.observe(lifecycle) {
        // React on model changes
    }

    return layout
}
