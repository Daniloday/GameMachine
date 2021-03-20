package com.missclick.slotmachine.coin

import com.missclick.slotmachine.ui.firstRound.FirstRoundViewModel
import com.missclick.slotmachine.ui.gallery.GalleryViewModel
import com.missclick.slotmachine.ui.home.HomeViewModel
import com.missclick.slotmachine.ui.lastRound.LastRoundViewModel
import com.missclick.slotmachine.ui.secondRound.SecondRoundViewModel
import com.missclick.slotmachine.ui.slideshow.SlideshowViewModel
import com.missclick.slotmachine.ui.splash.SplashViewModel
import com.missclick.slotmachine.ui.thirdRound.ThirdRoundViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel {
        FirstRoundViewModel()
    }
    viewModel {
        GalleryViewModel()
    }
    viewModel {
        SecondRoundViewModel()
    }
    viewModel {
        ThirdRoundViewModel()
    }
    viewModel {
       SplashViewModel()
    }
    viewModel {
        HomeViewModel()
    }
    viewModel {
        SlideshowViewModel()
    }
    viewModel {
        LastRoundViewModel(get())
    }

}