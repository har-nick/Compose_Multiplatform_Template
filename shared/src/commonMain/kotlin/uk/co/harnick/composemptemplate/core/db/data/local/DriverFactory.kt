package uk.co.harnick.composemptemplate.core.db.data.local

import app.cash.sqldelight.db.SqlDriver
import uk.co.harnick.ComposeMPTemplate.LocalStorage

expect class DriverFactory {
    fun createDriver(): SqlDriver
}

fun createLocalStorage(driverFactory: DriverFactory): LocalStorage {
    val driver = driverFactory.createDriver()
    return LocalStorage(driver)
}
