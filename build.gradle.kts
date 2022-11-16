plugins {
    id("java")
}

group = "org.igor-rodin"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.0")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.14.0")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}