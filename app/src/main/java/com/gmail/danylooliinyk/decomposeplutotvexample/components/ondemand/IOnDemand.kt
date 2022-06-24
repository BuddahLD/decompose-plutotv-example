package com.gmail.danylooliinyk.decomposeplutotvexample.components.ondemand

import com.gmail.danylooliinyk.decomposeplutotvexample.data.Model
import com.gmail.danylooliinyk.decomposeplutotvexample.value.ObservableValue

interface IOnDemand {

    val model: ObservableValue<Model>
}
