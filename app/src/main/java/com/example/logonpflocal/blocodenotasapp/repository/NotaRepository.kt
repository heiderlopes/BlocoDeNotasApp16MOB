package com.example.logonpflocal.blocodenotasapp.repository

import com.example.logonpflocal.blocodenotasapp.api.getNotaAPI
import com.example.logonpflocal.blocodenotasapp.model.Nota
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NotaRepository {

    fun buscarTodos(
            onComplete: (List<Nota>?) -> Unit,
            onError: (Throwable?) -> Unit
    ) {
        getNotaAPI()
                .buscarTodos()
                .enqueue(object : Callback<List<Nota>> {
                    override fun onFailure(call: Call<List<Nota>>?, t: Throwable?) {
                        onError(t)
                    }

                    override fun onResponse(call: Call<List<Nota>>?, response: Response<List<Nota>>?) {
                        onComplete(response?.body())
                    }
                })
    }


}