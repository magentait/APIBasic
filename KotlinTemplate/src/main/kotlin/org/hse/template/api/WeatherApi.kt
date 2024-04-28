package org.hse.template.api

import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.PathVariable
import org.hse.template.client.rest.model.WeatherResponse
import org.hse.template.client.rest.model.ForecastResponse
import org.hse.template.client.rest.model.SimpleForecastResponse
import org.hse.template.client.rest.model.SimpleWeatherResponse

interface WeatherApi {

    @Tag(name = "Get current weather")
    @ApiResponses(
        ApiResponse(description = "Returns current weather for the city", responseCode = "200")
    )
    fun getSimpleWeather(@PathVariable city: String): SimpleWeatherResponse

    @Tag(name = "Get 5-day forecast")
    @ApiResponses(
        ApiResponse(description = "Returns 5-day weather forecast for the city", responseCode = "200")
    )
    fun getSimpleForecast(@PathVariable city: String): List<SimpleForecastResponse>
}
