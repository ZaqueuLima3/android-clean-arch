package com.maker.cleanandroid.infra.cache.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.maker.cleanandroid.infra.cache.room.daos.RecipesDao
import com.maker.cleanandroid.infra.cache.room.models.CachedExtendedIngredients
import com.maker.cleanandroid.infra.cache.room.models.CachedRecipes

@Database(
    entities = [
        CachedRecipes::class,
        CachedExtendedIngredients::class
    ],
    version = 1
)
abstract class SpoonacularDatabase : RoomDatabase() {
    abstract fun recipesDao(): RecipesDao

    companion object {
        private const val SPOONACULAR_DATABASE = "spoonacular_db"
        fun getDatabase(context: Context): SpoonacularDatabase {
            return Room.databaseBuilder(
                context,
                SpoonacularDatabase::class.java,
                SPOONACULAR_DATABASE
            ).build()
        }
    }
}
