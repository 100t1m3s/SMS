#!/bin/bash

set -e # Stops the scripts if any command fails

aws --endpoint-url=http://localhost:4566 cloudformation deploy \
    --stack-name user-management \
    --template-file "./cdk.out/localstack.template.json"


aws --endpoint-url=http://localhost:4566 elbv2 describe-load-balancers \
    --query "LoadBalancers[0].DNSName" --output text