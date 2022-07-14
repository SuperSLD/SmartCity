package online.jutter.smartsity.ui.view

import android.content.Context
import android.util.AttributeSet
import android.view.KeyEvent
import androidx.appcompat.widget.AppCompatEditText
import com.redmadrobot.inputmask.MaskedTextChangedListener
import com.redmadrobot.inputmask.MaskedTextChangedListener.Companion.installOn
import com.redmadrobot.inputmask.helper.AffinityCalculationStrategy


class SupportInput: AppCompatEditText {
    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)
    constructor(context: Context, attributeSet: AttributeSet, defUtils: Int) : super(
        context,
        attributeSet,
        defUtils
    )

    private var mValidListener: ((Boolean, String, String)->Unit)? = null

    fun onValidChange(validListener: (Boolean, String, String)->Unit) {
        this.mValidListener = validListener
    }

    fun setMask(mask: String, useHint: Boolean) {

        val listener: MaskedTextChangedListener = installOn(
            this,
            mask,
            emptyList(), AffinityCalculationStrategy.PREFIX,
            object : MaskedTextChangedListener.ValueListener {
                override fun onTextChanged(maskFilled: Boolean, extractedValue: String, formattedValue: String) {
                    mValidListener?.let { v -> v(maskFilled, extractedValue, formattedValue) }
                }

            }
        )

        if (useHint) this.hint = listener.placeholder()
    }

    override fun onKeyPreIme(keyCode: Int, event: KeyEvent?): Boolean {
        if(keyCode == KeyEvent.KEYCODE_BACK || keyCode == KeyEvent.KEYCODE_HOME) {
            clearFocus()
        }
        return super.onKeyPreIme(keyCode, event)
    }
}