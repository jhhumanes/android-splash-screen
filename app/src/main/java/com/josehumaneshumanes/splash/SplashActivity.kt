package com.josehumaneshumanes.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class SplashActivity : AppCompatActivity(), CoroutineScope {
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    private lateinit var job: Job

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initScope()

        initApp()
    }

    override fun onDestroy() {
        job.cancel()
        super.onDestroy()
    }

    private fun initApp() {
        launch {
            // TODO - Tasks to be done before MainActivity is shown.
            // delay(3000) simulates these tasks.
            delay(3000)

            goToMainActivity()
        }
    }

    private fun goToMainActivity() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    private fun initScope() {
        job = SupervisorJob()
    }
}