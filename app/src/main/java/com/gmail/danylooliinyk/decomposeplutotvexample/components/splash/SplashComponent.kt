package com.gmail.danylooliinyk.decomposeplutotvexample.components.splash

import com.arkivanov.decompose.value.MutableValue
import com.gmail.danylooliinyk.decomposeplutotvexample.data.Model
import com.gmail.danylooliinyk.decomposeplutotvexample.value.ObservableValue

class SplashComponent : ISplash {

    private val _model = MutableValue(Model(SPLASH_TITLE))
    override val model: ObservableValue<Model> = _model

    companion object {
        private const val SPLASH_TITLE = "Splash"
    }
}
