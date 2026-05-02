// swift-tools-version: 5.9

import PackageDescription

let package = Package(
    name: "super_native_extensions",
    platforms: [
        .macOS("10.15")
    ],
    products: [
        .library(name: "super-native-extensions", targets: ["super_native_extensions"])
    ],
    targets: [
        .binaryTarget(name: "SuperNativeExtensionsRust", path: "SuperNativeExtensionsRust.xcframework"),
        .target(
            name: "super_native_extensions",
            dependencies: ["SuperNativeExtensionsRust"],
            publicHeadersPath: ".",
            linkerSettings: [
                .linkedFramework("Carbon")
            ]
        )
    ]
)
