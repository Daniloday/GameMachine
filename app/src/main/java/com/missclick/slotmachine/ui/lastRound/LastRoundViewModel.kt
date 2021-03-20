package com.missclick.slotmachine.ui.lastRound

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.missclick.slotmachine.data.database.repository.IStatkaRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LastRoundViewModel(private val repository: IStatkaRepository) : ViewModel() {

    fun saveStatka(id : Int){
        viewModelScope.launch{
            repository.doingSomething(id)
        }

    }
}