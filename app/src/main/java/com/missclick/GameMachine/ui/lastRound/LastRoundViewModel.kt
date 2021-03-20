package com.missclick.GameMachine.ui.lastRound

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.missclick.GameMachine.data.database.repository.IStatkaRepository
import kotlinx.coroutines.launch

class LastRoundViewModel(private val repository: IStatkaRepository) : ViewModel() {

    fun saveStatka(id : Int){
        viewModelScope.launch{
            repository.doingSomething(id)
        }

    }
}