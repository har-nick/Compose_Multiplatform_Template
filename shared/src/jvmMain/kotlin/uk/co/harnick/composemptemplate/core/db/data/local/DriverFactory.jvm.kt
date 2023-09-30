package uk.co.harnick.composemptemplate.core.db.data.local

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import uk.co.harnick.ComposeMPTemplate.LocalStorage

actual class DriverFactory {
    actual fun createDriver(): SqlDriver {
        val driver = JdbcSqliteDriver(JdbcSqliteDriver.IN_MEMORY)
        LocalStorage.Schema.create(driver)
        return driver
    }
}
