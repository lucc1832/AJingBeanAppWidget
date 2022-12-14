package com.lucc.jdlite.dialog

import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import com.lucc.jdlite.MyApplication
import com.lucc.jdlite.R

class NormalInputCKDialog(var mActivity: Activity) : Dialog(mActivity!!) {
    private lateinit var input: EditText
    private lateinit var inputRemark: EditText
    private lateinit var ok: Button
    var onOkClickListener: OnOkClickListener? = null

    init {
        initView()
    }

    fun initView(): NormalInputCKDialog {
        setContentView(R.layout.dialog_layout_style4)
        input = findViewById(R.id.inputColor)
        inputRemark = findViewById(R.id.inputRemark)
        inputRemark.visibility = View.GONE
        ok = findViewById(R.id.ok)
        ok.text = "更新帐号CK"
        val divierId = context.resources.getIdentifier("android:id/titleDivider", null, null)
        val divider = findViewById<View>(divierId)
        divider?.setBackgroundColor(Color.TRANSPARENT)
        window?.setBackgroundDrawableResource(android.R.color.transparent)
        window?.setLayout(context.resources.displayMetrics.widthPixels * 5 / 6, LinearLayout.LayoutParams.WRAP_CONTENT)
        ok.setOnClickListener {
            if (TextUtils.isEmpty(input.text.toString())) {
                Toast.makeText(MyApplication.mInstance, "CK为空", Toast.LENGTH_SHORT).show()
            } else {
                onOkClickListener?.ok(input.text.toString(), inputRemark.text.toString())
            }
            dismiss()
        }
        return this
    }

    fun pop() {
        if (!isShowing) {
            try {
                show()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    override fun show() {
        try {
            super.show()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    interface OnOkClickListener {
        fun ok(ck: String, remark: String)
    }
}