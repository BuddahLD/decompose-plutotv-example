package com.gmail.danylooliinyk.decomposeplutotvexample.ui

import android.view.View
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.extensions.android.RouterView
import com.arkivanov.decompose.extensions.android.ViewContext
import com.arkivanov.decompose.extensions.android.layoutInflater
import com.arkivanov.decompose.value.observe
import com.gmail.danylooliinyk.decomposeplutotvexample.R
import com.gmail.danylooliinyk.decomposeplutotvexample.components.IRoot
import com.gmail.danylooliinyk.decomposeplutotvexample.components.IRoot.Child.LiveTvChild
import com.gmail.danylooliinyk.decomposeplutotvexample.components.IRoot.Child.OnDemandChild
import com.gmail.danylooliinyk.decomposeplutotvexample.components.IRoot.Child.SearchChild
import com.gmail.danylooliinyk.decomposeplutotvexample.components.IRoot.Child.SplashChild
import com.gmail.danylooliinyk.decomposeplutotvexample.ui.ondemand.onDemandView
import com.gmail.danylooliinyk.decomposeplutotvexample.ui.search.searchView
import com.gmail.danylooliinyk.decomposeplutotvexample.ui.splash.splashView
import com.google.android.material.bottomnavigation.BottomNavigationView

@ExperimentalDecomposeApi
fun ViewContext.rootView(root: IRoot): View {
    val layout = layoutInflater.inflate(R.layout.root, parent, false)
    val router: RouterView = layout.findViewById(R.id.router)

    router.children(root.routerState, lifecycle) { parent, child, _ ->
        parent.removeAllViews()

        parent.addView(
            when (child) {
                is SplashChild -> splashView(child.component)
                is LiveTvChild -> liveTvView(child.component)
                is OnDemandChild -> onDemandView(child.component)
                is SearchChild -> searchView(child.component)
            }
        )
    }

    val navigationView: BottomNavigationView = layout.findViewById(R.id.navigation_view)

    val listener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (val id = item.itemId) {
                R.id.tab_live_tv -> root.onLiveTvTabClicked()
                R.id.tab_on_demand -> root.onOnDemandTabClicked()
                R.id.tab_search -> root.onSearchTabClicked()
                else -> error("Unrecognized item id: $id")
            }

            true
        }

    navigationView.setOnNavigationItemSelectedListener(listener)

    root.routerState.observe(lifecycle) { state ->
        navigationView.setOnNavigationItemSelectedListener(null)

        navigationView.selectedItemId =
            when (state.activeChild.instance) {
                is SplashChild -> SPLASH_ID
                is LiveTvChild -> R.id.tab_live_tv
                is OnDemandChild -> R.id.tab_on_demand
                is SearchChild -> R.id.tab_search
            }

        navigationView.setOnNavigationItemSelectedListener(listener)
    }

    return layout
}

private const val SPLASH_ID = -1
