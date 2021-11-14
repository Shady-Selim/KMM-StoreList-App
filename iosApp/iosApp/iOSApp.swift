import SwiftUI
import shared

@main
struct iOSApp: App {
	var body: some Scene {
		WindowGroup {
            MainView(viewModel: .init(repo: MainScreenRepo()))
		}
	}
}
