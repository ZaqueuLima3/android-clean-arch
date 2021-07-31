package com.maker.cleanandroid.presentation.recipes

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.maker.cleanandroid.databinding.FragmentRecipesBinding
import com.maker.cleanandroid.presentation.BindingFragment

class RecipesFragment(
    private val viewModel: RecipesViewModel,
    private val recipesAdapter: RecipesAdapter
) : BindingFragment<FragmentRecipesBinding>(FragmentRecipesBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
    }

    private fun setupUI() {
        setupRecyclerView()
        setupListeners()
        observeViewStateUpdates()
    }

    private fun setupRecyclerView() {
        binding.rvRecipesList.apply {
            adapter = recipesAdapter
            layoutManager = GridLayoutManager(requireContext(), ITEMS_PER_ROW)
            setHasFixedSize(true)
        }
    }

    private fun setupListeners() {
        binding.swipeContainer.setOnRefreshListener {
            requestRecipes()
        }
    }

    private fun observeViewStateUpdates() {
        viewModel.viewState.observe(viewLifecycleOwner) { viewState ->
            updateScreenState(viewState)
        }
    }

    private fun updateScreenState(viewState: RecipesViewModel.ViewState) {
        when (viewState) {
            is RecipesViewModel.ViewState.Loading -> {
            }
            is RecipesViewModel.ViewState.Error -> {
            }
            is RecipesViewModel.ViewState.Success -> {
                recipesAdapter.submitList(viewState.recipes)
            }
        }
    }

    private fun requestRecipes() {
        viewModel.requestRecipes()
        binding.swipeContainer.isRefreshing = false
    }

    companion object {
        private const val ITEMS_PER_ROW = 2
    }
}
