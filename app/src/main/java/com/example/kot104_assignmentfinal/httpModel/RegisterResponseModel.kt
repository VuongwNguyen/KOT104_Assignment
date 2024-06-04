package com.example.kot104_assignmentfinal.httpModel

import com.fasterxml.jackson.annotation.JsonProperty

data class RegisterResponseModel(
    @JsonProperty("user") val user: User?,
    @JsonProperty("status") val status: Boolean
)


data class User(
    @JsonProperty("_id") val id: String?,
    @JsonProperty("username") val username: String?,
    @JsonProperty("password") val password: String?,
    @JsonProperty("phone") val phone: String?,
    @JsonProperty("email") val email: String?,
    @JsonProperty("avatar") val avatar: String?,
    @JsonProperty("status") val status: String?,
    @JsonProperty("deleted_at") val deletedAt: String?,
    @JsonProperty("created_at") val createdAt: String,
    @JsonProperty("cart") val cart: List<Any>?,
    @JsonProperty("__v") val v: Int?,
)
