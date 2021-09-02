import com.google.protobuf.gradle.generateProtoTasks
import com.google.protobuf.gradle.proto
import com.google.protobuf.gradle.protobuf
import com.google.protobuf.gradle.protoc

plugins {
    // Apply the application plugin to add support for building a CLI application in Java.
    application
    id("com.google.protobuf") version "0.8.13"
    id("idea")
}

var protobufVersion = "3.12.4"

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {
    // This dependency is used by the application.
    implementation("com.google.guava:guava:30.0-jre")
    implementation("com.google.protobuf:protobuf-java:${protobufVersion}")
    implementation("com.google.protobuf:protobuf-java-util:${protobufVersion}")

    // Use JUnit Jupiter API for testing.
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.1")

    // Use JUnit Jupiter Engine for testing.
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:3.9.1"
    }

    generateProtoTasks {
        all().forEach { task ->
            task.group = "proto"

            // Protobuf Gradle Plugin does not properly clean its output
            // See https://github.com/google/protobuf-gradle-plugin/issues/464
            task.doFirst {
                delete(task.outputs)
            }
        }
    }
}

sourceSets {
    main {
        proto {
            srcDir("src/test/resources/proto")
        }
    }
}

application {
    // Define the main class for the application.
    mainClass.set("java.tests.App")
}

tasks.test {
    // Use junit platform for unit tests.
    useJUnitPlatform()
}
