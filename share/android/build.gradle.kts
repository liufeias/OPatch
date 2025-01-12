plugins {
    alias(libs.plugins.agp.lib)
}
java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17)) // 目标 JVM 版本
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = "17" // 与 Java 保持一致
    }
}
android {
    namespace = "org.lsposed.lspatch.share"

    buildFeatures {
        androidResources = false
        buildConfig = false
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"))
        }
    }
}

dependencies {
    implementation(projects.services.daemonService)
}
