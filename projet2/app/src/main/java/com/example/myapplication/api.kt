package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.json.responseJson
import com.github.kittinunf.result.Result
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject

class api : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_api)
        val etIdLivre = findViewById<EditText>(R.id.etLivre)
        val btGetLivre = findViewById<Button>(R.id.btsend)
        val tvAuteur = findViewById<TextView>(R.id.tvAuteur)
        val tvTitre = findViewById<TextView>(R.id.tvTitre)
        val btgetreturn = findViewById<Button>(R.id.btreturn)
        /* fun run(url: String): String {
            val request: Request = Request.Builder()
                    .url(url)
                    .build()
            client.newCall(request).execute().use { response -> return response.body!!.string() }*/

        btGetLivre.setOnClickListener {
            val IdLivre = etIdLivre.text.toString()
            val url = "https://module5.etienne-vaytilingom.re/livres/$IdLivre"
            /* Fuel.get(url).responseString { request, response, result ->
                val data = result.get()
                val objjson = JSONObject(data)
                println("objjson")
                println(objjson["auteur"])
            }*/

            Fuel.get(url).responseJson() { request, response, result ->
                val data = result.get().obj()
                tvAuteur.text = data["auteur"] as CharSequence?
                tvTitre.text = data["titre"] as CharSequence?
            }
        }
        btgetreturn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
