package com.example.sound_mediaplayer_ejemplo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.media.MediaPlayer
import android.view.View
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    var mMediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /* 1. Play al sonido*/
    fun play(button: View){
        if(mMediaPlayer == null){
            mMediaPlayer = MediaPlayer.create(this, R.raw.sound)
            mMediaPlayer!!.start()
        }else mMediaPlayer!!.start()
    }

    /* 2. Pausa al sonido */
    fun pause(button: View){
        if(mMediaPlayer != null && mMediaPlayer!!.isPlaying){
            mMediaPlayer!!.pause()
        }
    }

    /* 3.Stop al sonido */
    fun stop(button: View){
        if(mMediaPlayer != null){
            mMediaPlayer!!.stop()
            mMediaPlayer!!.release()
            mMediaPlayer = null
            Toast.makeText(this, "MediaPlayer released",Toast.LENGTH_SHORT).show()
        }
    }

    override fun onStop() {
        super.onStop()
        if(mMediaPlayer != null){
            mMediaPlayer!!.release()
            mMediaPlayer = null
        }
    }

}