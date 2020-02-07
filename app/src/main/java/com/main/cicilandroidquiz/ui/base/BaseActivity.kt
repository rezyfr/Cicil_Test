package com.main.cicilandroidquiz.ui.base

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.main.cicilandroidquiz.R
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.progress_dialog.*


abstract class BaseActivity : AppCompatActivity(),
    BaseView {

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    fun setToolBar(toolbar: Toolbar?) {
        if (toolbar != null) {
            setSupportActionBar(toolbar)
            if (supportActionBar != null) {
                if (getToolbarTitle() != null) {
                    supportActionBar!!.title = getToolbarTitle()
                    setDisplayHomeEnabled(true)
                    supportActionBar!!.setDisplayShowTitleEnabled(true)
                    supportActionBar!!.setDisplayHomeAsUpEnabled(true)
                    supportActionBar!!.setDisplayShowHomeEnabled(true)
                    toolbar.setNavigationIcon(getToolbarIcon())
                }
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun getToolbarIcon(): Int {
        return R.drawable.ic_back
    }

    protected abstract fun getToolbarTitle(): String?

    open fun setDisplayHomeEnabled(b: Boolean) {
        if (supportActionBar != null) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(b)
        }
    }

    override fun hideProgress() {
        if (pd_loading != null) {
            if (pd_loading.visibility == View.VISIBLE) {
                pd_loading.visibility = View.GONE
            }
        }
    }

    override fun showProgress() {
        if (pd_loading != null) {
            if (pd_loading.visibility == View.GONE) {
                pd_loading.visibility = View.VISIBLE
            }
        }
    }
}