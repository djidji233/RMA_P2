package rs.raf.projekat2.Djordje_Zivanovic_RN9818.presentation.view.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    private val USER_DATA = "UserData"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init(){
        val sharedPref = getSharedPreferences(USER_DATA, Context.MODE_PRIVATE)
        val username = sharedPref.getString("user_name", "")

        if(username != ""){
            val intent = Intent(this, MainActivity()::class.java)
            startActivity(intent)
        } else {
            val intent = Intent(this, LoginActivity()::class.java)
            startActivity(intent)
        }

        finish()
    }

}