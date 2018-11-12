package com.manuflowers.lyfecycleawarecomponents

import android.arch.lifecycle.ViewModel
import android.support.annotation.Nullable


class ChronometerViewModel : ViewModel() {

    var startTime: Long? = null
        get() = field

    fun setStartTime(startTime: Long) {
        this.startTime = startTime
    }
}