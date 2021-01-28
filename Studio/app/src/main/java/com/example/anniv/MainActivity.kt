package com.example.anniv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn_login = findViewById<Button>(R.id.Bt_sha)
        val tv_res = findViewById<TextView>(R.id.Tv_result)
        val et_nom = findViewById<EditText>(R.id.ETNom)
        val et_mdp = findViewById<EditText>(R.id.ETmdp)
        btn_login.setOnClickListener{
             if (et_nom.text.isEmpty() && et_mdp.text.isEmpty()  ) {
                 tv_res.text = "Veuillez remplir les champs"
             }
            else if (et_nom.text.isEmpty()) {
                 tv_res.text = "Décliner votre identité"
             }
             else if ( et_mdp.text.isEmpty()){
                 tv_res.text = "Donnez le mot de passe"
             }
            else {
                     tv_res.text = "Vous faites partie de la famille"
                 }
            }

        }
    }
