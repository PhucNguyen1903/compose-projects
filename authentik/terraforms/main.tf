module "grafana" {
  source = "./grafana-authentik"
  grafana_client_secret = var.grafana_client_secret
}