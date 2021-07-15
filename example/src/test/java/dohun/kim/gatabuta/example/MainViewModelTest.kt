package dohun.kim.gatabuta.example

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import dohun.kim.gatabuta.gatabuta_livedata.equalTo
import dohun.kim.gatabuta.gatabuta_livedata.isNull
import dohun.kim.gatabuta.gatabuta_livedata.test
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainViewModelTest {

    private lateinit var viewModel: MainViewModel

    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun init() {
        viewModel = MainViewModel()
    }

    @Test
    fun increaseTest() = runBlocking {
        viewModel.money.test.isNull()
        viewModel.nonNullableMoney.test equalTo 0L

        viewModel.increaseMoney()

        viewModel.money.test equalTo 1L
        viewModel.nonNullableMoney.test equalTo 1L
    }
}

