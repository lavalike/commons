package com.wangzhen.commons.sample

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.wangzhen.commons.annotation.DoubleClick
import com.wangzhen.commons.sample.network.NetworkEncryptionActivity
import com.wangzhen.commons.sample.windowinsets.ViewPagerSampleActivity
import com.wangzhen.commons.sample.windowinsets.WindowInsetsActivity
import com.wangzhen.commons.utils.FileUtils
import com.wangzhen.commons.utils.L
import com.wangzhen.commons.utils.T

/**
 * MainActivity
 * Created by wangzhen on 2020/8/19.
 */
class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    @DoubleClick
    fun onClick(view: View) {
        when (view.id) {
            R.id.btn_double_click -> {
                T.show("-> click")
            }
            R.id.btn_toolbar ->
                startActivity(Intent(this, ToolbarSampleActivity::class.java))
            R.id.btn_toolbar_scroll ->
                startActivity(Intent(this, ToolbarScrollActivity::class.java))
            R.id.btn_view_pager ->
                startActivity(Intent(this, ViewPagerSampleActivity::class.java))
            R.id.btn_window_insets ->
                startActivity(Intent(this, WindowInsetsActivity::class.java))
            R.id.btn_read_uri -> {
                val intent = Intent(Intent.ACTION_GET_CONTENT).apply {
                    type = "image/*"
                    addCategory(Intent.CATEGORY_OPENABLE)
                }
                startActivityForResult(intent, 0)
            }
            R.id.btn_network_encryption ->
                startActivity(Intent(this, NetworkEncryptionActivity::class.java))
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && data != null) {
            if (requestCode == 0) {
                val url = FileUtils.getFileFromUri(this, data.data)
                L.e("-> $url")
            }
        }
    }
}