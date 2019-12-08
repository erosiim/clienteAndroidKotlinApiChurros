package com.doubleaa.ourpeda.APIInterfaceRequest

import com.doubleaa.clienteapibase.HttpBodyPojos.ChurroBodyPojo
import com.doubleaa.clienteapibase.HttpResponsePojos.ChurroResponse
import retrofit2.Call
import retrofit2.http.*

interface IHostApiService {

/*----------------------------Churros-----------------------*/


    @GET("churros")
    fun getChurros(): Call<ArrayList<ChurroResponse> >

    @POST("churros")
    fun insertChurro(@Body body: ChurroBodyPojo): Call<String>

    @GET("churros/{id}")
    fun getChurroById(@Path("id") id : String): Call<ChurroResponse>

    @PUT("churros")
    fun updateChurro(@Body body: ChurroBodyPojo) : Call<String>

    @DELETE("churros/{id}")
    fun deleteChurro(@Path("id") id : String ): Call<String>



/*----------------------------Pedas-----------------------*/





}