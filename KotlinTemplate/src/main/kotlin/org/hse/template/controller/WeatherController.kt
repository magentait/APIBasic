package org.hse.template.controller

import org.hse.template.api.WeatherApi
import org.hse.template.client.rest.api.WeatherClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.PathVariable
import org.hse.template.client.rest.model.WeatherResponse
import org.hse.template.client.rest.model.SimpleForecastResponse
import org.hse.template.client.rest.model.transformForecastResponse
import org.hse.template.client.rest.model.SimpleWeatherResponse
import org.hse.template.client.rest.model.transformWeatherResponse

@RestController
class WeatherController(private val weatherClient: WeatherClient) : WeatherApi {

    /*
    @GetMapping("/weather/{city}")
    override fun getCurrentWeather(@PathVariable city: String) = weatherClient.getCurrentWeather(city)
    */

    @GetMapping("/weather/{city}")
    override fun getSimpleWeather(@PathVariable city: String): SimpleWeatherResponse {
        val weatherResponse = weatherClient.getCurrentWeather(city)
        return transformWeatherResponse(weatherResponse)
    }

    /*
    @GetMapping("/forecast/{city}")
    override fun getForecast(@PathVariable city: String) = weatherClient.getForecast(city)
     */

    @GetMapping("/forecast/{city}")
    override fun getSimpleForecast(@PathVariable city: String): List<SimpleForecastResponse> {
        val forecastResponse = weatherClient.getForecast(city)
        return transformForecastResponse(forecastResponse.list)
    }
}