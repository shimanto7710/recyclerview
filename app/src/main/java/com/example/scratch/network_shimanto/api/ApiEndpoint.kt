package com.example.scratch.network_shimanto.api



import com.example.scratch.network_shimanto.response.DummyResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*


interface ApiEndpoint {

    // retrofit with callback
    @GET("/todos/1")
     fun getDummyData() : Call<DummyResponse>

    // retrofit with coroutine
    @GET("/todos/1")
    suspend fun getDummyDataWithSuspend() : Response<DummyResponse>

//    @Headers("Content-Type: application/x-www-form-urlencoded")
//    @FormUrlEncoded
//    @POST("/token")
//    fun doLogin(
//        @Field("grant_type") type: String?,
//        @Field("username") userName: String?,
//        @Field("password") password: String?
//    ): Call<LoginResponse>

//    @POST("/api/authenticate")
//    fun authenticate(@Body authRequestBody: LogInRequestBody): Call<String>


//    @POST("/api/authenticate")
//    fun authenticate(@Body authRequestBody: AuthRequestBody): Call<String>
//
//    @POST("/api/login/")
//    fun login(@Body authenticationRequest: AuthRequestBody) : Call<LoginSuccessBody>

//    @POST("/api/Account/Register")
//    fun signUp(@Body signInRequest: RegistrationRequestBody): Call<Void>


//    @GET("/api/Review/GetReviewPosts")
//    fun getAllPosts():Call<List<Post>>



//    @PUT("/api/Review/UpdateReaction/{id}")
//    fun updateReaction(@Path("id") id: Long,@Body reactionRequestBody: ReactionRequestBody):Call<Reaction>

//    @DELETE("/api/Review/DeleteReaction/{id}")
//    fun deleteReaction(@Path("id") id:Long):Call<Void>


//    @Multipart
//    @POST("/1/upload/")
//    fun postAImage(@Query("key") key: String,@Part image : MultipartBody.Part):Call<ImageErrorResponse>
//
//    @Multipart
//    @POST("/api/Review/PostImages")
//    fun imageUpload(@Part image: ArrayList<MultipartBody.Part>): Call<List<String>>



}