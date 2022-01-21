package com.example.ocmr.custom

import android.content.Context
import android.util.AttributeSet
import android.view.ContentInfo
import android.view.LayoutInflater
import android.widget.CompoundButton
import android.widget.RadioGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.example.ocmr.R
import com.example.ocmr.databinding.LayoutLineTermCheckBinding

class LineTermCheck @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAtt: Int = 0
) :
    ConstraintLayout(context, attributeSet, defStyleAtt) {

    private var binding: LayoutLineTermCheckBinding?= null
    private var title: String?= ""

        init {
            binding = LayoutLineTermCheckBinding.inflate(LayoutInflater.from(context), this, true)

            val ta = context.obtainStyledAttributes(attributeSet, R.styleable.LineTermCheck)
            try {
                title = ta.getString(R.styleable.LineTermCheck_title)
            } finally {
                ta.recycle()
            }

            binding?.tvContent?.text = title

            binding?.ckCheck?.setOnCheckedChangeListener { p0, p1 ->
                if (binding?.ckCheck?.isChecked == true) {
                    binding?.tvContent?.setTextColor(
                        ContextCompat.getColor(
                            context,
                            R.color.colorMainBlack
                        )
                    )
                } else {
                    binding?.tvContent?.setTextColor(
                        ContextCompat.getColor(
                            context,
                            R.color.colorGray3
                        )
                    )
                }
            }
        }
}