package com.teratail.q363767

import android.content.Context
import android.media.AudioAttributes
import android.media.SoundPool
import android.util.Log

class SoundManager(context: Context) {

  private var soundPool: SoundPool
  private var soundOne = 0
  private var streamId2 = 0

  init {
    //soundPool設定
    val audioAttributes = AudioAttributes.Builder()
      .setUsage(AudioAttributes.USAGE_GAME)
      .setContentType(AudioAttributes.CONTENT_TYPE_SPEECH)
      .build()

    soundPool = SoundPool.Builder()
      .setAudioAttributes(audioAttributes)
      .setMaxStreams(1)
      .build()

    soundOne = soundPool.load(context, R.raw.bellsound, 1)
    Log.d("debug", "SoundManager init")
  }

  fun playOne() {
    cancelOne()
    streamId2 = soundPool.play(soundOne, 1.0f, 1.0f, 0, -1, 1.0f)
  }

  fun cancelOne() {
    if(streamId2 != 0) {  //fun playOneを通るとここを通る(音が鳴るとstreamId2= 1 が入る)
      soundPool.stop(streamId2)
      streamId2 = 0
    }
  }
}