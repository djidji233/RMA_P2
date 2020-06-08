package rs.raf.projekat2.Djordje_Zivanovic_RN9818.presentation.view.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import kotlinx.android.synthetic.main.activity_login.*
import rs.raf.projekat2.Djordje_Zivanovic_RN9818.R

class LoginActivity : AppCompatActivity(R.layout.activity_login) {
    private val PASSWORD = "1234"
    private val USER_DATA = "UserData"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btn_login.setOnClickListener {
            if (user_name.text.isBlank() || user_password.text.isBlank()){
                Toast.makeText(applicationContext,"Please fill in all the fields!",Toast.LENGTH_SHORT).show()
            } else if (!user_password.text.toString().equals(PASSWORD)){
                Toast.makeText(applicationContext,"Wrong password!",Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this,MainActivity::class.java)
                getSharedPreferences(USER_DATA, Context.MODE_PRIVATE).edit{
                    putString("user_name", user_name.text.toString())
                    putString("user_password", user_password.text.toString())
                    apply()
                }
                startActivity(intent)
                finish()
            }
        }
    }
}