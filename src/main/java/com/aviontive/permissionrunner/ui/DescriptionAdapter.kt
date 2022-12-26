package com.aviontive.permissionrunner.ui


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.aviontive.permissionrunner.R
import com.aviontive.permissionrunner.core.Permission
import org.w3c.dom.Text


class DescriptionAdapter(items:ArrayList<Permission>): RecyclerView.Adapter<DescriptionAdapter.DescriptionHolder>() {
    val feed = items
    class DescriptionHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val view = itemView
        val title = view.findViewById<TextView>(R.id.permissionTitle)
        val description = view.findViewById<TextView>(R.id.permissionDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DescriptionHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem: View = layoutInflater.inflate(R.layout.list_description_item,parent, false)
        return DescriptionHolder(listItem)
    }

    override fun onBindViewHolder(holder: DescriptionHolder, position: Int) {
        val currentItem = feed.get(position)
        holder.title.text = currentItem.name
        holder.description.text = currentItem.description
    }

    override fun getItemCount(): Int {
        return feed.size
    }
}