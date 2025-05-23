# Traefik Setup

## Purpose

A free way to learn about reverse proxying and SSL certificate management.

- **Traefik**: Acts as the reverse proxy.
- **Let's Encrypt**: Handles SSL certificate generation and renewal.
- **DuckDNS**: Provides dynamic DNS updates.

## Configuration Files

### `.env.example`

Contains environment variables used by Traefik, including:
- `DUCKDNS_TOKEN`: API token for DuckDNS.
- `TRAEFIK_DASHBOARD_CREDENTIALS`: Credentials for accessing the Traefik dashboard (generated using `htpasswd`).

### `traefik/data/traefik.yml`

Main configuration file for Traefik. Key settings include:
- **API Dashboard**: Enabled with debug mode.
- **Entry Points**: HTTP and HTTPS configured to redirect HTTP traffic to HTTPS.
- **Providers**: Docker is used as the provider to discover services.
- **Certificates Resolvers**: Let's Encrypt is set up with DuckDNS for DNS-based challenges.

### `traefik/docker-compose.yml`

Docker Compose file to run Traefik. Key configurations include:
- **Environment Variables**: Loaded from `.env`.
- **Volumes**: Mounts necessary files and directories.
- **Labels**: Define routing rules, middleware, and TLS settings for the Traefik dashboard.

### `nginx.docker-compose.yml`

Docker Compose file to run Nginx with Traefik as a reverse proxy. Key configurations include:
- **Labels**: Define routing rules, entry points, and TLS settings for Nginx.
