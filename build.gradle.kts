import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("java")
    id("org.jetbrains.kotlin.jvm") version "1.9.10"
    id("org.jetbrains.intellij") version "1.16.0"
}

group = "dev.ja.test"
version = "1.0-SNAPSHOT"

allprojects {
    repositories {
        mavenCentral()
    }

    apply {
        plugin("org.jetbrains.kotlin.jvm")
        plugin("org.jetbrains.intellij")
    }

    intellij {
        type.set("IC")
        version.set("2023.1.5")

        // don't instrument
        instrumentCode.set(false)
    }

    tasks {
        withType<JavaCompile> {
            sourceCompatibility = "17"
            targetCompatibility = "17"
        }

        withType<KotlinCompile> {
            kotlinOptions.jvmTarget = "17"
        }

        patchPluginXml {
            sinceBuild.set("231")
            untilBuild.set("241.*")
        }

        runIde {
            onlyIf { project == rootProject }
        }
    }
}

project(":") {
    dependencies {
        implementation(project(":plugin-java"))
    }
}

project(":plugin-java") {
    intellij {
        plugins.set(listOf("java", "com.intellij.properties"))
    }
}