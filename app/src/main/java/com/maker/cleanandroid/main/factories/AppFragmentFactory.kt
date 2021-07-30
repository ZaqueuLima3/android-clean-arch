package com.maker.cleanandroid.main.factories

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.maker.cleanandroid.presentation.recipes.RecipesAdapter
import com.maker.cleanandroid.presentation.recipes.RecipesFragment
import com.maker.cleanandroid.presentation.recipes.RecipesViewModel
import org.koin.java.KoinJavaComponent.getKoin

class AppFragmentFactory : FragmentFactory() {
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        val fragmentClass = Class.forName(className).kotlin
        val instance = getKoin().getOrNull<Fragment>(fragmentClass)
        return instance ?: super.instantiate(classLoader, className)
    }
}
