package ssccgl.pinnacle.pinnaclepublicationsbookspiracycheck

import android.Manifest
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import ssccgl.pinnacle.pinnaclepublicationsbookspiracycheck.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {
    private var requestCamera: ActivityResultLauncher<String>? = null
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        requestCamera = registerForActivityResult(
            ActivityResultContracts.
            RequestPermission(),){
            if(it){
                val intent = Intent(this,
                    BarcodeScan :: class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this,"Permission Not Granted",
                    Toast.LENGTH_LONG).show()
            }
        }
        binding.btnBc.setOnClickListener(){
            requestCamera?.launch(Manifest.permission.CAMERA)
        }
    }
}

