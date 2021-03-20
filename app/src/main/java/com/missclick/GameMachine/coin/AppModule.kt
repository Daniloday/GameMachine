package com.missclick.GameMachine.coin

import com.missclick.GameMachine.ui.firstRound.FirstRoundViewModel
import com.missclick.GameMachine.ui.gallery.GalleryViewModel
import com.missclick.GameMachine.ui.home.HomeViewModel
import com.missclick.GameMachine.ui.lastRound.LastRoundViewModel
import com.missclick.GameMachine.ui.secondRound.SecondRoundViewModel
import com.missclick.GameMachine.ui.slideshow.SlideshowViewModel
import com.missclick.GameMachine.ui.splash.SplashViewModel
import com.missclick.GameMachine.ui.thirdRound.ThirdRoundViewModel
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