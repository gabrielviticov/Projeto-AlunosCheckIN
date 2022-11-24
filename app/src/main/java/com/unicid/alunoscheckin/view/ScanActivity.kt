package com.unicid.alunoscheckin.view

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.google.zxing.integration.android.IntentIntegrator
import com.unicid.alunoscheckin.R

class ScanActivity : AppCompatActivity() {

    private val obterResultado = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        val intentResult = IntentIntegrator.parseActivityResult(it.resultCode, it.data)
        if (intentResult.contents != null) {
            Toast.makeText(this, intentResult.contents, Toast.LENGTH_LONG).show()
            val navegador = Intent(Intent.ACTION_VIEW)
            navegador.data = Uri.parse(intentResult.contents)
            startActivity(navegador)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scan)

        val integrator: IntentIntegrator = IntentIntegrator(this)
        integrator.setPrompt("Leitura de QRCode")
        obterResultado.launch(integrator.createScanIntent())
    }
}