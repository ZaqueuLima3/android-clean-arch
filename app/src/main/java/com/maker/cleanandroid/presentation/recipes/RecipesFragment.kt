package com.maker.cleanandroid.presentation.recipes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.maker.cleanandroid.databinding.FragmentRecipesBinding

class RecipesFragment(
    private val viewModel: RecipesViewModel,
    private val recipesAdapter: RecipesAdapter
) : Fragment() {
    private val binding by lazy { FragmentRecipesBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        requestInitialRecipes()
    }

    private fun setupUI() {
        setupRecyclerView()
        observeViewStateUpdates()
    }

    private fun setupRecyclerView() {
        binding.rvRecipesList.apply {
            adapter = recipesAdapter
            layoutManager = GridLayoutManager(requireContext(), ITEMS_PER_ROW)
            setHasFixedSize(true)
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
                recipesAdapter.submitList(viewState.recipes.recipes)
                recipesAdapter.notifyDataSetChanged()
            }
        }
    }

    private fun requestInitialRecipes() {
        viewModel.getRecipes()
    }

    companion object {
        private const val ITEMS_PER_ROW = 2
    }
}
