package com.wangzhen.commons.sample.windowinsets

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import com.wangzhen.commons.sample.BaseActivity
import com.wangzhen.commons.sample.R
import com.wangzhen.commons.fitwindows.FitType
import com.wangzhen.commons.fitwindows.FitWindowsFrameLayout

/**
 * WindowInsetsActivity
 * Created by wangzhen on 2020/9/11.
 */
class WindowInsetsActivity : BaseActivity() {
    private var container: FitWindowsFrameLayout? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_window_insets)
        container = findViewById(R.id.container)
    }

    @RequiresApi(Build.VERSION_CODES.KITKAT_WATCH)
    fun onClick(view: View) {
        when (view.id) {
            R.id.btn_top -> {
                container?.setFitType(FitType.TOP)
            }
            R.id.btn_bottom -> {
                container?.setFitType(FitType.BOTTOM)
            }
            R.id.btn_both -> {
                container?.setFitType(FitType.BOTH)
            }
        }
    }
}