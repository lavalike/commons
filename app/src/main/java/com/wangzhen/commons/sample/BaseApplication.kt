package com.wangzhen.commons.sample

import android.app.Application
import com.wangzhen.network.Network
import com.wangzhen.network.config.NetConfig

/**
 * BaseApplication
 * Created by wangzhen on 2020/9/15.
 */
class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Network.init(
            NetConfig.Builder()
                .baseUrl("http://39.108.54.21:14001")
                .build()
        )
    }
}