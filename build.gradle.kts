import com.vanniktech.maven.publish.SonatypeHost

plugins {
    alias(libs.plugins.jvm)
    `java-library`
    id("com.vanniktech.maven.publish") version "0.29.0"
}

mavenPublishing {
    // Define coordinates for the published artifact
    coordinates(
        groupId = "io.github.siropkin",
        artifactId = "keyboard-layout",
        version = "1.0.2"
    )

    // Configure POM metadata for the published artifact
    pom {
        name.set("Keyboard Layout")
        description.set("Cross-platform library for detecting keyboard layouts and languages on Windows, macOS, and Linux.")
        inceptionYear.set("2024")
        url.set("https://github.com/siropkin/keyboard-layout")

        licenses {
            license {
                name.set("Apache-2.0")
                url.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
            }
        }

        // Specify developer information
        developers {
            developer {
                id.set("siropkin")
                name.set("Ivan Seredkin")
                email.set("ivan.seredkin@gmail.com")
            }
        }

        // Specify SCM information
        scm {
            url.set("https://github.com/siropkin/keyboard-layout")
        }
    }

    // Configure publishing to Maven Central
    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)

    // Enable GPG signing for all publications
    signAllPublications()
}

repositories {
    mavenCentral()
}

dependencies {
    // Use the JUnit 5 integration.
    testImplementation(libs.junit.jupiter.engine)

    // Use the Kotlin JUnit 5 integration.
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")

    // Add Mockito dependency
    testImplementation("org.mockito:mockito-inline:5.2.0")
    testImplementation("org.mockito:mockito-core:5.14.1")
    testImplementation("org.mockito:mockito-junit-jupiter:5.12.0")

    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    implementation("net.java.dev.jna:jna:5.14.0")
    implementation("net.java.dev.jna:jna-platform:5.14.0")
}

// Apply a specific Java toolchain to ease working on different environments.
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

tasks.named<Test>("test") {
    // Use JUnit Platform for unit tests.
    useJUnitPlatform()
}
