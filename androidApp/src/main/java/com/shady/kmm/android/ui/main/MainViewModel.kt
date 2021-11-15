package com.shady.kmm.android.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shady.kmm.android.BuildConfig
import com.shady.kmm.entity.BannersList
import com.shady.kmm.entity.MainScreenList
import com.shady.kmm.repository.MainScreenRepo
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    val repo = MainScreenRepo()
    // Add 2 vars in the project "local.properties" with names BASE_URL and TOKEN
    fun getBanners(): MutableLiveData<List<BannersList>>{
        val data = MutableLiveData<List<BannersList>>()
        viewModelScope.launch {
            try {
                data.postValue(repo.getBanners(BuildConfig.BASE_URL, BuildConfig.TOKEN))
            } catch (e: Exception) {
                Log.e("Get Banner:", "Error ${e.localizedMessage}")
            }
        }
        return data
    }

    fun getMainScreenData(): MutableLiveData<List<MainScreenList>>{
        val data = MutableLiveData<List<MainScreenList>>()
        viewModelScope.launch {
            try {
                data.postValue(repo.getMainScreenData(BuildConfig.BASE_URL, BuildConfig.TOKEN))
            } catch (e: Exception) {
                Log.e("Get MainScreen:", "Error ${e.localizedMessage}")
            }
        }
        return data
    }

}