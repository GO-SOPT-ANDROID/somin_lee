//package org.android.go.sopt.interceptor
//
//import android.security.KeyChain
//import okhttp3.Interceptor
//import okhttp3.Response
//
//class SoptInterceptor : Interceptor {
//    override fun intercept(chain: Interceptor.Chain): Response {
//        val originRequest = chain.request()
//        val newRequest = originRequest.newBuilder()
//            .header("Authorization <- 키 값은 이걸로 주로 사용합니다.", /* 토큰의 실제 값! */)
//            .build()
//        return chain.proceed(headerRequest)
//    }
//}