package com.example.anniv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.anniv.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var compt  = 0
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.BtSha.setOnClickListener {
            if (binding.ETNom.text.isEmpty() && binding.ETmdp.text.isEmpty()) {
                binding.TvResult.text = "Veuillez remplir les champs"
            } else if (binding.ETNom.text.isEmpty()) {
                binding.TvResult.text = "Décliner votre identité"
            } else if (binding.ETmdp.text.isEmpty()) {
                binding.TvResult.text = "Donnez le mot de passe"
            } else {
                binding.TvResult.text = "Vous faites partie de la famille"
            }
        }
        
        binding.BtRegister.setOnClickListener {
        compt++
        binding.compteur.text= compt.toString()


        }

    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("compteur", this.compt)
        outState.putString("txt_etlogin",this.binding.ETNom.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        this.compt= savedInstanceState.getInt("compteur")
        val txtetLogin = savedInstanceState.getString("txt_etlogin") + (1..100).random()
        this.binding.ETNom.setText(txtetLogin)
    }

}


/*val builder = AlertDialog.Builder(this)
builder.setTitle("Androidly Alert")
builder.setMessage("We have a message")
//builder.setPositiveButton("OK", DialogInterface.OnClickListener(function = x))
builder.show()
val text = "Hello toast!"
val duration = Toast.LENGTH_SHORT

val  toast = Toast.makeText(applicationContext, text, duration)
toast.show()*/