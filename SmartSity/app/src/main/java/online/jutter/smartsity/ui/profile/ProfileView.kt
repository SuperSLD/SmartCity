package online.jutter.smartsity.ui.profile

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import online.jutter.smartsity.common.base.BaseView
import online.jutter.smartsity.domain.models.ProfileLocal
import online.jutter.smartsity.ui.map.MapView

interface ProfileView: BaseView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showProfileData(data: ProfileLocal)

}
