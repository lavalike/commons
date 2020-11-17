package com.wangzhen.commons.sample.network.task

import com.wangzhen.network.callback.LoadingCallback
import com.wangzhen.network.task.PostFormTask

/**
 * LoginTask
 * Created by wangzhen on 2020/10/14.
 */
class LoginTask(callback: LoadingCallback<*>?) : PostFormTask(callback) {
    override fun getApi(): String {
        return "/idm/login"
    }
}