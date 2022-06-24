package com.gmail.danylooliinyk.decomposeplutotvexample.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.defaultComponentContext
import com.arkivanov.decompose.extensions.android.DefaultViewContext
import com.arkivanov.decompose.extensions.android.child
import com.arkivanov.essenty.lifecycle.essentyLifecycle
import com.gmail.danylooliinyk.decomposeplutotvexample.R
import com.gmail.danylooliinyk.decomposeplutotvexample.components.IRoot
import com.gmail.danylooliinyk.decomposeplutotvexample.components.RootComponent

class MainActivity : AppCompatActivity() {

    private val mode = Mode.VIEWS

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val root = RootComponent(
            componentContext = defaultComponentContext()
        )

        when (mode) {
            Mode.COMPOSE -> drawViaCompose(root)
            Mode.VIEWS -> drawViaViews(root)
        }
    }

    private fun drawViaCompose(root: IRoot) {
        // TBD
    }

    @OptIn(ExperimentalDecomposeApi::class)
    private fun drawViaViews(root: IRoot) {
        setContentView(R.layout.activity_main)

        val viewContext =
            DefaultViewContext(
                parent = findViewById(R.id.content),
                lifecycle = essentyLifecycle(),
            )

        viewContext.apply {
            child(parent) {
                rootView(root)
            }
        }
    }

    private enum class Mode {
        COMPOSE, VIEWS
    }
}