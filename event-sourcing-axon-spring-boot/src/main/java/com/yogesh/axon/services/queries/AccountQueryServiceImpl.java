/* (C)2020 */
package com.yogesh.axon.services.queries;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.axonframework.eventsourcing.eventstore.EventStore;

@RequiredArgsConstructor
public class AccountQueryServiceImpl implements AccountQueryService {
    private final EventStore eventStore;

    @Override
    public List<Object> listEventsForAccount(String accountNumber) {
        return eventStore
                .readEvents(accountNumber)
                .asStream()
                .map(s -> s.getPayload())
                .collect(Collectors.toList());
    }
}
