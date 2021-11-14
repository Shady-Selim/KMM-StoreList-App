//
//  FirstFilterRow.swift
//  iosApp
//
//  Created by Shady on 13/11/2021.
//  Copyright © 2021 orgName. All rights reserved.
//

import SwiftUI
import shared

struct FirstFilterRow: View {
    let viewData : MainScreenList
    
    var body: some View {
        HStack(spacing: 10.0) {
            ForEach(0..<Int(viewData.row_count)) { i in
                VStack(spacing: 5.0){
                    if #available(iOS 15.0, *) {
                        AsyncImage(url: URL(string: viewData.data[i].image)){ image in
                            image.resizable()
                        } placeholder: {
                            Color.gray
                        }
                        .frame(width: 30, height: 30)
                        .padding(16.0)
                        .background(Color.white)
                        .clipShape(RoundedRectangle(cornerRadius: 90))
                        .shadow(radius: 40)
                    }
                    Text(viewData.data[i].name ?? "")
                        .font(.system(size: 12))
                }.padding(.vertical, 15).padding(.horizontal, 10)
            }
        }.frame( maxWidth: .infinity).background(Color(UIColor(red: 250/255, green: 250/255, blue: 248/255, alpha: 1)))
    }
}
