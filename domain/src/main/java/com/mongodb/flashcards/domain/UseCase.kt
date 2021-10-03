package com.mongodb.flashcards.domain

typealias BusinessRule = () -> Boolean

interface UseCase<DATAIN, DATAOUT> {
    var businessRules: List<BusinessRule>?

    fun checkBusinessRules(): Boolean =
        businessRules?.let { businessRules ->
            !(businessRules.any { it() == false })
        } ?: true

    fun execute(data: DATAIN, completion: (Result<DATAOUT>) -> Unit)
}
