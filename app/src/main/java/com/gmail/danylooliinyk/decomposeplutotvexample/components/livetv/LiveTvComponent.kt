package com.gmail.danylooliinyk.decomposeplutotvexample.components.livetv

import com.arkivanov.decompose.value.MutableValue
import com.gmail.danylooliinyk.decomposeplutotvexample.data.Model
import com.gmail.danylooliinyk.decomposeplutotvexample.value.ObservableValue

class LiveTvComponent : ILiveTv {

    private val _model = MutableValue(Model(LIVE_TV_TITLE))
    override val model: ObservableValue<Model> = _model

    companion object {
        private const val LIVE_TV_TITLE = "Live TV"
    }
}