package online.jutter.smartsity.ui.view

import android.content.Context
import android.graphics.Color
import android.text.method.DigitsKeyListener
import android.util.AttributeSet
import android.view.Gravity
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.RelativeLayout
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.view_pony_input.view.*
import online.jutter.smartsity.R
import online.jutter.smartsity.common.extesions.getColor
import online.jutter.smartsity.common.extesions.hide
import online.jutter.smartsity.common.extesions.limitLength
import online.jutter.smartsity.common.extesions.show

class PonyInputView : RelativeLayout {
    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)
    constructor(context: Context, attributeSet: AttributeSet, defUtils: Int) : super(
        context,
        attributeSet,
        defUtils
    )

    private var mEnabled = true
    private var mEndAction : Action? = null
    private var mImeAction : ImeAction? = null

    init {
        View.inflate(context, R.layout.view_pony_input, this)
        this.setOnClickListener {
            etInput.requestFocus()
        }
        etInput.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH
                || actionId == EditorInfo.IME_ACTION_DONE
                || event?.action == KeyEvent.ACTION_DOWN
                || actionId == EditorInfo.IME_ACTION_GO
                || actionId == EditorInfo.IME_ACTION_NEXT
                || actionId == EditorInfo.IME_ACTION_SEND
                || actionId == EditorInfo.IME_ACTION_PREVIOUS
                && event?.keyCode == KeyEvent.KEYCODE_ENTER) {

                mImeAction?.action?.let { action ->  action(etInput.text.toString())}
            }
            // Return true if you have consumed the action, else false.
            return@setOnEditorActionListener false
        }
    }

    fun disable() {
        mEnabled = false
        etInput.isEnabled = false
        cvContainer.setCardBackgroundColor(Color.parseColor("#F5F5F5"))
    }

    fun enable() {
        mEnabled = true
        etInput.isEnabled = true
        cvContainer.setCardBackgroundColor(getColor(R.color.colorTextWhite))
    }

    /**
     * Замена плэйсхолдера у текстового поля.
     * @param hint id строки в ресурсах.
     */
    fun setHint(hint: Int) {
        setHint(context.getString(hint))
    }

    /**
     * Замена плэйсхолдера у текстового поля.
     * @param hint строка.
     */
    fun setHint(hint: String) {
        etInput.hint = hint
    }

    /**
     * Отображение маски перед текстовым полем.
     * @param mask id строки в ресурсах.
     */
    fun setPrefix(mask: Int?) {
        setPrefix(if (mask != null) context.getString(mask) else null)
    }

    /**
     * Отображение маски перед текстовым полем.
     * @param mask строка с маской.
     */
    fun setPrefix(mask: String?) {
        if (mask != null) {
            tvMask.show()
            tvMask.text = mask
            maskDivider.show()
        } else {
            tvMask.hide()
            maskDivider.hide()
        }
    }

    /**
     * Установка слушателя на нажатие кнопки в конце поля.
     * @param endAction информация о том что должео произойти.
     */
    fun addEndAction(endAction: Action?) {
        if (endAction != null) {
            if (endAction.iconId == null) {
                tvAction.show()
                tvAction.text = context.getString(endAction.textId!!)
                tvAction.setOnClickListener {
                    if (mEnabled) endAction.action(etInput.text.toString())
                }
            } else {
                ivAction.show()
                ivAction.setImageDrawable(ContextCompat.getDrawable(context, endAction.iconId))
                ivAction.setOnClickListener {
                    if (mEnabled) endAction.action(etInput.text.toString())
                }
            }
            actionDivider.show()
        } else {
            actionDivider.hide()
            tvAction.hide()
            ivAction.hide()
        }
    }

    fun setImeAction(action: ImeAction, oneLine: Boolean = true) {
        etInput.imeOptions = action.actionId
        if (oneLine) etInput.maxLines = 1
        mImeAction = action
    }

    /**
     * Установка слушателя на нажатие серой кнопки.
     * @param startAction информация о том что должео произойти.
     */
    fun addStartAction(startAction: Action?) {
        if (startAction?.iconId != null) {
            ivStartAction.show()
            ivStartAction.setImageDrawable(ContextCompat.getDrawable(context, startAction.iconId))
            ivStartAction.setOnClickListener {
                if (mEnabled) startAction.action(etInput.text.toString())
            }
        } else {
            ivStartAction.hide()
        }
    }

    fun showErrorText(text: Int?) {
        showErrorText(if (text != null) context.getString(text) else null)
    }

    fun showErrorText(text: String?) {
        if (text == null) {
            tvError.hide()
        } else {
            tvError.show()
            tvError.text = text
        }
    }

    fun showTitle(title: Int?) {
        showTitle(if (title != null) context.getString(title) else null)
    }

    fun secondVariant() {
        cvContainer.setCardBackgroundColor(getColor(R.color.colorBackgroundDark))
    }

    fun setActionDone(action: Int) {
        etInput.imeOptions = action
    }

    /**
     * Чтобы нельзя было тыкать на ентер необходимо
     * добавить тип для инпута.
     */
    fun setMaxLines(lines: Int) {
        etInput.maxLines = lines
    }

    fun setMinLines(lines: Int) {
        etInput.gravity = Gravity.TOP
        etInput.minLines = lines
    }

    fun setInputType(type: Int) {
        etInput.inputType = type
    }

    fun setDigits(digits: String) {
        etInput.keyListener = DigitsKeyListener.getInstance(digits)
    }

    fun setMaxLen(len: Int) {
        etInput.limitLength(len)
    }

    fun setText(text: String) {
        etInput.setText(text)
    }

    fun showTitle(title: String?) {
        if (title == null) {
            tvTitle.hide()
        } else {
            tvTitle.show()
            tvTitle.text = title
        }
    }

    fun onValidChange(validListener: (Boolean, String, String)->Unit) {
        etInput.onValidChange(validListener)
    }

    fun setTextMask(mask: String, useHint: Boolean = true) {
        etInput.setMask(mask, useHint)
    }

    class Action(
        val textId: Int? = null,
        val iconId: Int? = null,
        val action: (String)->Unit
    )

    class ImeAction(
        val actionId: Int,
        val action: (String)->Unit
    )
}