package com.example.practical6

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import java.lang.Override as Override1
import kotlin.isInitialized as isInitialized1

class MyService : Service() {
    lateinit var Player : MediaPlayer
    companion object{val PLAYERKEY="service"
        val PLAYERVALUE="play/pause"
    }


        override fun onBind(intent: Intent): IBinder {

        TODO("Return the communication channel to the service.")

             fun onStartCommand(intent: Intent?, flags:
            Int, startId: Int): Int {
                 if(!this::Player.isInitialized1){
                     Player= MediaPlayer.create(this,R.raw.song)
                 }
                 if(!this::Player.isInitialized1){
                    Player= MediaPlayer.create(this,R.raw.song)
                }
                if(intent!=null){
                    val datavalue=intent.getStringExtra(PLAYERKEY)
                    if(datavalue== PLAYERVALUE){
                        if(!Player.isPlaying){
                            Player.start()
                        }
                        else{
                            Player.pause()
                        }
                    }
                }
                else{
                    Player.stop()
                }
                return START_STICKY
            }
             fun onDestroy() {
                Player.stop()
                super.onDestroy()
            } }

}
