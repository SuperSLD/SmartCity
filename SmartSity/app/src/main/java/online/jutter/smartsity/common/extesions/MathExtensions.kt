package online.jutter.smartsity.common.extesions

import java.math.RoundingMode

const val G = 9.80665

fun Double.toRad() = this * Math.PI / 180

fun Double.toDeg() = this * 180 / Math.PI

fun Double.kgsToN() = this * G

fun Double.round(n: Int) = this.toBigDecimal().setScale(n, RoundingMode.CEILING).toDouble()

fun Double.kgsInS() = this / 60

fun Double.toKg() = this / G