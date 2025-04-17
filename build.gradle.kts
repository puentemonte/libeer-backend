plugins {
	java
	id("org.springframework.boot") version "3.4.4"
	id("io.spring.dependency-management") version "1.1.7"
	id("io.freefair.lombok") version "8.12.1"
}

group = "dev.libeer"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")


	compileOnly("org.projectlombok:lombok:1.18.36")
	annotationProcessor("org.projectlombok:lombok:1.18.36")
	testCompileOnly("org.projectlombok:lombok:1.18.36")
	testAnnotationProcessor("org.projectlombok:lombok:1.18.36")

	implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310")

	implementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
	testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
	testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")

	implementation("commons-io:commons-io:2.11.0")

}

tasks.withType<Test> {
	useJUnitPlatform()
}
