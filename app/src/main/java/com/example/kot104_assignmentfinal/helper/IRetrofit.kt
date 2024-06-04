package com.example.kot104_assignmentfinal.helper

import com.example.kot104_assignmentfinal.httpModel.CategoryResponseModel
import com.example.kot104_assignmentfinal.httpModel.LoginRequestModel
import com.example.kot104_assignmentfinal.httpModel.LoginResponseModel
import com.example.kot104_assignmentfinal.httpModel.ProductResponseModel
import com.example.kot104_assignmentfinal.httpModel.RegisterRequestModel
import com.example.kot104_assignmentfinal.httpModel.RegisterResponseModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface IRetrofit {

    //    khai bao api
    @POST("user/register")
    fun register(@Body registerRequestModel: RegisterRequestModel): Call<RegisterResponseModel>

    @POST("user/login")
    fun login(@Body loginRequestModel: LoginRequestModel): Call<LoginResponseModel>

    @GET("product/getAllProduct")
    fun getProduct(): Call<ProductResponseModel>

    @GET("category/getAllCategory")
    fun getCategory(): Call<CategoryResponseModel>

}