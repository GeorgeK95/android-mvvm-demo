package com.georgek.sgfs.demo.ui.news

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.widget.Toast
import com.georgek.sgfs.demo.R
import com.georgek.sgfs.demo.ui.base.BaseActivity

class NewsActivity : BaseActivity<NewsViewModel>(NewsViewModel::class.java) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        viewModel.loadNews()
    }

    override fun initObservers() {
        viewModel.onNewsLoaded.observe(this, Observer { news ->
            //do smth with received data
            Toast.makeText(this, String.format("Received %d news.", news!!.size), Toast.LENGTH_SHORT).show()
        })
    }
}
