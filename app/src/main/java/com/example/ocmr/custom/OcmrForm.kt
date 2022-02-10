package com.example.ocmr.custom

import android.content.Context
import android.content.res.ColorStateList
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.view.marginTop
import com.example.ocmr.R
import com.example.ocmr.databinding.OcmrFormLayoutBinding
import com.example.ocmr.utils.dp
import com.example.ocmr.utils.px
import com.example.ocmr.utils.toPx
import java.util.jar.Attributes

class OcmrForm  @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private var typeForm: Int = 0
    private var binding: OcmrFormLayoutBinding?= null
    private var strTitle: String?= ""
    private var strHint: String?= ""

    init {
        binding = OcmrFormLayoutBinding.inflate(LayoutInflater.from(context), this, true)

        val ta = context.obtainStyledAttributes(attrs, R.styleable.OcmrForm)
        try {
            typeForm = ta.getInt(R.styleable.OcmrForm_typeForm, 0)
            strTitle = ta.getString(R.styleable.OcmrForm_strTitle)
            strHint = ta.getString(R.styleable.OcmrForm_strHint)
        } finally {
            ta.recycle()
        }

        binding?.etForm?.apply {
            hint = strHint
            setHintTextColor(if(typeForm == 0) ContextCompat.getColor(context, R.color.colorWhite60) else ContextCompat.getColor(context, R.color.colorGray2))
            setTextColor(if(typeForm == 0) ContextCompat.getColor(context, R.color.white) else ContextCompat.getColor(context, R.color.colorMainBlack))
            setBackgroundResource(if(typeForm == 0) R.drawable.bg_edt_white_50 else R.drawable.bg_edt_gray)


            addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                }

                override fun afterTextChanged(p0: Editable?) {

                    binding?.tvError?.apply {
                        visibility = View.GONE
                        text = ""
                    }
                }

            })

            onFocusChangeListener = OnFocusChangeListener { _, isFocus ->
                if(isFocus) {
                    binding?.etForm?.setBackgroundResource(if(typeForm == 0) R.drawable.bg_edt_white else R.drawable.bg_edt_main_black)
                } else {
                    binding?.etForm?.setBackgroundResource(if(typeForm == 0) R.drawable.bg_edt_white_50 else R.drawable.bg_edt_gray)
                }
            }

        }

        binding?.tvTitle?.apply {
            visibility = if (strTitle.isNullOrEmpty()) View.GONE else View.VISIBLE
            text = strTitle
            setTextColor(if(typeForm == 0) ContextCompat.getColor(context, R.color.white) else ContextCompat.getColor(context, R.color.colorMainBlack))
        }

        if(typeForm == 1 && !strTitle.isNullOrEmpty()) {
            val params: LayoutParams = binding?.etForm?.layoutParams as LayoutParams
            params.setMargins(0, 16.px, 0, 0)
            binding?.etForm?.layoutParams = params

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