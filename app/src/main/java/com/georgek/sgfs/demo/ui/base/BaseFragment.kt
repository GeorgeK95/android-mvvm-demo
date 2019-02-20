package com.georgek.sgfs.demo.ui.base

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.georgek.sgfs.demo.R
import dagger.android.support.DaggerFragment
import javax.inject.Inject

abstract class BaseFragment<T : BaseViewModel>(private val clazz: Class<T>) : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    protected lateinit var viewModel: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activity?.let {
            viewModel = ViewModelProviders.of(it, viewModelFactory).get(clazz)
        }
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(getFragmentLayout(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.title = getTitle()

        initFragment()
        initListeners()
        initObservers()
    }

    protected abstract fun getFragmentLayout(): Int

    protected open fun initFragment() {}

    protected open fun initListeners() {}

    protected open fun initObservers() {

    }

    protected open fun getTitle(): String {
        return getString(R.string.app_name)
    }

}