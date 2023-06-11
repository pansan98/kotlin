package com.example.pr3_listview2

import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.appcompat.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.widget.Toast
import java.lang.IllegalStateException

class OrderConfirmDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = activity?.let {
            val builder = AlertDialog.Builder(it)
            // ダイアログのタイトルを設定
            builder.setTitle(R.string.dialog_title)
            // ダイアログのメッセージを設定
            builder.setMessage(R.string.dialog_msg)
            // ボタンの設定
            builder.setPositiveButton(R.string.dialog_btn_ok, DialogButtonClickListener())
            builder.setNegativeButton(R.string.dialog_btn_ng, DialogButtonClickListener())
            builder.setNeutralButton(R.string.dialog_btn_nu, DialogButtonClickListener())
            // ダイアログオブジェクトの生成
            builder.create()
        }
        return dialog ?: throw IllegalStateException("アクティビティが存在しません。")
    }

    private inner class DialogButtonClickListener: DialogInterface.OnClickListener {
        override fun onClick(dialog: DialogInterface, which: Int) {
            var msg:String = ""
            when(which) {
                DialogInterface.BUTTON_POSITIVE -> {
                    msg = getString(R.string.dialog_ok_toast)
                }
                DialogInterface.BUTTON_NEGATIVE -> {
                    msg = getString(R.string.dialog_ng_toast)
                }
                DialogInterface.BUTTON_NEUTRAL -> {
                    msg = getString(R.string.dialog_nu_toast)
                }
            }

            Toast.makeText(activity, msg, Toast.LENGTH_LONG).show()
        }
    }
}