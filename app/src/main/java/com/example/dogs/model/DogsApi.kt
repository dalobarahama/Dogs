package com.example.dogs.model

import io.reactivex.Single
import retrofit2.http.GET

/**
 * Created by pengalatdite on 1/24/2020.
 */
interface DogsApi {

    @GET("DevTides/DogsApi/master/dogs.json")
    fun getDogs(): Single<List<DogBreed>>
}