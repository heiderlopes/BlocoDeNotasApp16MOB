package com.example.logonpflocal.blocodenotasapp.view.formulario

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.logonpflocal.blocodenotasapp.model.Nota
import com.example.logonpflocal.blocodenotasapp.model.ResponseStatus
import com.example.logonpflocal.blocodenotasapp.repository.NotaRepository

class FormularioViewModel : ViewModel() {

    val notaRepository = NotaRepository()

    val responseStatus: MutableLiveData<ResponseStatus> = MutableLiveData()

    fun salvar(titulo: String, descricao: String) {
        val nota = Nota(null, titulo, descricao)
        notaRepository.salvar(nota,
                onComplete = {
                    responseStatus.value = ResponseStatus(true,
                            "Dados gravado com sucesso!")
                }, onError = {
                responseStatus.value = ResponseStatus(false,
                        it?.message!!)
        })


    }
}