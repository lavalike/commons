package com.wangzhen.commons.toolbar

import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.annotation.CallSuper
import androidx.appcompat.app.AppCompatActivity
import com.wangzhen.commons.R
import com.wangzhen.commons.toolbar.impl.Toolbar

/**
 * toolbar activity
 * Created by wangzhen on 2020/8/28.
 */
open class ToolbarActivity : AppCompatActivity() {

    @CallSuper
    override fun onPostCreate(savedInstanceState: Bundle?) {
        (window.decorView as ViewGroup).getChildAt(0).fitsSystemWindows = false
        findViewById<View>(R.id.action_bar_root)?.fitsSystemWindows = false
        super.onPostCreate(savedInstanceState)
    }

    override fun setContentView(layoutResID: Int) {
        setContentView(layoutInflater.inflate(layoutResID, null))
    }

    override fun setContentView(view: View) {
        createToolbar()?.let { bar ->
            super.setContentView(LinearLayout(this).apply {
                orientation = LinearLayout.VERTICAL

                addView(bar.createView().apply {
                    fitsSystemWindows = true
                }, ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT))

                addView(view, ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT))
            })
        } ?: super.setContentView(view)
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
            supportActionBar?.hide()
        }
    }

    open fun createToolbar(): Toolbar? {
        return null
    }

    /**
     * get status bar height
     *
     * @return status bar height
     */
    private fun statusBarHeight(): Int {
        var result = 0
        resources.getIdentifier("status_bar_height", "dimen", "android").also { resourceId ->
            if (resourceId > 0) {
                result = resources.getDimensionPixelSize(resourceId)
            }
        }
        return result
    }
}