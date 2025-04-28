package com.example.myapplication.network

import android.util.Log
import com.example.myapplication.model.Anotacao
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class SupabaseClient(private val baseUrl: String, private val apiKey: String) {

    private val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json { ignoreUnknownKeys = true })
        }
    }

    suspend fun insertAnotacao(anotacao: Anotacao) {
        client.post("$baseUrl/rest/v1/anotacoes") {
            headers {
                append(HttpHeaders.Authorization, "Bearer $apiKey")
                append(HttpHeaders.ContentType, "application/json")
            }
            setBody(
                listOf(
                    mapOf(
                        "tituloAnotacao" to anotacao.tituloAnotacao,
                        "texto" to anotacao.texto
                    )
                )
            )
        }
    }

    suspend fun getAnotacoes(): List<Anotacao> {
        Log.d("SupabaseTest", "URL: $baseUrl/rest/v1/anotacoes")
        Log.d("SupabaseTest", "API KEY: $apiKey")

        return client.get("$baseUrl/rest/v1/anotacoes") {
            headers {
                set(HttpHeaders.Authorization, "Bearer $apiKey")
                set(HttpHeaders.Accept, "application/json")
            }
            parameter("select", "*")
        }.body()
    }


}
