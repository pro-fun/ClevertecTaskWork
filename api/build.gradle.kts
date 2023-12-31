import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    id("java")
    id("org.springframework.boot")
    id("io.spring.dependency-management")
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}



dependencies {

    implementation("org.springframework.boot:spring-boot-starter:3.2.1")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation ("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-security")
    compileOnly("org.projectlombok:lombok:1.18.30")
    annotationProcessor("org.projectlombok:lombok:1.18.30")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")

}


tasks.test {
    useJUnitPlatform()
}
