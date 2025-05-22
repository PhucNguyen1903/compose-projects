.PHONY: help

help: ## Show help message
		@awk 'BEGIN {FS = ":.*##"; printf "\nUsage:\n  make \033[36m\033[0m\n"} /^[$$()% a-zA-Z_-]+:.*?##/ { printf "  \033[36m%-15s\033[0m %s\n", $$1, $$2 } /^##@/ { printf "\n\033[1m%s\033[0m\n", substr($$0, 5) } ' $(MAKEFILE_LIST)

.DEFAULT_GOAL := help

up: ## Start up docker compose
	docker compose up -d --build

logs: ## Show compose logs
	docker compose logs -f

clean: ## Bring down docker compose
	docker compose down --remove-orphans
