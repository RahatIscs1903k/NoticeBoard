package com.example.noticeboardapp.dialogHelper

import android.app.AlertDialog
import com.example.noticeboardapp.MainActivity
import com.example.noticeboardapp.R
import com.example.noticeboardapp.accounthelper.AccountHelper
import com.example.noticeboardapp.databinding.SignDialogBinding

class DialogHelper(act:MainActivity) {
    private val act = act
    private val accHelper = AccountHelper(act)

    fun createSignDialog(index: Int) {
        val builder = AlertDialog.Builder(act)
        val rootDialogElement = SignDialogBinding.inflate(act.layoutInflater)
        val view = rootDialogElement.root
        builder.setView(view)

        if (index == DialogConst.SIGN_UP_STATE) {
            rootDialogElement.tvSignTitle.text = act.resources.getString(R.string.sign_up_action)
            rootDialogElement.btSignUpIn.text = act.resources.getString(R.string.sign_up_action)
        } else {
            rootDialogElement.tvSignTitle.text = act.resources.getString(R.string.sign_in_action)
            rootDialogElement.tvSignTitle.text = act.resources.getString(R.string.sign_in_action)
        }
        val dialog = builder.create()
        rootDialogElement.btSignUpIn.setOnClickListener {
            dialog.dismiss()
            if (index == DialogConst.SIGN_UP_STATE){

                accHelper.signUpWithEmail(rootDialogElement.edSignEmail.text.toString(),
                rootDialogElement.edSignPassword.text.toString())
            }else{

            }
        }


        dialog.show()
    }
}