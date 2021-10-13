package com.teratail.q363767

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

  interface AlarmController {
    fun startAlarm()
    fun stopAlarm()
  }

  private val _alarmState: MutableLiveData<Boolean> = MutableLiveData()
  val alarmState: LiveData<Boolean> get() = _alarmState

  init {
    _alarmState.value = false
  }

  var alarmController: AlarmController? = null
    set(value) {
      field = value
    }

  fun startAlarm() {
    alarmController?.startAlarm()
    _alarmState.value = true
  }

  fun stopAlarm() {
    alarmController?.stopAlarm()
    _alarmState.value = false
  }
}