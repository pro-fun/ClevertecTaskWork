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


extra["springCloudVersion"] = "2023.0.0"

dependencies {
    implementation(project(":api"))
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.cloud:spring-cloud-starter-openfeign")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.mapstruct:mapstruct:1.5.5.Final")
    implementation("org.mapstruct:mapstruct-processor:1.5.5.Final")
    implementation("org.projectlombok:lombok-mapstruct-binding:0.1.0")
    compileOnly ("org.projectlombok:lombok")
    compileOnly("org.mapstruct:mapstruct-processor:1.5.5.Final")
    runtimeOnly("io.micrometer:micrometer-registry-prometheus")
    annotationProcessor ("org.projectlombok:lombok")
    annotationProcessor("org.mapstruct:mapstruct-processor:1.5.5.Final")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.springframework.security:spring-security-test")
    testImplementation ("org.testcontainers:testcontainers:1.18.1")
    testImplementation ("org.testcontainers:junit-jupiter:1.18.1")
    testImplementation ("org.testcontainers:mongodb:1.18.1")
}
dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
    }
}


tasks.test {
    useJUnitPlatform()
}

