package com.doubleaa.clienteapibase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.doubleaa.clienteapibase.HttpBodyPojos.ChurroBodyPojo
import com.doubleaa.clienteapibase.HttpResponsePojos.ChurroResponse
import com.doubleaa.ourpeda.APIInterfaceRequest.IHostApiService
import kotlinx.android.synthetic.main.activity_catalogo1.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class Catalogo1 : AppCompatActivity() {

    val retrofit = Retrofit.Builder().addCallAdapterFactory(
        RxJava2CallAdapterFactory.create())
        .addConverterFactory(
            GsonConverterFactory.create())
        .baseUrl("http://192.168.1.76:8084/apiChurros/webresources/")
        .build();

    var retrofitobj = retrofit.create(IHostApiService::class.java)



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalogo1)

        btnInsertarCatalogo1.setOnClickListener {
            Toast.makeText(this, "Ingresando...", Toast.LENGTH_LONG).show()
            insertOne()
        }

        btnBuscarCatalogo1.setOnClickListener {
            Toast.makeText(this, "Buscando...", Toast.LENGTH_LONG).show()
            getOnebyId()
        }


        btnActualizarCatalogo1.setOnClickListener {
            Toast.makeText(this, "Actualizando...", Toast.LENGTH_LONG).show()
            updateOne()
        }

        btnBorrarCatalogo1.setOnClickListener {
            Toast.makeText(this, "Borrando...", Toast.LENGTH_LONG).show()
            deleteOne()
        }

    }


    fun insertOne(){
        //INICIA POST
        var newChurro = ChurroBodyPojo()
        newChurro.id_churro = txtIdCatalogo1.text.toString()
        newChurro.tipo = txtTipoCatalogo1.text.toString()
        newChurro.precio = txtPrecioCatalogo1.text.toString()

        retrofitobj.insertChurro(newChurro).enqueue(
            object : Callback<String> {
                override fun onFailure(call: Call<String>, t: Throwable) {
                    Toast.makeText(this@Catalogo1, "ERROR ADDING", Toast.LENGTH_LONG)
                    Log.d("ERROR", t.message)

                }

                override fun onResponse(call: Call<String>, response: Response<String>) {
                    if (response.isSuccessful()){
                        var t = Toast.makeText(this@Catalogo1, "ADDED", Toast.LENGTH_LONG)
                        t.show()
                    }
                }
            }

        )

    }



    fun getOnebyId(){
        //INICIA GET ONE
        retrofitobj.getChurroById(txtIdCatalogo1.text.toString()).enqueue(
            object : Callback<ChurroResponse> {
                override fun onFailure(call: Call<ChurroResponse>, t: Throwable) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onResponse(
                    call: Call<ChurroResponse>,
                    response: Response<ChurroResponse>
                ) {
                    Log.d("I FOUND "+ response.body()?.id_churro, "I FOUND "+ response.body()?.precio )
                    var t = Toast.makeText(this@Catalogo1, "Goood", Toast.LENGTH_LONG)
                    t.show()
                    txtTipoCatalogo1.setText(response.body()?.tipo)
                    txtPrecioCatalogo1.setText(response.body()?.precio)
                }

            }
        )
        //TERMINA GET ONE
    }

    fun updateOne(){

        var newChurro1 = ChurroBodyPojo()

        newChurro1.id_churro = txtIdCatalogo1.text.toString()
        newChurro1.tipo = txtTipoCatalogo1.text.toString()
        newChurro1.precio = txtPrecioCatalogo1.text.toString()
        //INICIA PUT

        retrofitobj.updateChurro(newChurro1).enqueue(
            object : Callback<String> {
                override fun onFailure(call: Call<String>, t: Throwable) {
                    Toast.makeText(this@Catalogo1, "ERROR UPDATING", Toast.LENGTH_LONG)
                    Log.d("ERROR", t.message)

                }

                override fun onResponse(call: Call<String>, response: Response<String>) {
                    if (response.isSuccessful()){
                        Toast.makeText(this@Catalogo1, "UPDATED", Toast.LENGTH_LONG).show()

                    }
                }
            }
        )
        //TERMINA PUT
    }


    fun deleteOne(){
        var newChurro1 = ChurroBodyPojo()
        newChurro1.id_churro = txtIdCatalogo1.text.toString()

        retrofitobj.deleteChurro(newChurro1.id_churro.toString()).enqueue(
            object : Callback<String> {
                override fun onFailure(call: Call<String>, t: Throwable) {
                    Toast.makeText(this@Catalogo1, "ERROR DELETING", Toast.LENGTH_LONG)
                    Log.d("ERROR", t.message)


                }

                override fun onResponse(call: Call<String>, response: Response<String>) {
                    if (response.isSuccessful()){
                        var t = Toast.makeText(this@Catalogo1, "DELETED", Toast.LENGTH_LONG)
                        t.show()
                    }
                }
            }
        )
        // TERMINA DELETE
    }






}
