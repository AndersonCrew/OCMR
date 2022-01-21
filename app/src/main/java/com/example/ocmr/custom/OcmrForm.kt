package com.example.ocmr.custom

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.example.ocmr.R
import com.example.ocmr.databinding.OcmrFormLayoutBinding
import java.util.jar.Attributes

class OcmrForm  @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private var colorTitle: Int?= null
    private var colorForm: Int?= null
    private var colorHintForm: Int?= null
    private var colorTextForm: Int?= null
    private var binding: OcmrFormLayoutBinding?= null
    private var strTitle: String?= ""
    private var strHint: String?= ""

    init {
        binding = OcmrFormLayoutBinding.inflate(LayoutInflater.from(context), this, true)

        val ta = context.obtainStyledAttributes(attrs, R.styleable.OcmrForm)
        try {
            colorTitle = ta.getColor(R.styleable.OcmrForm_colorTitle, ContextCompat.getColor(context, R.color.white))
            colorForm = ta.getInt(R.styleable.OcmrForm_colorForm, 0)
            colorHintForm = ta.getColor(R.styleable.OcmrForm_colorHint, ContextCompat.getColor(context, R.color.white))
            colorTextForm = ta.getColor(R.styleable.OcmrForm_colorTextForm, ContextCompat.getColor(context, R.color.white))

            strTitle = ta.getString(R.styleable.OcmrForm_strTitle)
            strHint = ta.getString(R.styleable.OcmrForm_strHint)
        } finally {
            ta.recycle()
        }

        binding?.etForm?.apply {
            hint = strHint
            setHintTextColor(colorHintForm!!)
            setTextColor(colorTextForm!!)

            when(colorForm) {
                0 -> setBackgroundResource(R.drawable.bg_edt_white)
                else -> setBackgroundResource(R.drawable.bg_edt_gray)
            }

            addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                }

                override fun afterTextChanged(p0: Editable?) {
                    binding?.etForm?.setBackgroundResource(if(colorForm == 0) R.drawable.bg_edt_white else R.drawable.bg_edt_gray)
                    binding?.tvError?.apply {
                        visibility = View.GONE
                        text = ""
                    }
                }

            })

        }

        binding?.tvTitle?.apply {
            text = strTitle
            setTextColor(colorTitle!!)
        }

    }

    fun onError(strError: String) {
        binding?.etForm?.setBackgroundResource(R.drawable.bg_edt_red)
        binding?.tvError?.apply {
            visibility = View.VISIBLE
            text = strError
        }
    }

    fun getTextForm(): String {
        return binding?.etForm?.text.toString()
    }

}