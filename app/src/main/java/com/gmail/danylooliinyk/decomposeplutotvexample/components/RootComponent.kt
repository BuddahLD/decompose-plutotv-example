package com.gmail.danylooliinyk.decomposeplutotvexample.components

import android.os.Parcelable
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.Router
import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.router.bringToFront
import com.arkivanov.decompose.router.router
import com.arkivanov.essenty.parcelable.Parcelize
import com.gmail.danylooliinyk.decomposeplutotvexample.components.IRoot.Child
import com.gmail.danylooliinyk.decomposeplutotvexample.components.IRoot.Child.LiveTvChild
import com.gmail.danylooliinyk.decomposeplutotvexample.components.IRoot.Child.OnDemandChild
import com.gmail.danylooliinyk.decomposeplutotvexample.components.IRoot.Child.SearchChild
import com.gmail.danylooliinyk.decomposeplutotvexample.components.IRoot.Child.SplashChild
import com.gmail.danylooliinyk.decomposeplutotvexample.components.RootComponent.Config.LiveTv
import com.gmail.danylooliinyk.decomposeplutotvexample.components.RootComponent.Config.OnDemand
import com.gmail.danylooliinyk.decomposeplutotvexample.components.RootComponent.Config.Search
import com.gmail.danylooliinyk.decomposeplutotvexample.components.RootComponent.Config.Splash
import com.gmail.danylooliinyk.decomposeplutotvexample.components.livetv.LiveTvComponent
import com.gmail.danylooliinyk.decomposeplutotvexample.components.ondemand.OnDemandComponent
import com.gmail.danylooliinyk.decomposeplutotvexample.components.search.SearchComponent
import com.gmail.danylooliinyk.decomposeplutotvexample.components.splash.SplashComponent
import com.gmail.danylooliinyk.decomposeplutotvexample.value.ObservableValue

class RootComponent(
    componentContext: ComponentContext
) : IRoot, ComponentContext by componentContext  {

    private val router: Router<Config, Child> =
        router(
            initialStack = { listOf(Splash) },
            childFactory = ::child
        )

    override val routerState: ObservableValue<RouterState<*, Child>> = router.state

    override fun onLiveTvTabClicked() {
        router.bringToFront(LiveTv)
    }

    override fun onOnDemandTabClicked() {
        router.bringToFront(OnDemand)
    }

    override fun onSearchTabClicked() {
        router.bringToFront(Search)
    }

    private fun child(config: Config, componentContext: ComponentContext): Child =
        when (config) {
            is Splash -> SplashChild(SplashComponent())
            is LiveTv -> LiveTvChild(LiveTvComponent())
            is OnDemand -> OnDemandChild(OnDemandComponent())
            is Search -> SearchChild(SearchComponent())
        }

    private sealed interface Config : Parcelable {
        @Parcelize
        object Splash : Config

        @Parcelize
        object LiveTv : Config

        @Parcelize
        object OnDemand : Config

        @Parcelize
        object Search : Config
    }
}
