

// задача 1
fun main() {
    println(agoToText(30))
    println(agoToText(65))
    println(agoToText(300))
    println(agoToText(1260))
    println(agoToText(3601))
    println(agoToText(3600 * 3))
    println(agoToText(3600 * 11))
    println(agoToText(3600 * 25))
}

fun agoToText(seconds: Int): String {
    val minute = 60
    val hour = 60 * 60
    val day = 24 * 60 * 60

    if (seconds in 0..60) {
        return "был(а) только что"
    } else if (seconds in 61..hour) {
        val minutesCount = seconds / minute
        val textMinute = getMinuteText(minutesCount)
        return "был(а) в сети $minutesCount $textMinute назад"
    } else if (seconds in (hour + 1)..day) {
        val hoursCount = seconds / hour
        val textHour = getHourText(hoursCount) //
        return "был(а) в сети $hoursCount $textHour назад"
    } else if (seconds in (day + 1)..(2 * day)) {
        return "был(а) вчера"
    } else if (seconds in (2 * day + 1)..(3 * day)) {
        return "был(а) позавчера"
    } else {
        return "был(а) давно"
    }
}


fun getMinuteText(minutes: Int): String {
    return when (minutes) {
        1, 21, 31, 41, 51 -> "минуту"
        2, 3, 4, 22, 23, 24, 32, 33, 34, 42, 43, 44, 52, 53, 54 -> "минуты"
        else -> "минут"
    }
}


fun getHourText(hours: Int): String {
    return when (hours) {
        1, 21 -> "час"
        2, 3, 4, 22, 23, 24 -> "часа"
        else -> "часов"
    }
}

 // задача 2

//fun main() {
//    println("Комиссия VK Pay: " + calculateCommission(transferSum = 5000))
//    println("Комиссия Visa (минимальная): " + calculateCommission(cardType = "Visa", transferSum = 1000))
//    println("Комиссия Мир (процентная): " + calculateCommission(cardType = "Мир", transferSum = 10000))
//    println("Комиссия MasterCard (в лимите): " + calculateCommission(cardType = "Mastercard", monthlyPastTransfers = 10000, transferSum = 5000))
//    println("Комиссия Maestro (превышение лимита): " + calculateCommission(cardType = "Maestro", monthlyPastTransfers = 74000, transferSum = 5000))
//}
//
//fun calculateCommission(
//    cardType: String = "VK Pay",
//    monthlyPastTransfers: Int = 0,
//    transferSum: Int
//): Int {
//    val mastercardLimit = 75000
//
//    return when (cardType) {
//        "VK Pay" -> 0
//
//        "Mastercard", "Maestro" -> {
//            if (monthlyPastTransfers + transferSum <= mastercardLimit) {
//                0
//            } else {
//                val taxableSum = if (monthlyPastTransfers >= mastercardLimit) {
//                    transferSum
//                } else {
//                    (monthlyPastTransfers + transferSum) - mastercardLimit
//                }
//
//                val commission = (taxableSum * 0.006).toInt() + 20
//                commission
//            }
//        }
//
//        "Visa", "Мир" -> {
//            val calculatedCommission = (transferSum * 0.0075).toInt()
//            if (calculatedCommission < 35) 35 else calculatedCommission
//        }
//
//        else -> 0
//    }
//}
