package com.stonesoupprogramming.schedulingtasks

import org.slf4j.LoggerFactory
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

/**
 * Mark this class an injectable component so that the Spring environment will create
 * an instance of this class when it starts up.
 */
@Component
class ScheduleTasks {

    private val logger = LoggerFactory.getLogger(ScheduleTasks::class.java)

    /**
     * This @Schedule annotation run every 5 seconds in this case. It can also
     * take a cron like syntax.
     * See https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/scheduling/support/CronSequenceGenerator.html
     */
    @Scheduled(fixedRate = 5000)
    fun reportTime(){
        logger.info("The time is now ${DateTimeFormatter.ISO_LOCAL_TIME.format(LocalDateTime.now())}")
    }
}

@SpringBootApplication
//Required to tell Spring to run tasks marked with @Scheduled
@EnableScheduling
open class Application

fun main(args : Array<String>){
    SpringApplication.run(Application::class.java)
}
