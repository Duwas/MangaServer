package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.demo")
public class MangaApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(MangaApplication.class, args);
    }

    @Override
    public void run(String... args) {

        String port = System.getProperty("server.port", "8082");

        System.out.println("\n========================================");
        System.out.println("🚀 COMIC BACKEND STARTED SUCCESSFULLY");
        System.out.println("========================================");

        System.out.println("📚 Swagger UI:");
        System.out.println("http://localhost:" + port + "/swagger-ui/index.html");

        System.out.println("\n📄 API Docs:");
        System.out.println("http://localhost:" + port + "/v3/api-docs");

        System.out.println("\n========================================\n");
    }
}