package com.example.myapplication


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import android.content.ContentValues.TAG


private lateinit var auth: FirebaseAuth
private val TAG ="EmailPassword"
class Register : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        auth = Firebase.auth
        val logi = findViewById<EditText>(R.id.ENom)
        val passwor = findViewById<EditText>(R.id.Emdp)
        val btreg = findViewById<Button>(R.id.BtRegist)
        val btverif =findViewById<Button>(R.id.Btverif)
        btreg.setOnClickListener {
            auth.createUserWithEmailAndPassword(logi.text.toString(), passwor.text.toString())
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Log.d(TAG, "signInWithEmail:success")
                       Toast.makeText(baseContext,"Enregistrement ok.",
                        Toast.LENGTH_SHORT).show()


                    } else {
                        Log.w(TAG, "signInWithEmail:failure", task.exception)
                        Toast.makeText(baseContext,"Enregistrement Loupé.",
                            Toast.LENGTH_SHORT).show()

                        // ...
                    }

                    // ...
                }
        }

         fun sendEmailVerification() {
            // Disable button
           btverif.isEnabled = false

            // Send verification email
            // [START send_email_verification]
            val user = auth.currentUser!!
            user.sendEmailVerification()
                .addOnCompleteListener(this) { task ->
                    // [START_EXCLUDE]
                    // Re-enable button
                    btverif.isEnabled = true

                    if (task.isSuccessful) {
                        Toast.makeText(baseContext,
                            "Verification email sent to ${user.email} ",
                            Toast.LENGTH_SHORT).show()
                    } else {
                        Log.e(TAG, "sendEmailVerification", task.exception)
                        Toast.makeText(baseContext,
                            "Failed to send verification email.",
                            Toast.LENGTH_SHORT).show()
                    }
                    // [END_EXCLUDE]
                }
            // [END send_email_verification]
        }
        btverif.setOnClickListener {
            sendEmailVerification()
        }
    }
}