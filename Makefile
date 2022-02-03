infra-up:
	docker-compose -f hack/docker-compose.yml up -d

infra-down:
	docker-compose -f hack/docker-compose.yml down
