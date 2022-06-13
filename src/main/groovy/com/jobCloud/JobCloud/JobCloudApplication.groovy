package com.jobCloud.JobCloud

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
@RestController
class JobCloudApplication {

	static void main(String[] args) {
		SpringApplication.run(JobCloudApplication, args)
	}

}
