package com.axzae.homeassistant.shared;

import com.axzae.homeassistant.model.rest.CallServiceRequest;

public interface EntityProcessInterface {
    void callService(final String domain, final String service, CallServiceRequest serviceRequest);
}
