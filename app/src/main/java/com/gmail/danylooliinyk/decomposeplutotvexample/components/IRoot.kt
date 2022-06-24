package com.gmail.danylooliinyk.decomposeplutotvexample.components

import com.arkivanov.decompose.router.RouterState
import com.gmail.danylooliinyk.decomposeplutotvexample.components.livetv.ILiveTv
import com.gmail.danylooliinyk.decomposeplutotvexample.components.ondemand.IOnDemand
import com.gmail.danylooliinyk.decomposeplutotvexample.components.search.ISearch
import com.gmail.danylooliinyk.decomposeplutotvexample.components.splash.ISplash
import com.gmail.danylooliinyk.decomposeplutotvexample.value.ObservableValue

interface IRoot {

    val routerState: ObservableValue<RouterState<*, Child>>

    fun onLiveTvTabClicked()
    fun onOnDemandTabClicked()
    fun onSearchTabClicked()

    sealed class Child {
        class SplashChild(val component: ISplash) : Child()
        class LiveTvChild(val component: ILiveTv) : Child()
        class OnDemandChild(val component: IOnDemand) : Child()
        class SearchChild(val component: ISearch) : Child()
    }
}