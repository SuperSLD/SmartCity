package online.jutter.smartsity.ui.auth.profile_filling

import android.os.Bundle
import android.view.View
import androidx.core.widget.addTextChangedListener
import by.kirich1409.viewbindingdelegate.viewBinding
import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.view_pony_input.view.*
import online.jutter.smartsity.R
import online.jutter.smartsity.databinding.FragmentProfileFillingBinding
import online.jutter.supersld.common.base.BaseFragment

class ProfileFillingFragment : BaseFragment(R.layout.fragment_profile_filling), ProfileFillingView {

    @InjectPresenter
    lateinit var presenter: ProfileFillingPresenter

    private val binding: FragmentProfileFillingBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUi()
        initListeners()
    }

    private fun initUi() {
        with(binding) {
            vToolbar.setTitle("заполнение личных данных")

            inFirstName.setHint("Имя")
            inLastName.setHint("Фамилия")
            inCity.setHint("Город")
        }
    }

    private fun initListeners() {
        with(binding) {
            inFirstName.etInput.addTextChangedListener { checkFieldsFillingStatus() }
            inLastName.etInput.addTextChangedListener { checkFieldsFillingStatus() }
            inCity.etInput.addTextChangedListener { checkFieldsFillingStatus() }

            btnSave.setOnClickListener {
                presenter.send(inFirstName.etInput.text.toString(), inLastName.etInput.text.toString(), inCity.etInput.text.toString())
            }
        }
    }

    private fun checkFieldsFillingStatus(){
        with(binding) {
            btnSave.isEnabled = !inFirstName.etInput.text.isNullOrEmpty()
                && !inLastName.etInput.text.isNullOrEmpty()
                && !inCity.etInput.text.isNullOrEmpty()
        }
    }

    override fun onBackPressed() {
    }

}
