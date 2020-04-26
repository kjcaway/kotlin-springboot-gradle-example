import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.run.BootRun

plugins {
	id("org.springframework.boot") version "2.2.4.RELEASE"
	id("io.spring.dependency-management") version "1.0.9.RELEASE"
	kotlin("jvm") version "1.3.61" // 또는 id("org.jetbrains.kotlin.jvm") version "1.3.61"
	kotlin("plugin.spring") version "1.3.61" // 또는 id("org.jetbrains.kotlin.plugin.spring") version "1.3.61"
	kotlin("plugin.jpa") version "1.3.61" // 또는 id("org.jetbrains.kotlin.plugin.jpa") version "1.3.61"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-jdbc")
	implementation("org.springframework.boot:spring-boot-starter-data-redis")

	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

	implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:1.3.2")

	implementation("mysql:mysql-connector-java")

	testImplementation("org.springframework.boot:spring-boot-starter-test") {
		exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
	}

}

val appName = "demo"
val appVer = "0.1.1"

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "1.8"
	}
}

tasks.getByName<BootRun>("bootRun") {
	main = "com.example.demo.DemoApplicationKt"
}

tasks.bootJar {
	manifest {
		attributes("Multi-Release" to true)
		attributes("Title" to "demo")
		attributes("Main-class" to "com.example.demo.DemoApplication")
	}

	archiveBaseName.set(appName)
	archiveVersion.set(appVer)

	if (project.hasProperty("archiveName")) {
		archiveFileName.set(project.properties["archiveName"] as String)
	}
}
