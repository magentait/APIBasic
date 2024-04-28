package org.hse.template.client.rest.model

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDateTime
import org.hse.template.client.rest.model.WeatherResponse

data class ForecastResponse(
    val cod: String,
    val message: Int,
    val cnt: Int,
    val list: List<ForecastDetail>,
    val city: CityInfo
)

data class ForecastDetail(
    val dt: Long,
    @JsonProperty("main") val temperatureDetails: MainForecast,
    val weather: List<WeatherDetail>,
    val clouds: Clouds,
    val wind: Wind,
    val visibility: Int,
    val pop: Double, // Probability of precipitation
    @JsonProperty("dt_txt") val dateTimeText: String,
    val sys: ForecastSys
)

data class MainForecast(
    val temp: Double,
    @JsonProperty("feels_like") val feelsLike: Double,
    val temp_min: Double,
    val temp_max: Double,
    val pressure: Int,
    @JsonProperty("sea_level") val seaLevel: Int,
    @JsonProperty("grnd_level") val groundLevel: Int,
    val humidity: Int,
    @JsonProperty("temp_kf") val tempKf: Double
)

data class ForecastSys(
    @JsonProperty("pod") val partOfDay: String
)

data class CityInfo(
    val id: Int,
    val name: String,
    val coord: Coordinates,
    val country: String,
    val population: Int,
    val timezone: Int,
    val sunrise: Long,
    val sunset: Long
)
