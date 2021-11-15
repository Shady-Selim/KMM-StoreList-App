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
    private let timer = Timer.publish(every: 3, on: .main, in: .common).autoconnect()
    @State private var currentImgIndex = 0
    
    var body: some View {
        TabView(selection: $currentImgIndex) {
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
            .clipShape(RoundedRectangle(cornerRadius: 20))
            .padding(16)
            .onReceive(timer, perform: { _ in
                withAnimation {
                    currentImgIndex = currentImgIndex < bannerData.count ? currentImgIndex + 1 : 0
                }
            })
    }
}
