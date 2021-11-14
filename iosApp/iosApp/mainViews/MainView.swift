//
//  MainView.swift
//  iosApp
//
//  Created by Shady on 13/11/2021.
//  Copyright © 2021 orgName. All rights reserved.
//

import SwiftUI
import shared

struct MainView: View {
    @ObservedObject private(set) var viewModel: MainVM
    //let greet = Greeting().greeting()
    
    var body: some View {
        ScrollView(.vertical, showsIndicators: false) {
            drawBanner()
            drawMainScreen()
            //Text(/*@START_MENU_TOKEN@*/"Hello, World!"/*@END_MENU_TOKEN@*/)
            //Text(greet)
        }
        
    }
    
    private func drawBanner() -> AnyView {
        switch viewModel.bannerData {
            case .loading:
                return AnyView(Text("Loading Banners...").multilineTextAlignment(.center))
            case .result(let bannerData):
                return AnyView(BannerApiRow(bannerData: bannerData))
            case .error(let description):
                return AnyView(Text(description).multilineTextAlignment(.center))
            }
        }
    
    private func drawMainScreen() -> AnyView {
        switch viewModel.mainData {
            case .loading:
                return AnyView(Text("Loading Data...").multilineTextAlignment(.center))
            case .result(let mainData):
                return AnyView(ForEach(mainData, id: \.self) { data in
                    returnView(mainData: data)
                })
            case .error(let description):
                return AnyView(Text(description).multilineTextAlignment(.center))
            }
        }
    
    private func returnView(mainData: MainScreenList) -> AnyView  {
        switch mainData.data_type {
            case "smart":
                return AnyView(FirstFilterRow(viewData: mainData))
            case "group":
                return AnyView(SectionRow(viewData: mainData))
            case "banner":
                return AnyView(BannerRow(viewData: mainData))
            default:
                return AnyView(Text(""))
        }
    }
}

struct MainView_Previews: PreviewProvider {
    static var previews: some View {
        MainView(viewModel: .init(repo: MainScreenRepo()))
    }
}

extension MainView {
    enum LoadableBanner {
        case loading
        case result([BannersList])
        case error(String)
    }
    enum LoadableMainList {
        case loading
        case result([MainScreenList])
        case error(String)
    }
}
