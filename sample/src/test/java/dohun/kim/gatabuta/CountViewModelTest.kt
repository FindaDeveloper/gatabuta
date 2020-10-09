package dohun.kim.gatabuta

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import dohun.kim.gatabuta.sample.CountViewModel
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CountViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: CountViewModel

    @Before
    fun init() {
        viewModel = CountViewModel()
    }

    @Test
    fun increase() {
        viewModel.increase()

        viewModel.histories hasSize 1
        viewModel.histories equals listOf(0)

        viewModel.countText equals "count: 1"
        viewModel.countText hasLength 8

        viewModel.count equals 1
    }
}