package online.jutter.smartsity.ui.map

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import by.kirich1409.viewbindingdelegate.viewBinding
import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.fragment_map.*
import online.jutter.smartsity.R
import online.jutter.smartsity.common.extesions.hide
import online.jutter.smartsity.common.extesions.round
import online.jutter.smartsity.common.extesions.show
import online.jutter.smartsity.databinding.FragmentMapBinding
import online.jutter.supersld.common.base.BaseFragment
import online.jutter.supersld.extensions.addSystemTopAndBottomPadding

class MapFragment: BaseFragment(R.layout.fragment_map), MapView {

    @InjectPresenter
    lateinit var presenter: MapPresenter

    private val binding: FragmentMapBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mapMenuContainer.addSystemTopAndBottomPadding()

        showMapLoading(true)
        showNavData(false)
        initMapView()
    }

    private fun initMapView() {
        with(binding.mapView) {
            setColorData(getMapColorData())
            onLoad {
                showMapLoading(false)
            }
            onLoadError(this@MapFragment::showMapLoadingError)
            onNavigationLoad { navData ->
                if (navData != null) {
                    showNavLoading(false)
                    binding.tvNavKm.text = getString(R.string.roadmap_nav_km, (navData.sumDist/1000).round(1).toString())
                    binding.tvNavMin.text = getString(R.string.roadmap_nav_min, navData.sumMin.toInt().toString())
                } else {
                    showNavData(false)
                }
            }
            onFloorCountUpdate {
                binding.floorsView?.setFloors(it)
                binding.floorsView?.onFloorChanged { f -> binding.mapView.setCurrentFloor(f) }
            }
            setActivity(requireActivity())
            init()
        }
    }

    override fun onPause() {
        super.onPause()
        binding.mapView.onPause()
    }

    override fun onResume() {
        super.onResume()
        binding.mapView.onResume()
    }

    private fun showNavData(show: Boolean) {
        if (show) {
            binding.navDataContainer.visibility = View.VISIBLE
        } else {
            binding.navDataContainer.visibility = View.GONE
        }
    }

    private fun showNavLoading(show: Boolean) {
        if (show) {
            binding.pbNavLoading.visibility = View.VISIBLE
            binding.navResult.visibility = View.GONE
        } else {
            binding.pbNavLoading.visibility = View.GONE
            binding. navResult.visibility = View.VISIBLE
        }
    }

    private fun showMapLoading(show: Boolean) {
        if (show) {
            binding.mapContainer.hide()
            binding.pbLoading.show()
            binding.tvStatus.show()
        } else {
            binding.mapContainer.show()
            binding.pbLoading.hide()
            binding.tvStatus.hide()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun showMapLoadingError() {
        binding.pbLoading.hide()
        binding.tvStatus.show()
        binding.tvStatus.text = "Ошибка загрузки\nперезагрузите приложение"
    }

    override fun onBackPressed() {
        presenter.back()
    }
}