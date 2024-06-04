package com.example.kot104_assignmentfinal.helper

import android.util.Log
import com.example.kot104_assignmentfinal.httpModel.CategoryResponseModel
import com.example.kot104_assignmentfinal.httpModel.LoginRequestModel
import com.example.kot104_assignmentfinal.httpModel.LoginResponseModel
import com.example.kot104_assignmentfinal.httpModel.ProductResponseModel
import com.example.kot104_assignmentfinal.httpModel.RegisterRequestModel
import com.example.kot104_assignmentfinal.httpModel.RegisterResponseModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RetrofitAPI {
    private val retrofit = RetrofitClient.getClient()
    private val api = retrofit.create(IRetrofit::class.java)

    fun registerUser(
        user: RegisterRequestModel,
        callback: (RegisterResponseModel?) -> Unit
    ) {
        api.register(user).enqueue(object : Callback<RegisterResponseModel> {
            override fun onResponse(
                call: Call<RegisterResponseModel>,
                response: Response<RegisterResponseModel>
            ) {
                if (response.isSuccessful) {
                    callback(response.body())
                } else {
                    println("error to register: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<RegisterResponseModel>, t: Throwable) {
//                t.printStackTrace()
                Log.d("Failed to register", t.printStackTrace().toString())
            }
        })
    }

    fun loginUser(
        user: LoginRequestModel,
        callback: (LoginResponseModel?) -> Unit
    ) {
        api.login(user).enqueue(object : Callback<LoginResponseModel> {
            override fun onResponse(
                call: Call<LoginResponseModel>,
                response: Response<LoginResponseModel>
            ) {
                if (response.isSuccessful) {
                    callback(response.body())
                } else {
                    println("error to register: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<LoginResponseModel>, t: Throwable) {
//                t.printStackTrace()
                Log.d("Failed to register", t.printStackTrace().toString())
            }
        })
    }

    fun getAllProduct(callback: (ProductResponseModel?) -> Unit) {
        api.getProduct().enqueue(object : Callback<ProductResponseModel> {
            override fun onResponse(
                call: Call<ProductResponseModel>,
                response: Response<ProductResponseModel>
            ) {
                if (response.isSuccessful) {
                    callback(response.body())
                } else {
                    println("error to getProduct: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<ProductResponseModel>, t: Throwable) {
//                t.printStackTrace()
                Log.d("Failed to getProduct", t.printStackTrace().toString())
                t.printStackTrace()
            }
        })
    }

    fun getAllCategory(callback: (CategoryResponseModel?) -> Unit) {
        api.getCategory().enqueue(object : Callback<CategoryResponseModel> {
            override fun onResponse(
                call: Call<CategoryResponseModel>,
                response: Response<CategoryResponseModel>
            ) {
                if (response.isSuccessful) {
                    callback(response.body())
                } else {
                    println("error to getCategory: ${response.message()}")
                }
            }
            override fun onFailure(call: Call<CategoryResponseModel>, t: Throwable) {
                Log.d("Failed to getCategory", t.printStackTrace().toString())
                t.printStackTrace()
            }
        })
    }
}