package org.hse.template.client.rest.api

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.hse.template.client.rest.model.WeatherResponse
import org.hse.template.client.rest.model.ForecastResponse


@FeignClient(name = "openWeatherMap", url = "https://api.openweathermap.org/data/2.5")
interface WeatherClient {

    @GetMapping("/weather?q={city}&appid={apiKey}")
    fun getCurrentWeather(@PathVariable city: String, @PathVariable apiKey: String = "ecb789e2ffeacbe622efd1c35fb29686"): WeatherResponse

    @GetMapping("/forecast?q={city}&appid={apiKey}")
    fun getForecast(@PathVariable city: String, @PathVariable apiKey: String = "ecb789e2ffeacbe622efd1c35fb29686"): ForecastResponse
}