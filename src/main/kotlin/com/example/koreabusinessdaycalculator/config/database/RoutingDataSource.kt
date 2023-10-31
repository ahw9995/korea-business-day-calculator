package com.example.koreabusinessdaycalculator.config.database

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource
import org.springframework.transaction.support.TransactionSynchronizationManager

class RoutingDataSource : AbstractRoutingDataSource() {
    override fun determineCurrentLookupKey() =
        if (TransactionSynchronizationManager.isCurrentTransactionReadOnly()) "slave" else "master"
}