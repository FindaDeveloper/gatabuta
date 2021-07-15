package dohun.kim.gatabuta.example

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _money = MutableLiveData<Long?>()
    val money: LiveData<Long?> = _money

    private val _nonNullableMoney = MutableLiveData<Long>(0)
    val nonNullableMoney: LiveData<Long> = _nonNullableMoney

    fun increaseMoney() {
        _money.value = money.value?.plus(1) ?: 1
        _nonNullableMoney.value = nonNullableMoney.value?.plus(1) ?: 1
    }
}