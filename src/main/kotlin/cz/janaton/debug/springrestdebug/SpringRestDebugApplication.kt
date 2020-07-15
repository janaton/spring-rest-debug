package cz.janaton.debug.springrestdebug

import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
@RestController
class SpringRestDebugApplication {
	companion object {
		private val log = LoggerFactory.getLogger(SpringRestDebugApplication::class.java)
	}

	@GetMapping("/counter/seconds/{seconds}")
	fun count(@PathVariable seconds: Int): String {
		log.info("")
		for (i in 1..seconds) {
			Thread.sleep(1000)
			log.info("Counting {}/{}", i, seconds)
		}

		return "Counting to ${seconds} finished"
	}
}

fun main(args: Array<String>) {
	runApplication<SpringRestDebugApplication>(*args)
}
