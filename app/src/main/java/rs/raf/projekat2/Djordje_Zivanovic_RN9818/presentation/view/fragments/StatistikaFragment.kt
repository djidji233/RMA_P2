package rs.raf.projekat2.Djordje_Zivanovic_RN9818.presentation.view.fragments

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_stat.*
import rs.raf.projekat2.Djordje_Zivanovic_RN9818.R
import rs.raf.projekat2.Djordje_Zivanovic_RN9818.presentation.view.activities.LoginActivity

class StatistikaFragment : Fragment(R.layout.fragment_stat){

    private lateinit var shared_pref : SharedPreferences
    private val USER_DATA = "UserData"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        shared_pref = this.requireActivity().getSharedPreferences(USER_DATA, Context.MODE_PRIVATE)
        initListener()
    }

    private fun initListener(){
        btnLogout.setOnClickListener{
            val intent = Intent(this.context, LoginActivity::class.java)
            shared_pref.edit().clear().apply()
            startActivity(intent)
            this.requireActivity().finish()
        }
    }
}