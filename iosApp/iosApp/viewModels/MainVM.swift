//
//  mainVM.swift
//  iosApp
//
//  Created by Shady on 13/11/2021.
//  Copyright © 2021 orgName. All rights reserved.
//

import Foundation
import shared

class MainVM : ObservableObject {
    @Published var bannerData = MainView.LoadableBanner.loading
    @Published var mainData = MainView.LoadableMainList.loading

    private let repo: MainScreenRepo
    
    init(repo: MainScreenRepo){
        self.repo = repo
        
        let TOKEN: String
        let BASE_URL: String
        var keys: NSDictionary?
        // Create a iOS project root file with name "Keys.plist" and add to it 2 string vars with names "BASE_URL" and "TOKEN"
        if let path = Bundle.main.path(forResource: "Keys", ofType: "plist") {
            keys = NSDictionary(contentsOfFile: path)
        }
        if let dict = keys {
            BASE_URL = dict["BASE_URL"] as! String
            TOKEN = dict["TOKEN"] as! String
            
            self.getBanners(BASE_URL: BASE_URL, TOKEN: TOKEN)
            self.getMainScreenData(BASE_URL: BASE_URL, TOKEN: TOKEN)
        }
    }
    
    func getBanners(BASE_URL: String, TOKEN: String) {
        self.bannerData = .loading
        repo.getBanners(baseUrl: BASE_URL, token: TOKEN, completionHandler:{ bannerData, error in
            if let bannerData = bannerData {
                self.bannerData = .result(bannerData)
            } else {
                self.bannerData = .error(error?.localizedDescription ?? "error")
            }
        })
    }
    
    func getMainScreenData(BASE_URL: String, TOKEN: String) {
        self.mainData = .loading
        repo.getMainScreenData(baseUrl: BASE_URL, token: TOKEN, completionHandler:{ mainData, error in
            if let mainData = mainData {
                self.mainData = .result(mainData)
            } else {
                self.mainData = .error(error?.localizedDescription ?? "error")
            }
        })
    }
}
