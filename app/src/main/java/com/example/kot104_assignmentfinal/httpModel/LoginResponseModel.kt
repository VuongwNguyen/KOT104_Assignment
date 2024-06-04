package com.example.kot104_assignmentfinal.httpModel

import com.fasterxml.jackson.annotation.JsonProperty


data class LoginResponseModel(
    @JsonProperty("user") val user: User?,
    @JsonProperty("status") val status: Boolean
)
