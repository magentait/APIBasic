package org.hse.template.controller

import org.hse.template.api.WeatherApi
import org.hse.template.client.rest.api.WeatherClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.PathVariable

@RestController
class WeatherController(private val weatherClient: WeatherClient) : WeatherApi {

    @GetMapping("/weather/{city}")
    override fun getCurrentWeather(@PathVariable city: String) = weatherClient.getCurrentWeather(city)

    @GetMapping("/forecast/{city}")
    override fun getForecast(@PathVariable city: String) = weatherClient.getForecast(city)
}