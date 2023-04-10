package com.enigmacamp.simpleviewmodel.presentation.camera.ui

import android.Manifest
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.enigmacamp.simpleviewmodel.databinding.ActivityCameraBinding

class CameraActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCameraBinding
    private val CAMERA_REQUEST_CODE = 1888

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCameraBinding.inflate(layoutInflater)
        setContentView(binding.root)

        askPermission()

        binding.apply {
            buttonCamera.setOnClickListener {
                val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                someActivityResultLauncher.launch(intent)
            }

            buttonBrowse.setOnClickListener {
                val intent = Intent(Intent.ACTION_PICK)
                intent.type = "image/*"
                someActivityResultLauncher.launch(intent)
            }
        }
    }

    private val someActivityResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result: ActivityResult? ->
        if(result?.resultCode == RESULT_OK){
            val data: Intent? = result.data
            if (data != null){
                if (data.data != null){
                    val resultURI = data.data
                    binding.imageView.setImageURI(resultURI)
                }else if (data.extras != null && data.extras!!.containsKey("data")){
                    val photo: Bitmap = data.extras!!.get("data") as Bitmap
                    binding.imageView.setImageBitmap(photo)
                    saveImageToGallery(photo, applicationContext)
                }
            }
        }
    }

    private fun askPermission() {
        val cameraPermission = Manifest.permission.CAMERA
        val storagePermission = Manifest.permission.WRITE_EXTERNAL_STORAGE
        val permissions = arrayOf(cameraPermission, storagePermission)
        val grantResults = IntArray(permissions.size)

        for (i in permissions.indices) {
            grantResults[i] = ContextCompat.checkSelfPermission(this, permissions[i])
            if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, arrayOf(permissions[i]), CAMERA_REQUEST_CODE)
                return
            }
        }

        // Lakukan tindakan yang memerlukan izin CAMERA dan WRITE_EXTERNAL_STORAGE
        Log.i("PERMISSION", "CLOSE")
    }

    private fun saveImageToGallery(bitmap: Bitmap, context: Context) {
        val savedImageURL = MediaStore.Images.Media.insertImage(
            context.contentResolver,
            bitmap,
            "Title",
            "Description"
        )

        // Notify the gallery app of the new image
        val intent = Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE)
        intent.data = Uri.parse(savedImageURL)
        context.sendBroadcast(intent)

        Toast.makeText(context, "Image saved to gallery", Toast.LENGTH_SHORT).show()
    }
}