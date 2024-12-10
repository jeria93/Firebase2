package com.example.firebase2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.firebase2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


//    Skriv på papper sen, visualisera hur allt är uppdelat
//    klass för klass etc hur allt knyts ihop

    lateinit var viewModel: PersonViewModel


    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        viewModel = ViewModelProvider(this)[PersonViewModel::class.java]


        binding.btnAdd.setOnClickListener {
                addPerson()
        }
    }

//    Reference to viewmodel and call the addPerson method
    fun addPerson() {

//        Checks if there is text in the edittext, checks if they are empty
        if (binding.etName.text.isNotBlank() && binding.etPhone.text.isNotBlank()) {
            val name = binding.etName.text.toString()
            val phone = binding.etPhone.text.toString()
            viewModel.addPerson(name, phone)
        }

    }

}

//Firebase is a cloud based database platform
//Firestore is a NoSQL database, we store data in key value pairs, like JSON

//Create a project in Android Studio
//Navigate to Tools -> Firebase
// Create a firebase project in firebase website

//Use Firestore Database to create a database
//start in test mode




//Creating data in Firestore
//Start collection
//add documents

/*
1 Firebase class
1 viewmodel
repository pattern?
 */


/*
addPerson(), explained:
1. Is created in FirebaseManager
2. Make a reference to it in viewModel and call it in the same method name
3. create method sameName in MainActivity that is used for button


 */