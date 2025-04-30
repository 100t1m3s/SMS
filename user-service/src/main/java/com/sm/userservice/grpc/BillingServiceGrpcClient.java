package com.sm.userservice.grpc;

import billing.BillingRequest;
import billing.BillingResponse;
import billing.BillingServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class BillingServiceGrpcClient {

    private static final Logger log = LoggerFactory.getLogger(BillingServiceGrpcClient.class);
    private final BillingServiceGrpc.BillingServiceBlockingStub blockingStub;

    //localhost:9001/BillingService/CreateUserAccount
    public BillingServiceGrpcClient(
            @Value("${billing.service.address:localhost}") String severAddress,
            @Value("${billing.service.grpc.port:9001}") int severPort
    ) {

        log.info("Creating BillingServiceGrpcClient at {}:{}" ,severAddress,severPort);

        ManagedChannel channel = ManagedChannelBuilder.forAddress(severAddress, severPort).usePlaintext().build();

        blockingStub = BillingServiceGrpc.newBlockingStub(channel);

    }

    public BillingResponse createBillingAccount(String userId, String name, String email) {

        BillingRequest request = BillingRequest.newBuilder().setUserId(userId).setName(name).setEmail(email).build();
        BillingResponse response = blockingStub.createBillingAccount(request);
        log.info("Received response from BillingService via GRPC: {}", response);
        return response;
    }

}
