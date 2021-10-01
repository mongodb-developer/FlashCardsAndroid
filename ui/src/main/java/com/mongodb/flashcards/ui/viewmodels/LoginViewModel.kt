package com.mongodb.flashcards.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    private val _buttonEnabled = MutableLiveData<Boolean>(false)
    val buttonEnabled: LiveData<Boolean>
        get() = _buttonEnabled

    fun onCredentialsChanged(userName: String, password: String) {
        _buttonEnabled.value = userName.isNotEmpty() && password.isNotEmpty()
    }

    // It always does login
    fun login(userName: String, password: String): Boolean = true
}
