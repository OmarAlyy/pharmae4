package com.ekadsoft.pharmae4.Model

class ReportsTargetsAndDonePlansModel(var month: String, target: Int, done: Int) {
    var target = 20
    var done = 100

    init {
        this.target = target
        this.done = done
    }
}