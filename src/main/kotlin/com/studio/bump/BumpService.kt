package com.studio.bump

import org.springframework.stereotype.Service
import kotlin.random.Random

@Service
class BumpService {
    /**
     *  Dummy Location Data 를 위한 임시 method
     */
    fun dummyLocationData(): List<Pair<Double, Double>> {
        val dummyList: MutableList<Pair<Double, Double>> = mutableListOf()
        val northBound = 37.5250
        val southBound = 37.4474
        val eastBound = 127.0850
        val westBound = 127.0138

        for (i in 1..10) {
            val randomLat = southBound + (northBound - southBound) * Random.nextDouble()
            val randomLng = westBound + (eastBound - westBound) * Random.nextDouble()
            dummyList.add(Pair("%.6f".format(randomLat).toDouble(), "%.6f".format(randomLng).toDouble()))
        }

        return dummyList
    }
}