package com.example.scratch.network.call

import com.example.scratch.core.Either
import com.example.scratch.network.ApiResponse
import com.example.scratch.network.response.DummyResponse
import retrofit2.Response

interface NetworkCall {

    // callback
    fun dummyData(callback: NRCallback<DummyResponse>)

    suspend fun suspendResponseCallback(callback: NRCallback<DummyResponse>)

    suspend fun suspendResponse() :Response<DummyResponse>

    suspend fun suspendResponseWithErrorFiltering(): ApiResponse<DummyResponse>

    suspend fun perfectWay() : DummyResponse



//    suspend fun either() :  Either<String, DummyResponse>


//    fun auth(loginRe: LogInRequestBody, callback: NRCallback<LoginResponse>)
//
//    fun login(logInRequestBody: LogInRequestBody, callback: NRCallback<String>)
//
//    fun registration(registrationRequestBody: RegistrationRequestBody, callback: NRCallback<Void>)
//
//    fun getPostById(postId: Long,callback: NRCallback<Post>)
//
//    fun getMainComment(postId : Long, callback : NRCallback<ArrayList<PostComment>> )
//
//    fun postToServer(post:PostRequestBody, callback: NRCallback<Void>)
//
//    fun getAllPosts(callback: NRCallback<List<Post>>)
//
//    fun getAllItems(callback: NRCallback<List<Item>>)
//
//    fun getAllRestaurants(callback: NRCallback<List<RestaurantOrPlace>>)
//
//    fun getAllTags(callback: NRCallback<List<Tag>>)
//
//    fun getUSerById(id:String,callback: NRCallback<User>)
//
//    fun createReaction(reactionRequestBody: ReactionRequestBody,callback: NRCallback<Reaction>)
//
//    fun updateReaction(id: Long,reactionRequestBody: ReactionRequestBody,callback: NRCallback<Reaction>)
//
//    fun deleteReaction(id:Long,callback: NRCallback<Void>)
//
//    fun createCommentReaction(commentReactionRequestBody: CommentReactionRequestBody,callback: NRCallback<Reaction>)
//
//    fun updateCommentReaction(id:Long,commentReactionRequestBody: CommentReactionRequestBody,callback: NRCallback<Void>)
//
//    fun deleteCommentReaction(id:Long,callback: NRCallback<Void>)
//
//    fun createReplyReaction(replyReactionRequestBody: ReplyReactionRequestBody,callback: NRCallback<Reaction>)
//
//    fun updateReplyReaction(id:Long,reactionRequestBody: ReplyReactionRequestBody,callback: NRCallback<Void>)
//
//    fun deleteReplyReaction(id:Long,callback: NRCallback<Void>)
//
//    fun postAComment(commentRequestBody: CommentRequestBody,callback: NRCallback<PostComment>)
//
//    fun deleteAComment(id:Long, callback: NRCallback<Void>)
//
//    fun postAReplay(replyRequestBody: ReplyRequestBody,callback: NRCallback<SubComment>)
//
//    fun deleteAReply(id:Long,callback: NRCallback<Void>)
//
//    fun deletePostById(id:Long,callback: NRCallback<Void>)
//
//    fun updatePostById(id: Long,postRequestBody: PostRequestBody,callback: NRCallback<Void>)
//
//    fun getPostsByUserId(id:String,callback: NRCallback<List<Post>>)
//
//    fun getPostsById(id:Long,callback: NRCallback<Post>)
//
//    fun postAImage(key:String, image : MultipartBody.Part,requestBody:RequestBody?,callback: NRCallback<ImageErrorResponse>)
//
//    fun uploadImage( image : ArrayList<MultipartBody.Part> ,callback: NRCallback<List<String>>)
//
//    fun deleteImageById(id:Long,callback: NRCallback<Void>)


}
