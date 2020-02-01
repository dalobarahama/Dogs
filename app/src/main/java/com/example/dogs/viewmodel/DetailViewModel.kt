package com.example.dogs.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.dogs.model.DogBreed
import com.example.dogs.model.DogDatabase
import kotlinx.coroutines.launch
import java.util.*

/**
 * Created by pengalatdite on 1/23/2020.
 */
class DetailViewModel(application: Application) : BaseViewModel(application) {

    val dogsDetail = MutableLiveData<DogBreed>()

    fun fetch(uuid: Int) {
        launch {
            val dog = DogDatabase(getApplication()).dogDao().getDog(uuid)
            dogsDetail.value = dog
        }
    }


}