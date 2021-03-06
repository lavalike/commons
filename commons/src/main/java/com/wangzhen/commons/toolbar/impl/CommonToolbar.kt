package com.wangzhen.commons.toolbar.impl

import android.app.Activity
import android.view.View
import android.widget.TextView
import com.wangzhen.commons.R

/**
 * CommonToolbar
 * Created by wangzhen on 2020/8/28.
 */
class CommonToolbar(activity: Activity, private val title: String) : Toolbar(activity) {
    override fun layoutRes(): Int {
        return R.layout.toolbar_common_layout
    }

    override fun onViewCreated(view: View) {
        view.apply {
            findViewById<View>(R.id.back).setOnClickListener {
                activity.finish()
            }
            findViewById<TextView>(R.id.title).text = title
        }
    }

}