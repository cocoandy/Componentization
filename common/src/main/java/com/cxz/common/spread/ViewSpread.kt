package com.cxz.common.spread


import androidx.appcompat.widget.DialogTitle
import androidx.appcompat.widget.Toolbar
import com.cxz.common.base.BaseActivity


fun Toolbar.init(
    activity: BaseActivity,
    title: String = "",
    icon: Int = 0,
    menu: Int = 0,
    bock: Toolbar .() -> Unit
) {
    init(activity, title, icon, menu)
    bock()
}


fun Toolbar.init(
    activity: BaseActivity?,
    title: String? = null,
    icon: Int = 0,
    menu: Int = 0
) {
    activity?.setBarHeightAndPadding(this)
    if (icon != 0) {
        setNavigationIcon(icon)
        setNavigationOnClickListener {
            activity?.finish()
        }
    }

    if (menu != 0)
        inflateMenu(menu)


    if (title != null)
        setTitle(title)
}