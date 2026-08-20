package br.edu.ifsp.scl.sc3035018.activitylifecycle

import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.edu.ifsp.scl.sc3035018.activitylifecycle.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val amb : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private lateinit var loginEt: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(amb.root)

        loginEt = EditText(this).apply {
            hint = "Login"
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
        }

        savedInstanceState?.let {
            val login = savedInstanceState.getString("LOGIN", "")
            loginEt.setText(login)
        }

        amb.main.addView(loginEt)

        Log.v("AL", "onCreate: Inicio COMPLETO")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("LOGIN", loginEt.text.toString())
        Log.v("AL", "onSaveInstanceState")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val login = savedInstanceState.getString("LOGIN", "")
        loginEt.setText(login)
        Log.v("AL", "onRestoreInstanceState")
    }

    override fun onStart() {
        super.onStart()
        Log.v("AL", "onStart: Inicio VISIVEL")
    }

    override fun onResume() {
        super.onResume()
        Log.v("AL", "onResume: Inicio FOREGROUND")
    }

    override fun onPause() {
        super.onPause()
        Log.v("AL", "onPause: Fim FOREGROUND")
    }

    override fun onStop() {
        super.onStop()
        Log.v("AL", "onStop: Fim VISIVEL")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v("AL", "onDestroy: Fim COMPLETO")
    }

    override fun onRestart() {
        super.onRestart()
        Log.v("AL", "onRestart")
    }
}