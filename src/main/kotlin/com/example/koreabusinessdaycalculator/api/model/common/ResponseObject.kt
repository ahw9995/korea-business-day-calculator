package com.example.koreabusinessdaycalculator.api.model.common

data class ResponseObject<T> (
    val data: T?,
    val result: ResultObject
) {
    constructor(): this(null, ResultObject("1", "success"))
    constructor(data: T): this(data, ResultObject("1", "success"))
    constructor(result: ResultObject): this(null, result)
}
