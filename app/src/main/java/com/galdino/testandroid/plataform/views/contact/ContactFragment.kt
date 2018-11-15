package com.galdino.testandroid.plataform.views.contact

import com.galdino.testandroid.R
import com.galdino.testandroid.plataform.views.base.BaseFragment
import org.koin.android.ext.android.inject

class ContactFragment: BaseFragment(), ContactContract.View {
    private val mPresenter: ContactContract.Presenter by inject()
    companion object {

        @JvmStatic
        fun newInstance() =
                ContactFragment()
    }

    override fun getLayoutResource(): Int {
        return R.layout.fragment_contact
    }

    override fun onInitView() {
        mPresenter.attach(this)
    }
}
