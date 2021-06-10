package edu.co.icesi.semana3kotlina

import android.content.Intent
import android.content.Intent.ACTION_CALL
import android.net.Uri
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactView(itemView: View) : RecyclerView.ViewHolder(itemView) {


    //State
    var contact: Contact? = null
    var listener: OnContactItemAction? = null

    var contactname: TextView = itemView.findViewById(R.id.contactname)
    var contactphone: TextView = itemView.findViewById(R.id.contactphone)
    var contactdelete: Button = itemView.findViewById(R.id.contactdelete)
    var contactcall: Button = itemView.findViewById(R.id.contactcall)

    init {
        contactdelete.setOnClickListener(::deleteContact)
        contactcall.setOnClickListener(::callContact)
    }

    fun deleteContact(view: View?) {
        contact?.let { listener?.onDeleteContact(it) }
    }

    fun callContact(view: View?) {
        val i = Intent(ACTION_CALL)
        i.setData(Uri.parse("tel:${contact?.telefono}"))
        itemView.context.startActivity(i)
    }

    interface OnContactItemAction {
        fun onDeleteContact(contact: Contact)
    }

}

