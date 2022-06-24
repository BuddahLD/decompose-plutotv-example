package com.gmail.danylooliinyk.decomposeplutotvexample.components.ondemand

import com.arkivanov.decompose.value.MutableValue
import com.gmail.danylooliinyk.decomposeplutotvexample.data.Model
import com.gmail.danylooliinyk.decomposeplutotvexample.value.ObservableValue

class OnDemandComponent : IOnDemand {

    private val _model = MutableValue(Model(ON_DEMAND_TITLE))
    override val model: ObservableValue<Model> = _model

    companion object {
        private const val ON_DEMAND_TITLE = "On Demand"
    }
}