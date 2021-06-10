package edu.co.icesi.semana3kotlina

import android.Manifest
import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var contactsViewList: RecyclerView
    private lateinit var layoutManager: LinearLayoutManager
    private lateinit var adapter: ContactsAdapter

    private lateinit var nombreET: EditText
    private lateinit var telefonoET: EditText
    private lateinit var agregarBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        ActivityCompat.requestPermissions(this, arrayOf(
            Manifest.permission.CALL_PHONE
        ), 0)

        contactsViewList = findViewById(R.id.contactsViewList)
        nombreET = findViewById(R.id.nombreET)
        telefonoET = findViewById(R.id.telefonoET)
        agregarBtn = findViewById(R.id.agregarBtn)

        layoutManager = LinearLayoutManager(this)
        adapter = ContactsAdapter()

        contactsViewList.layoutManager = layoutManager
        contactsViewList.adapter = adapter
        contactsViewList.setHasFixedSize(true)

        agregarBtn.setOnClickListener(::agregarContacto)

    }

    fun agregarContacto(view: View?) {
        adapter.addContact(Contact(UUID.randomUUID().toString(), nombreET.text.toString(), telefonoET.text.toString()))
    }
}