package com.gmail.danylooliinyk.decomposeplutotvexample.components.search

import com.arkivanov.decompose.value.MutableValue
import com.gmail.danylooliinyk.decomposeplutotvexample.data.Model
import com.gmail.danylooliinyk.decomposeplutotvexample.value.ObservableValue

class SearchComponent : ISearch {

    private val _model = MutableValue(Model(SEARCH_TITLE))
    override val model: ObservableValue<Model> = _model

    companion object {
        private const val SEARCH_TITLE = "Search"
    }
}