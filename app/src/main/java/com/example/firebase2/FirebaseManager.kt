package com.example.firebase2

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


//Firebase logic
class FirebaseManager {
    private val db = Firebase.firestore

    private val _persons = MutableLiveData(mutableListOf<Person>())
    val persons: LiveData<MutableList<Person>> get() = _persons

    //    Method for adding Persons
    fun addPerson(name: String, phone: String) {
        val person = Person(name, phone)

        db.collection("persons").add(person).addOnSuccessListener {
            Log.i("!!!", "Person added")
        }.addOnFailureListener {
            Log.e("!!!", "Person not added")
        }
    }

    //    Method for adding Persons style 2
    fun addPerson2(person: Person) {

        db.collection("persons").add(person).addOnSuccessListener {
            Log.i("!!!", "Person added")
        }.addOnFailureListener {
            Log.e("!!!", "Person not added")
        }

    }
}








//When we want to store data use LiveData
//"collectionPath "persons" " is just a string, what the collections name is
//.addOnSuccessListener
//
//