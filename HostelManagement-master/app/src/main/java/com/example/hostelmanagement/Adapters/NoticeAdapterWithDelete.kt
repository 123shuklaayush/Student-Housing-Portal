package com.example.hostelmanagement.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.hostelmanagement.R
import com.example.hostelmanagement.database.StudentNotice

class NoticeAdapterWithDelete(private val context: Context, private val listener: NoticeDeleteAdapterClick) : ListAdapter<StudentNotice, NoticeAdapterWithDelete.NoticeViewHolder>(diffCallback) {
    class NoticeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val notcieImageVie: ImageView = itemView.findViewById(R.id.NoticeImageViewWtihDeelte)
        val deleteButton: ImageButton = itemView.findViewById(R.id.delete_button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoticeViewHolder {
        val viewHolder = NoticeViewHolder(LayoutInflater.from(context).inflate(R.layout.notice_item_with_delelte, parent, false))
        viewHolder.deleteButton.setOnClickListener {
            listener.ondelteClick(getItem(viewHolder.adapterPosition))
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: NoticeViewHolder, position: Int) {
        val currentNotice = getItem(position)
        holder.notcieImageVie.setImageBitmap(currentNotice.notice)
    }

    companion object diffCallback : DiffUtil.ItemCallback<StudentNotice>() {
        override fun areItemsTheSame(oldItem: StudentNotice, newItem: StudentNotice): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: StudentNotice, newItem: StudentNotice): Boolean {
            return oldItem._id == newItem._id
        }
    }
}

interface NoticeDeleteAdapterClick {
    fun ondelteClick(notice: StudentNotice)
}