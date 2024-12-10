package com.example.firebase2

import androidx.lifecycle.ViewModel

class PersonViewModel: ViewModel() {

    private val firebaseManager = FirebaseManager()

    fun addPerson(name: String, phone: String) {

        firebaseManager.addPerson(name, phone)

    }
}