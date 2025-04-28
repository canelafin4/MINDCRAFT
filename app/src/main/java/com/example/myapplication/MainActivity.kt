package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.myapplication.database.AppDatabase
import com.example.myapplication.model.Anotacao
import com.example.myapplication.network.SupabaseClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var database: AppDatabase
    private lateinit var supabaseClient: SupabaseClient

    private val supabaseUrl = "https://agjeikdhffjwltycoxtc.supabase.co"
    private val supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImFnamVpa2RoZmZqd2x0eWNveHRjIiwicm9sZSI6ImFub24iLCJpYXQiOjE3NDU3OTU5MzMsImV4cCI6MjA2MTM3MTkzM30.AnTCjA2hQKIgyj_96JT3U6m6vDPaqcmgoH9mbJ_fe0o"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supabaseClient = SupabaseClient(supabaseUrl, supabaseKey)

        lifecycleScope.launch {
            try {
                val anotacoes = supabaseClient.getAnotacoes()
                Log.d("SupabaseTest", "Anotações recebidas: $anotacoes")
            } catch (e: Exception) {
                Log.e("SupabaseTest", "Erro ao buscar anotações", e)
            }
        }
    }


}
