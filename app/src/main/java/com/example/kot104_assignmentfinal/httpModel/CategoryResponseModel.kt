package com.example.kot104_assignmentfinal.httpModel

import com.fasterxml.jackson.annotation.JsonProperty

data class CategoryResponseModel(
    @JsonProperty("categories") val categories: List<Category>?,
    @JsonProperty("status") val message: Boolean
)
