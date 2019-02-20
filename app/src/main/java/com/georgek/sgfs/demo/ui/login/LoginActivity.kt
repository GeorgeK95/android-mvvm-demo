package com.georgek.sgfs.demo.ui.login

import android.arch.lifecycle.Observer
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import com.georgek.sgfs.demo.R
import com.georgek.sgfs.demo.api.response.oauth.TokenResponse
import com.georgek.sgfs.demo.ui.base.BaseActivity
import com.georgek.sgfs.demo.ui.news.NewsActivity
import com.georgek.sgfs.demo.utils.Constants.Companion.GRANT_TYPE_PASSWORD
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : BaseActivity<LoginViewModel>(LoginViewModel::class.java) {

    companion object {
        var token: TokenResponse? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        initListeners()
    }

    override fun initObservers() {
        viewModel.onTokenReceived.observe(this, Observer { tokenResponse ->
            token = tokenResponse //todo: find a better way to save token

            goToNewsActivity()
        })

        viewModel.onError.observe(this, Observer {
            val errToast = Toast.makeText(this, it, Toast.LENGTH_SHORT)
            errToast.view.setBackgroundColor(Color.RED)
            errToast.show()
        })
    }

    private fun goToNewsActivity() {
        val myIntent = Intent(this, NewsActivity::class.java)
        this.startActivity(myIntent)
    }

    private fun initListeners() {
        button.setOnClickListener {
            viewModel.oauthVM(username_et.text.toString(), password_et.text.toString(), GRANT_TYPE_PASSWORD)
        }
    }
}
