package com.example.hipolito.campeonatos.api

import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by hipolito on 11/02/18.
 */
class InterceptorFootballAPI(public val TOKEN: String): Interceptor{

    val AUTHORIZATION = "Authorization"

    override fun intercept(chain: Interceptor.Chain?): Response? {

        val request = chain!!.request().newBuilder()
                .build()

        return chain.proceed(request)
    }

}