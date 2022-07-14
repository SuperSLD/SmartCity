package online.jutter.smartsity.common.base

import com.arellomobile.mvp.MvpView

interface BaseView: MvpView {
    fun showErrorLoading()
    fun toggleLoading(show: Boolean)
}