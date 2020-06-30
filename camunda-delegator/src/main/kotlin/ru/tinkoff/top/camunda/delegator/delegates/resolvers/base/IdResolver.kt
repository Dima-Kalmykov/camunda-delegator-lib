package ru.tinkoff.top.camunda.delegator.delegates.resolvers.base

import org.camunda.bpm.engine.delegate.DelegateExecution
import org.springframework.core.MethodParameter
import ru.tinkoff.top.camunda.delegator.delegates.resolvers.DelegateArgumentResolver
import ru.tinkoff.top.camunda.delegator.delegates.resolvers.getAnnotation

class IdResolver : DelegateArgumentResolver {

    override fun supportsParameter(methodParameter: MethodParameter): Boolean {
        return methodParameter.getAnnotation<Id>() != null
    }

    override fun resolveArgument(
        delegateExecution: DelegateExecution,
        methodParameter: MethodParameter
    ): String? {
        return delegateExecution.id
    }
}
