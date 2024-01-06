package com.audronf.revivify.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.audronf.revivify.databinding.ViewExtraTimezoneBinding
import com.audronf.revivify.model.Timezone
import com.audronf.revivify.ui.components.BindingViewHolder

class TimezonesAdapter :
    ListAdapter<Timezone, BindingViewHolder<Timezone, ViewExtraTimezoneBinding>>(
        diffCallback
    ) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BindingViewHolder<Timezone, ViewExtraTimezoneBinding> {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ViewExtraTimezoneBinding.inflate(inflater)
        return TimezonesViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: BindingViewHolder<Timezone, ViewExtraTimezoneBinding>,
        position: Int
    ) {
        holder.bind(getItem(position))
    }

    inner class TimezonesViewHolder(
        binding: ViewExtraTimezoneBinding,
    ) : BindingViewHolder<Timezone, ViewExtraTimezoneBinding>(binding) {

        override fun bind(item: Timezone) {
            with(binding) {
                labelTextView.text = item.label
                timeTextClock.timeZone = item.timezone
            }
        }
    }

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<Timezone>() {

            override fun areItemsTheSame(oldItem: Timezone, newItem: Timezone): Boolean {
                return oldItem.timezone == newItem.timezone
            }

            override fun areContentsTheSame(oldItem: Timezone, newItem: Timezone): Boolean {
                return oldItem == newItem
            }
        }
    }
}
