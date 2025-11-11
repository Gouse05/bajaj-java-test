package com.bajaj.test;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private final WebClient webClient = WebClient.builder().build();

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) {

        System.out.println("✅ Starting Bajaj Test...");

        String generateWebhookUrl = "https://bfhldevapigw.healthrx.co.in/hiring/generateWebhook/JAVA";

        Map<String, Object> requestBody = Map.of(
                "name", "Sheik Gouse Pasha",
                "regNo", "PES1UG22CS556",
                "email", "gouse05.x@gmail.com"
        );

        Map<String, Object> webhookResponse = webClient.post()
                .uri(generateWebhookUrl)
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(Map.class)
                .block();

        System.out.println("✅ Webhook Response: " + webhookResponse);

        String webhookUrl = (String) webhookResponse.get("webhook");
        String accessToken = (String) webhookResponse.get("accessToken");

        String finalQuery = "SELECT e1.emp_id, e1.first_name, e1.last_name, d.department_name, " +
                "COUNT(e2.emp_id) AS younger_employees_count FROM employee e1 " +
                "JOIN department d ON e1.department = d.department_id " +
                "LEFT JOIN employee e2 ON e2.department = e1.department AND e2.dob > e1.dob " +
                "GROUP BY e1.emp_id, e1.first_name, e1.last_name, d.department_name " +
                "ORDER BY e1.emp_id DESC;";

        Map<String, Object> finalPayload = Map.of("finalQuery", finalQuery);

        String result = webClient.post()
                .uri(webhookUrl)
                .header("Authorization", accessToken)
                .bodyValue(finalPayload)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        System.out.println("✅ Final Response: " + result);
    }
}
