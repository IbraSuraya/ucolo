package com.fikupn.ucolo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView

class SubMenuAdapter(private val subMenuListDefault: ArrayList<SubMenuData>)
    : RecyclerView.Adapter<SubMenuAdapter.SubMenuViewHolder>()
{
    class SubMenuViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView)
    {
        val txtView : TextView = itemView.findViewById(R.id.subTxtMenuItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubMenuViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return SubMenuViewHolder(view)
    }

    override fun onBindViewHolder(holder: SubMenuViewHolder, position: Int) {
        val subMenu = subMenuListDefault[position]
        holder.txtView.text = subMenu.list
    }

    override fun getItemCount(): Int {
        return subMenuListDefault.size
    }
}