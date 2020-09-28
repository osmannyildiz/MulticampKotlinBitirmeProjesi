package ml.ikiyuz.multicampkotlinapp.data

import ml.ikiyuz.multicampkotlinapp.data.model.Community
import retrofit2.http.GET

interface MyApi {
    @GET("communities")
    suspend fun getCommunities(): List<Community>
}