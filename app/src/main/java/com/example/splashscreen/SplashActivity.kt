package com.example.splashscreen

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.splashscreen.activity.MainActivity
import java.util.concurrent.TimeUnit

@SuppressLint("CustomSplashScreen")
class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splashScreen()
    }

    private fun splashScreen() {
        installSplashScreen().setKeepOnScreenCondition { true }
        Thread {
            TimeUnit.SECONDS.sleep(SPLASH_SCREEN_TIME_OUT)
            startActivity(Intent(this, MainActivity::class.java))
            finishAffinity()
        }.start()
    }

    companion object {
        private const val SPLASH_SCREEN_TIME_OUT = 3L
    }
}