package org.hse.template.client.rest.model

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDateTime

fun transformWeatherResponse(response: WeatherResponse): SimpleWeatherResponse {
    return SimpleWeatherResponse(
        city = response.name,
        temperature = response.main.temp - 273.15, // Преобразование из Кельвинов в Цельсии
        description = response.weather.joinToString(", ") { it.description },
        humidity = response.main.humidity,
        windSpeed = response.wind.speed,
        pressure = response.main.pressure
    )
}

data class SimpleWeatherResponse(
    val city: String,
    val temperature: Double, // Температура в Цельсиях
    val description: String, // Описание погоды
    val humidity: Int, // Влажность в процентах
    val windSpeed: Double, // Скорость ветра в м/с
    val pressure: Int // Давление в hPa
)

data class WeatherResponse(
    val coord: Coordinates,
    val weather: List<WeatherDetail>,
    val base: String,
    val main: MainWeather,
    val visibility: Int,
    val wind: Wind,
    val clouds: Clouds,
    val dt: Long,
    val sys: SystemInfo,
    val id: Int,
    val name: String,
    val cod: Int
)

data class Coordinates(
    val lon: Double,
    val lat: Double
)

data class WeatherDetail(
    val id: Int,
    val main: String,
    val description: String,
    val icon: String
)

data class MainWeather(
    val temp: Double,
    val pressure: Int,
    val humidity: Int,
    val temp_min: Double,
    val temp_max: Double
)

data class Wind(
    val speed: Double,
    val deg: Int
)

data class Clouds(
    val all: Int
)

data class SystemInfo(
    val type: Int,
    val id: Int,
    val message: Double,
    val country: String,
    val sunrise: Long,
    val sunset: Long
)
