package com.example.kot104_assignmentfinal.httpModel

import com.fasterxml.jackson.annotation.JsonProperty

data class LoginRequestModel(
    @JsonProperty("username") val username: String?,
    @JsonProperty("password") val password: String?
)