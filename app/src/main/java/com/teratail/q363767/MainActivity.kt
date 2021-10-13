package com.teratail.q363767

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

  private lateinit var soundManager: SoundManager

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    soundManager = SoundManager(this) //初期化

    val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    viewModel.alarmController = object: MainViewModel.AlarmController {
      override fun startAlarm() {
        soundManager.playOne()
        setAlarmFragment()
      }
      override fun stopAlarm() {
        soundManager.cancelOne()
        setMainFragment()
      }
    }

    setMainFragment()
  }

  fun setMainFragment() {
    supportFragmentManager.beginTransaction()
      .add(R.id.container, MainFragment.newInstance())
      //.addToBackStack(null)
      .commit()
  }

  fun setAlarmFragment() {
    supportFragmentManager.beginTransaction()
      .add(R.id.container, AlarmFragment.newInstance())
      //.addToBackStack(null)
      .commit()
  }
}