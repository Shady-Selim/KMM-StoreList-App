//
//  BannerApiRow.swift
//  iosApp
//
//  Created by Shady on 14/11/2021.
//  Copyright © 2021 orgName. All rights reserved.
//

import SwiftUI
import shared

struct BannerApiRow: View {
    let bannerData: [BannersList]
    
    var body: some View {
        TabView {
            ForEach(0..<bannerData.count, id: \.self) { i in
                if #available(iOS 15.0, *) {
                    Button(action: {
                        let toast = ToastView(title: bannerData[i].link)
                        toast.show()
                    }) {
                        AsyncImage(url: URL(string: bannerData[i].image)){ image in
                            image.resizable()
                        } placeholder: {
                            Color.gray
                        }
                        .frame(maxWidth: .infinity)
                        .background(Color.white)
                    }
                }
            }
        }.tabViewStyle(PageTabViewStyle()).frame(height: 200)
    }
}
