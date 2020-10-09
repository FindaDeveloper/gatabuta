package dohun.kim.gatabuta.sample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map

class CountViewModel : ViewModel() {

    private val _histories = MutableLiveData(listOf<Int>())
    val histories: LiveData<List<Int>> = _histories

    private val _count = MutableLiveData(0)
    val count: LiveData<Int> = _count

    val countText: LiveData<String> = count.map {
        "count: $it"
    }

    fun increase() {
        val current = count.value ?: 0
        addHistory(current)
        _count.value = current + 1
    }

    private fun addHistory(current: Int) {
        val list = histories.value ?: listOf()
        _histories.value = list + current
    }
}