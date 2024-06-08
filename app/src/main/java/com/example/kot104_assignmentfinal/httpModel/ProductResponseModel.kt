package com.example.kot104_assignmentfinal.httpModel

import com.fasterxml.jackson.annotation.JsonProperty

data class Category(
    @JsonProperty("_id") val _id: String,
    @JsonProperty("name") val name: String,
    @JsonProperty("description") val description: String?,
    @JsonProperty("parent_id") val parent_id: Object?,
    @JsonProperty("status") val status: String?,
    @JsonProperty("deleted_at") val deleted_at: String?,
    @JsonProperty("created_at") val created_at: String?,
    @JsonProperty("__v") val __v: Int?
)
data class Product(
    @JsonProperty("_id") val _id: String,
    @JsonProperty("name") val name: String,
    @JsonProperty("image") val image: List<String> = listOf(),
    @JsonProperty("price") val price: Int,
    @JsonProperty("quantity") val quantity: Int,
    @JsonProperty("category_id") val category_id: Category,
    @JsonProperty("status") val status: String,
    @JsonProperty("deleted_at") val deleted_at: String?,
    @JsonProperty("created_at") val created_at: String,
    @JsonProperty("__v") val __v: Int
)
data class ProductResponseModel (
    @JsonProperty("products") val products: List<Product>?,
    @JsonProperty("status") val message: Boolean
)