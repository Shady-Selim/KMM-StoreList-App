//
//  SectionRow.swift
//  iosApp
//
//  Created by Shady on 14/11/2021.
//  Copyright © 2021 orgName. All rights reserved.
//

import SwiftUI
import shared

struct SectionRow: View {
    let viewData : MainScreenList
    var items: [GridItem] {
      Array(repeating: .init(.flexible()), count: Int(viewData.row_count))
    }
    
    var body: some View {
        VStack(alignment: .leading){
            Text(viewData.title).font(.system(size: 30)).fontWeight(.bold).padding(.leading, 30)
            ScrollView(.vertical, showsIndicators: false) {
                LazyVGrid(columns: items, spacing: 10){
                    ForEach(0..<viewData.data.count) { i in
                        VStack(spacing: 5.0){
                            if #available(iOS 15.0, *) {
                                AsyncImage(url: URL(string: viewData.data[i].image), transaction: .init(animation: .spring(response: 1.6))){ phase in
                                    switch phase {
                                    case .empty:
                                        ProgressView()
                                            .progressViewStyle(.circular)
                                    case .success(let image):
                                        image
                                            .resizable()
                                            .aspectRatio(contentMode: .fill)
                                    case .failure:
                                        Text(viewData.data[i].name ?? "")
                                            .fontWeight(.bold)
                                    @unknown default:
                                        Text(viewData.data[i].name ?? "")
                                            .fontWeight(.bold)
                                    }
                                }
                                .frame(width: 70, height: 100)
                            }
                        }
                    }
                }
            }.frame( maxWidth: .infinity)
        }
    }
}
