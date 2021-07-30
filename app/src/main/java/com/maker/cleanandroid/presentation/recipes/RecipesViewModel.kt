package com.maker.cleanandroid.presentation.recipes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maker.cleanandroid.domain.model.FoodRecipe
import com.maker.cleanandroid.domain.usecases.GetRecipesUseCase
import com.maker.cleanandroid.shared.Constants.QUERY_ADD_RECIPE_INFORMATION
import com.maker.cleanandroid.shared.Constants.QUERY_API_KEY
import com.maker.cleanandroid.shared.Constants.QUERY_DIET
import com.maker.cleanandroid.shared.Constants.QUERY_FILL_INGREDIENTS
import com.maker.cleanandroid.shared.Constants.QUERY_NUMBER
import com.maker.cleanandroid.shared.Constants.QUERY_TYPE
import com.maker.cleanandroid.shared.Constants.SPOONACULAR_API_KEY
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class RecipesViewModel(
    private val getRecipesUseCase: GetRecipesUseCase
) : ViewModel() {
    private val _viewState = MutableLiveData<ViewState>()
    val viewState: LiveData<ViewState>
        get() = _viewState

    fun getRecipes() {
        viewModelScope.launch {
            getRecipesUseCase(mountQuery())
                .onStart {
                    _viewState.postValue(ViewState.Loading)
                }
                .catch { error ->
                    error.printStackTrace()
                    _viewState.postValue(ViewState.Error(error))
                }
                .collect { recipes ->
                    _viewState.postValue(ViewState.Success(recipes))
                }
        }
    }

    private fun mountQuery(): HashMap<String, String> {
        val queries: HashMap<String, String> = HashMap()
        queries[QUERY_NUMBER] = "50"
        queries[QUERY_API_KEY] = SPOONACULAR_API_KEY
        queries[QUERY_TYPE] = "snack"
        queries[QUERY_DIET] = "vegan"
        queries[QUERY_ADD_RECIPE_INFORMATION] = "true"
        queries[QUERY_FILL_INGREDIENTS] = "true"
        return queries
    }

    sealed class ViewState {
        object Loading : ViewState()
        data class Success(val recipes: FoodRecipe) : ViewState()
        data class Error(val error: Throwable) : ViewState()
    }
}