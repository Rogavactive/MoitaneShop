package com.example.moitaneshop.presentation.searchview

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import com.example.moitaneshop.R
import com.example.moitaneshop.databinding.ViewSearchBinding

internal class SearchView @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyle: Int = 0)
    : LinearLayout(context, attrs, defStyle) {

    private var binding = ViewSearchBinding.inflate(LayoutInflater.from(context), this)
    private var textChangeListener : SearchViewTextChangeListener? = null

    init {
        setBackgroundResource(R.drawable.bg_view_search)
        binding.editText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (s?.length ?: 0 == 0) {
                    binding.icClose.visibility = View.GONE
                } else {
                    binding.icClose.visibility = View.VISIBLE
                }
                textChangeListener?.onTextChange(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) { }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) { }
        })
        binding.icClose.setOnClickListener {
            binding.editText.setText("")
        }
    }

    fun setOnTextChangeListener(listener: SearchViewTextChangeListener) {
        this.textChangeListener = listener
    }

}