package com.example.kot104_assignmentfinal.httpModel

import com.fasterxml.jackson.annotation.JsonProperty

data class RegisterRequestModel(
    @JsonProperty("username") val username: String?,
    @JsonProperty("password") val password: String?,
    @JsonProperty("email") val email: String?,
    @JsonProperty("phone") val phone: String?
)
