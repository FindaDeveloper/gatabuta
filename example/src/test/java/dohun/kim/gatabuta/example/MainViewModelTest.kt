package dohun.kim.gatabuta.example

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import kotlinx.coroutines.runBlocking
import kr.co.finda.finda.gatabuta.equalTo
import kr.co.finda.finda.gatabuta.isNull
import kr.co.finda.finda.gatabuta.test
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

