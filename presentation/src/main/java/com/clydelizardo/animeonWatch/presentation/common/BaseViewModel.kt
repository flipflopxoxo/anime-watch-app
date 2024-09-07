package com.clydelizardo.animeonWatch.presentation.common

import androidx.lifecycle.ViewModel

abstract class BaseViewModel<ACTION: Action>: ViewModel() {
    /**
     * Allow the view model to handle an action received from the user
     * @return whether the action has been handled by the view model
     */
    abstract fun handleAction(action: ACTION): Boolean
}