import com.vanniktech.maven.publish.SonatypeHost
import com.vanniktech.maven.publish.JavaLibrary
import com.vanniktech.maven.publish.JavadocJar

plugins {
    id("java")
    id("com.vanniktech.maven.publish") version "0.29.0"
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(libs.junit.jupiter.engine)
    testImplementation(libs.kotlin.test.junit5)
    testImplementation(libs.mockito.inline)
    testImplementation(libs.mockito.core)
    testImplementation(libs.mockito.junit.jupiter)
    testRuntimeOnly(libs.junit.platform.launcher)

    implementation(libs.jna)
    implementation(libs.jna.platform)
}

// Apply a specific Java toolchain to ease working on different environments.
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

mavenPublishing {
    // Define configuration for the published artifact
    configure(JavaLibrary(
        // configures the -javadoc artifact, possible values:
        // - `JavadocJar.None()` don't publish this artifact
        // - `JavadocJar.Empty()` publish an emprt jar
        // - `JavadocJar.Javadoc()` to publish standard javadocs
        javadocJar = JavadocJar.Javadoc(),
        // whether to publish a sources jar
        sourcesJar = true,
    ))

    // Define coordinates for the published artifact
    coordinates(
        groupId = "io.github.siropkin",
        artifactId = "keyboard-layout",
        version = "1.0.4"
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

tasks.named<Test>("test") {
    // Use JUnit Platform for unit tests.
    useJUnitPlatform()
}
