package com.wangzhen.commons.sample.network.task

import com.wangzhen.network.callback.LoadingCallback
import com.wangzhen.network.task.GetTask

/**
 * TryTask
 * Created by wangzhen on 2020/10/14.
 */
class TryTask(callback: LoadingCallback<*>?) : GetTask(callback) {
    override fun getApi(): String {
        return "/appApi/tryApi"
    }
}