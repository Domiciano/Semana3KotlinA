package edu.co.icesi.semana3kotlina

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

class ContactsAdapter : RecyclerView.Adapter<ContactView>(), ContactView.OnContactItemAction {

    private val contacts = ArrayList<Contact>()

    /*
    init {
        contacts.add(Contact(UUID.randomUUID().toString(),"Alfa", "111111111" ) )
        contacts.add(Contact(UUID.randomUUID().toString(),"Beta", "222222222" ) )
        contacts.add(Contact(UUID.randomUUID().toString(),"Gamma", "333333333" ) )
    }
    */

    fun addContact(contact: Contact) {
        contacts.add(contact)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactView {
        val inflater = LayoutInflater.from(parent.context)
        val row = inflater.inflate(R.layout.contactrow, parent, false)
        val contactview = ContactView(row)
        contactview.listener = this
        return contactview
    }

    override fun onBindViewHolder(holder: ContactView, position: Int) {
        holder.contact = contacts[position]
        holder.contactname.text = contacts[position].nombre
        holder.contactphone.text = contacts[position].telefono
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    override fun onDeleteContact(contact: Contact) {
        contacts.remove(contact)
        notifyDataSetChanged()
    }


}