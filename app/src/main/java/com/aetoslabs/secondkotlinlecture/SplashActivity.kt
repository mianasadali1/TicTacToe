package com.aetoslabs.secondkotlinlecture

import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        imageView5.translationY = -1000f
        textView3.translationY = 1000f

        imageView5.animate().translationY(0f).duration = 2000
        textView3.animate().translationY(0f).duration = 2000

        // This is used to hide the status bar and make
        // the splash screen as a full screen activity.

            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )


        // we used the postDelayed(Runnable, time) method
        // to send a message with a delayed time.


        Handler(Looper.getMainLooper()).postDelayed({
           val intent= Intent(this,StartGameActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)




    }
}