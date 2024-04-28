package org.hse.template.api

import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.PathVariable
import org.hse.template.client.rest.model.WeatherResponse
import org.hse.template.client.rest.model.ForecastResponse

interface WeatherApi {

    @Tag(name = "Get current weather")
    @ApiResponses(
        ApiResponse(description = "Returns current weather for the city", responseCode = "200")
    )
    fun getCurrentWeather(@PathVariable city: String): WeatherResponse

    @Tag(name = "Get 5-day forecast")
    @ApiResponses(
        ApiResponse(description = "Returns 5-day weather forecast for the city", responseCode = "200")
    )
    fun getForecast(@PathVariable city: String): ForecastResponse
}
